package com.ipartek.formacion.dbms.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.pojo.CursoAlumnos;
import com.ipartek.formacion.pojo.CursoAlumnos.AlumnoModulo;
import com.ipartek.formacion.services.Util;

/**
 * 
 * Las altas, bajas y modificaciones en los cursos emitidos.
 * 
 * 
 * 
 * @author Josu.
 *
 */
public class CursoAlumnosDAOImp implements CursoAlumnosDAO {

	private static final Logger LOG = Logger.getLogger(CursoAlumnosDAOImp.class);
	private ConexionDB myconexion = null;
	private static CursoAlumnosDAOImp INSTANCE = null;

	private CursoAlumnosDAOImp() {
		myconexion = ConexionDBImp.getInstance();
	}

	public static CursoAlumnosDAOImp getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CursoAlumnosDAOImp();
		}
	}

	@Override
	public CursoAlumnos getByID(int codigoCurso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(CursoAlumnos cursoalumnos) {
		// primero update de curso
		updateCursoEmision(cursoalumnos);

		// update de modulo y alumnos

		updateCalificacion(cursoalumnos);

	}

	private void updateCalificacion(CursoAlumnos cursoalumnos) {
		String sql = "{call updateCalificacion(?,?,?,?,?)}";
		try {
			CallableStatement cSmt = myconexion.getConexion().prepareCall(sql);

			cSmt.setInt("codigoCurso", cursoalumnos.getCodigoEmitido());
			// es el mismo para todos, recorremos un bucle for para meter a
			// todos los usuarios es codCurso. Lo llamamos diferente para que no
			// casque en la sentencia where

			for (AlumnoModulo alumnoModulo : cursoalumnos.getAlumnosmodulos()) {
				cSmt.setInt("codigoModulo", alumnoModulo.getModulo().getCodigo());
				// es codModulo, lo llamamos asi para que no falle en la
				// sentencia where
				cSmt.setInt("codigoAlumno", alumnoModulo.getAlumno().getCodigo());
				// es codAlumnolo, llamamos asi para que no falle en la
				// sentencia where
				try {
					Date fExamen = null;
					fExamen = alumnoModulo.getfExamen();
					cSmt.setDate("fFin", new java.sql.Date(fExamen.getTime()));
					cSmt.setInt("nota", alumnoModulo.getNotaExamen());
					// si la fecha es nula, no hay nota
				} catch (NullPointerException e) {
					LOG.fatal(e.getMessage());
					LOG.trace("Error NULL en fecha examen, es posible que no tengamos fecha del examen");
					cSmt.setDate("fExamen", null);
					cSmt.setInt("nota", 0);
				}
				try {
					cSmt.executeUpdate();
				} catch (SQLException e) {
					LOG.fatal(e.getMessage());
				}
			} // si la tabla tiene longitud 0, no ejecuta el executeUpdate, la
				// BBDD no actualizaria ya que no entra en el for.

		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			myconexion.desconectar();
		}

	}

	private void updateCursoEmision(CursoAlumnos cursoalumnos) {
		String sql = "{call updateCursoEmision(?,?,?,?,?)}";

		try {
			CallableStatement cSmt = myconexion.getConexion().prepareCall(sql);

			cSmt.setInt("codigoCurso", cursoalumnos.getCodigo());
			// es codigo en la BBDD, no mandamos con el mismo nombre por
			// posibles errores y problemas que da algunas veces
			cSmt.setInt("codCurso", cursoalumnos.getCodigoEmitido());
			cSmt.setString("referencia", cursoalumnos.getReferencia());
			cSmt.setDate("fInicio", new java.sql.Date(cursoalumnos.getFechaInicio().getTime()));

			try {
				Date fFin = null;
				fFin = cursoalumnos.getFechaFin();
				cSmt.setDate("fFin", new java.sql.Date(fFin.getTime()));
			} catch (NullPointerException e) {
				LOG.fatal(e.getMessage());
				LOG.trace("Error NULL en fecha fin, es posible que no tengamos fecha fin");
				cSmt.setDate("fFin", null);
			}
			cSmt.executeUpdate();
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			myconexion.desconectar();
		}
	}

	@Override
	public void insert(CursoAlumnos cursoalumnos) {
		// dar de alta en la tabla curso_emision.

		CursoAlumnos aux = null;
		int codigoCurso = createCursoEmision(cursoalumnos);
		aux = cursoalumnos;
		aux.setCodigo(codigoCurso);
		// if (codigoCurso == CursoAlumnos.CODIGO_CURSO_ALUMNO) //aqui
		// comprobaremos el error de creacion

		// crear el registro en la tabla de calificacion. Solo si la lista es
		// mayor que 0

		crearCursoModuloALumnos(aux);

	}

	private void crearCursoModuloALumnos(CursoAlumnos aux) {
		// TODO Auto-generated method stub
		String sql = "{call insertCalificacion(?,?,?)}";
		try {
			CallableStatement cSmt = myconexion.getConexion().prepareCall(sql);

			cSmt.setInt("codCurso", aux.getCodigo()); // es el mismo para todos,
														// recorremos un bucle
														// for para meter a
														// todos los usuarios

			for (AlumnoModulo alumnoModulo : aux.getAlumnosmodulos()) {
				cSmt.setInt("codModulo", alumnoModulo.getModulo().getCodigo());
				cSmt.setInt("codAlumno", alumnoModulo.getAlumno().getCodigo());
				try {
					cSmt.executeUpdate();
				} catch (SQLException e) {
					LOG.fatal(e.getMessage());
				}
			} // si la tabla tiene longitud 0, no ejecuta el executeUpdate, la
				// BBDD no actualizaria ya que no entra en el for.

		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			myconexion.desconectar();
		}
	}

	private int createCursoEmision(CursoAlumnos cursoalumnos) {
		int codigo = CursoAlumnos.CODIGO_CURSO_ALUMNO;
		String sql = "{call insertCursoEmision(?,?,?,?,?)}";

		try {
			CallableStatement cSmt = myconexion.getConexion().prepareCall(sql);

			cSmt.setInt("codCurso", cursoalumnos.getCodigo());
			cSmt.setString("referencia", cursoalumnos.getReferencia());
			cSmt.setDate("fInicio", new java.sql.Date(cursoalumnos.getFechaInicio().getTime()));

			try {
				Date fFin = null;
				fFin = cursoalumnos.getFechaFin();
				cSmt.setDate("fFin", new java.sql.Date(fFin.getTime()));
			} catch (NullPointerException e) {
				LOG.fatal(e.getMessage());
				LOG.trace("Error NULL en fecha fin");
				cSmt.setDate("fFin", null);
			}
			cSmt.executeUpdate();
			codigo = cSmt.getInt("codigo_emision");
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
			codigo = CursoAlumnos.CODIGO_CURSO_ALUMNO;
		} finally {
			myconexion.desconectar();
		}
		return codigo;

	}

	@Override
	public void deleteEmitido(int codigoCurso) {
		// cuidado con las delete en cascada, haremos dos deletes para evitar
		// cargarte datos que no deberiamos.
		// crear el registro en la tabla de calificacion.
		// dar de alta en la tabla curso_emision.
	}

	@Override
	public List<CursoAlumnos> getAll() {
		// es una consulta a la tabla cursoEmision, es posible necesitar
		// informacion de la tabla curso.
		String sql = "{call getAllCursosEmitidos()}";
		List<CursoAlumnos> cursoAlumnos = null;

		try {
			CallableStatement cSmt = myconexion.getConexion().prepareCall(sql);

			ResultSet rs = cSmt.executeQuery();
			cursoAlumnos = new ArrayList<CursoAlumnos>();
			while (rs.next()) {
				CursoAlumnos cAlumnos = parseCursoAlumnos(rs);
				cursoAlumnos.add(cAlumnos);
			}

		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			myconexion.desconectar();
		}

		return cursoAlumnos;
	}

	private CursoAlumnos parseCursoAlumnos(ResultSet rs) {
		CursoAlumnos cAlumno = null;
		cAlumno = new CursoAlumnos();
		try {
			cAlumno.setCodigo(rs.getInt("codigo"));
			cAlumno.setCodigoEmitido(rs.getInt("codigoEmitido"));
			cAlumno.setReferencia(rs.getString("referencia"));
			// cAlumno.setcodigoPatrocinador(rs.getString("codigoPatrocinador"));
			cAlumno.setNombre(rs.getString("nombre"));
			cAlumno.setFechaInicio(rs.getDate("fInicio"));
			cAlumno.setFechaFin(rs.getDate("fFin"));
			// volcar un null no deberia dar problemas
			cAlumno.setTc(Util.parseTipo(String.valueOf(rs.getInt("codTipoCurso"))));

		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		}

		return cAlumno;
	}

	@Override
	public CursoAlumnos getByAlumnoId(int codigoalumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCalificacion(int codigoCurso) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addModulosAlumnos(CursoAlumnos cursoalumnos) {
		// TODO Auto-generated method stub

	}

}
