package com.ipartek.formacion.dbms.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.pojo.CursoAlumnos;

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
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(CursoAlumnos cursoalumnos) {
		// dar de alta en la tabla curso_emision.

		CursoAlumnos aux = null;
		int codigoCurso = createCursoEmision(cursoalumnos);
		aux = cursoalumnos;
		aux.setCodigo(codigoCurso);

		// crear el registro en la tabla de calificacion.

		crearCursoModuloALumnos(aux);

	}

	private void crearCursoModuloALumnos(CursoAlumnos aux) {
		// TODO Auto-generated method stub

	}

	private int createCursoEmision(CursoAlumnos cursoalumnos) {
		int codigo = CursoAlumnos.CODIGO_CURSO_ALUMNO;
		String sql = "{call insertCursoEmision(?,?,?,?,?)}";

		try {
			CallableStatement cSmt = myconexion.getConexion().prepareCall(sql);
			ResultSet rs = cSmt.executeQuery();
			cSmt.setInt("codCurso", cursoalumnos.getCodigo());
			cSmt.setString("referencia", cursoalumnos.getReferencia());
			cSmt.setDate("fInicio", new java.sql.Date(cursoalumnos.getFechaInicio().getTime()));
			cSmt.setDate("fFin", new java.sql.Date(cursoalumnos.getFechaFin().getTime()));
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} catch (NullPointerException e) {

		} finally {
		}
		myconexion.desconectar();
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
		// TODO Auto-generated method stub
		return null;
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
