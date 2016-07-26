package com.ipartek.formacion.dbms.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.pojo.CursoAlumnos;
import com.ipartek.formacion.service.Util;

/**
 * Clase que se encarga de gestionar las altas y bajas y modificaciones de los
 * cursos emitidos.
 * 
 * @author Curso
 *
 */

public class CursoAlumnosDAOImp implements CursoAlumnosDAO {
	private static CursoAlumnosDAOImp INSTANCE = null;
	private ConexionDB myConexion = null;
	private static final Logger LOG = Logger.getLogger(CursoAlumnosDAOImp.class);

	private CursoAlumnosDAOImp() {

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
	public void create(CursoAlumnos cursoalumnos) {
		// dar de alta en la tabla curso_emision
		CursoAlumnos aux = null;
		int codCurso = createCursoEmision(cursoalumnos);
		// if(codCurso==CursoAlumnos.CODIGO_CURSO)
		aux = cursoalumnos;
		aux.setCodigoEmitido(codCurso);

		// crear el registro en la tabla calificacion
		crearCursoModuloAlumnos(aux);

	}

	private void crearCursoModuloAlumnos(CursoAlumnos aux) {
		String sql = "{call insertCalificacion(?,?,?)}";
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codCurso", aux.getCodigo());
			for (CursoAlumnos.AlumnoModulo alumModulo : aux.getAlumnosModulos()) {
				cSmt.setInt("codModulo", alumModulo.getModulo().getCodigo());
				cSmt.setInt("codAlumno", alumModulo.getAlumno().getCodigo());
				try {
					cSmt.executeUpdate();
				} catch (SQLException e) {
					LOG.fatal(e.getMessage());
				}
			}
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			myConexion.desconectar();
		}

	}

	private int createCursoEmision(CursoAlumnos cursoalumnos) {
		int codigoCursoEmision = CursoAlumnos.CODIGO_CURSO;
		String sql = "{call insertCursoEmision(?,?,?,?,?)}";

		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codCurso", cursoalumnos.getCodigoEmitido());
			cSmt.setString("referencia", cursoalumnos.getReferencia());
			cSmt.setDate("fInicio", new java.sql.Date(cursoalumnos.getFechaInicio().getTime()));
			try {
				// Para capturar la fecha fin como null
				Date fFin = null;
				fFin = cursoalumnos.getFechaFin();
				cSmt.setDate("fFin", new java.sql.Date(fFin.getTime()));
			} catch (NullPointerException e) {
				LOG.trace(e.getMessage());
				cSmt.setDate("fFin", null);
			}
			cSmt.executeUpdate();
			codigoCursoEmision = cSmt.getInt("codigo_emision");
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
			codigoCursoEmision = CursoAlumnos.CODIGO_CURSO;
		} finally {
			myConexion.desconectar();
		}

		return codigoCursoEmision;
	}

	@Override
	public void deleteEmitidos(int codCurso) {
		// Si queremos borrar un registro de las dos tablas

	}

	@Override
	public void update(CursoAlumnos cursoalumnos) {
		updateCursoEmision(cursoalumnos);
		updateCalificacion(cursoalumnos);

	}

	private void updateCursoEmision(CursoAlumnos cursoalumnos) {
		String sql = "updateCursoEmision(?,?,?,?,?)";
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codCurso", cursoalumnos.getCodigoEmitido());
			cSmt.setInt("codigoCurso", cursoalumnos.getCodigo());
			cSmt.setString("referencia", cursoalumnos.getReferencia());
			cSmt.setDate("fInicio", new java.sql.Date(cursoalumnos.getFechaInicio().getTime()));
			try {
				cSmt.setDate("fFin", new java.sql.Date(cursoalumnos.getFechaInicio().getTime()));
			} catch (NullPointerException e) {
				LOG.fatal(e.getMessage() + " fecha fin nula");
				cSmt.setDate("fFin", null);
			}
			cSmt.executeUpdate();
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			myConexion.desconectar();
		}

	}

	private void updateCalificacion(CursoAlumnos cursoalumnos) {
		String sql = "{call updateCalificacion(?,?,?,?,?)}";
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codigoCurso", cursoalumnos.getCodigoEmitido());
			for (CursoAlumnos.AlumnoModulo alumModulo : cursoalumnos.getAlumnosModulos()) {
				cSmt.setInt("codigoModulo", alumModulo.getModulo().getCodigo());
				cSmt.setInt("codigoAlumno", alumModulo.getAlumno().getCodigo());
				try {
					cSmt.setDate("fExamen", new java.sql.Date(alumModulo.getfExamen().getTime()));
					cSmt.setInt("nota", alumModulo.getNotaExamen());
				} catch (NullPointerException e) {
					LOG.trace(e.getMessage() + " fecha del examen sin fijar");
					cSmt.setDate("fExamen", null);
					cSmt.setInt("nota", 0);
				}
				cSmt.executeUpdate();
			}

			cSmt.executeUpdate();
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			myConexion.desconectar();
		}

	}

	@Override
	public CursoAlumnos getById(int codCurso) {
		CursoAlumnos ca = null;

		return ca;
	}

	@Override
	public List<CursoAlumnos> getAll() {
		String sql = "{call getAllCursosEmitidos()}";
		List<CursoAlumnos> cursoAlumnos = null;
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			ResultSet rs = cSmt.executeQuery();
			cursoAlumnos = new ArrayList<CursoAlumnos>();
			while (rs.next()) {
				CursoAlumnos cAlumnos = parseCursoAlumnos(rs);
				cursoAlumnos.add(cAlumnos);
			}
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			myConexion.desconectar();
		}

		return cursoAlumnos;
	}

	private CursoAlumnos parseCursoAlumnos(ResultSet rs) {
		CursoAlumnos cAlumnos = null;
		try {
			cAlumnos = new CursoAlumnos();
			cAlumnos.setCodigo(rs.getInt("codigo"));
			cAlumnos.setCodigoEmitido(rs.getInt("codigoEmitido"));
			cAlumnos.setCodPatrocinador(rs.getString("codPatrocinador"));
			cAlumnos.setNombre(rs.getString("nombre"));
			cAlumnos.setReferencia(rs.getString("referencia"));
			cAlumnos.setFechaInicio(rs.getDate("fInicio"));
			cAlumnos.setFechaFin(rs.getDate("fFin"));
			String codigo = rs.getString("codigoTipoCurso");
			cAlumnos.setTipo(Util.parseTipoCurso(codigo));
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		}

		return cAlumnos;
	}

	@Override
	public CursoAlumnos getByAlumnoId(int codAlumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addModulosAlumnos(CursoAlumnos cursoalumnos) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCalificacion(CursoAlumnos cursoAlumnos) {
		// TODO Auto-generated method stub

	}

}
