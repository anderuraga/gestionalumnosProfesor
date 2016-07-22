package com.ipartek.formacion.dbms.dao;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.pojo.CursoAlumnos;

public class CursoAlumnosDAOImp implements CursoAlumnosDAO {

	private static final Logger LOG = Logger.getLogger(CursoAlumnosDAOImp.class);
	private ConexionDBImp myConexion;
	private static CursoAlumnosDAOImp INSTANCE = null;
	
	private CursoAlumnosDAOImp(){
		myConexion = ConexionDBImp.getInstance();
	}
	
	private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new CursoAlumnosDAOImp();
        }
    }

    public static CursoAlumnosDAOImp getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
	
	@Override
	public void create(CursoAlumnos cursoalumnos) {
		// Dar de alta en la tabla curso_emision
		
		CursoAlumnos aux = null;
		int codigoCurso = createCursoEmision(cursoalumnos);
		aux = cursoalumnos;
		aux.setCodigoEmitido(codigoCurso);
		
		// Crear el registro en la tabla calificacion
		crearCursoModuloAlumnos(aux);
	}

	private void crearCursoModuloAlumnos(CursoAlumnos aux) {
		
	}

	private int createCursoEmision(CursoAlumnos cursoalumnos) {
		int codigoCursoemision = CursoAlumnos.CODIGO_CURSO;
		String sql = "call insertCurso_emision(?, ?, ?, ?, ?)";
		
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codCurso", cursoalumnos.getCodigo());
			cSmt.setString("referencia", cursoalumnos.getReferencia());
			cSmt.setDate("fInicio", new java.sql.Date(cursoalumnos.getFechaInicio().getTime()));
			cSmt.setDate("fFin", new java.sql.Date(cursoalumnos.getFechaFin().getTime()));
		} catch (SQLException e) {
			LOG.error("Error SQLException:" + e.getMessage());
		} finally{
			myConexion.desconectar();
		}
		
		return codigoCursoemision;
	}

	@Override
	public void addModulosAlumnos(CursoAlumnos cursoalumnos) {
		
	}

	@Override
	public void deleteEmitidos(int codigoCurso) {
		// Si queremos borrar un registro de las dos tablas
	}
	
	@Override
	public void deleteCalificacion(CursoAlumnos cursoalumnos) {
		
	}

	@Override
	public void update(CursoAlumnos cursoalumnos) {
		
	}

	@Override
	public CursoAlumnos getById(int codigoCurso) {
		
		return null;
	}

	@Override
	public List<CursoAlumnos> getAll() {
		
		return null;
	}

	@Override
	public CursoAlumnos getByAlumnoId(int codigoAlumno) {
		
		return null;
	}
}
