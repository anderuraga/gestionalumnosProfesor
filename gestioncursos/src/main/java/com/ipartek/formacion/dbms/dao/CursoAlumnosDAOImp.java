package com.ipartek.formacion.dbms.dao;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.pojo.CursoAlumnos;

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
		aux = cursoalumnos;
		aux.setCodigoEmitido(codCurso);

		// crear el registro en la tabla calificacion
		crearCursoModuloAlumnos(aux);

	}

	private void crearCursoModuloAlumnos(CursoAlumnos aux) {
		// TODO Auto-generated method stub

	}

	private int createCursoEmision(CursoAlumnos cursoalumnos) {
		int codigoCursoEmision = CursoAlumnos.CODIGO_CURSO;
		String sql = "{call insertCursoEmision(?,?,?,?,?)}";

		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codCurso", cursoalumnos.getCodigo());
			cSmt.setString("referencia", cursoalumnos.getReferencia());
			cSmt.setDate("fInicio", new java.sql.Date(cursoalumnos.getFechaInicio().getTime()));
			cSmt.setDate("fFin", new java.sql.Date(cursoalumnos.getFechaFin().getTime()));
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
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
		// TODO Auto-generated method stub

	}

	@Override
	public CursoAlumnos getById(int codCurso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CursoAlumnos> getAll() {
		// TODO Auto-generated method stub
		return null;
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
