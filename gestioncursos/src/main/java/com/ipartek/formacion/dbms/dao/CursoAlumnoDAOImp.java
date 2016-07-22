package com.ipartek.formacion.dbms.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.dbms.ConexionDBImp;

/**
 * 
 * 
 */

import com.ipartek.formacion.pojo.CursoAlumnos;

public class CursoAlumnoDAOImp implements CursoAlumnoDAO{
	private static final Logger LOG = Logger.getLogger(CursoAlumnoDAOImp.class);
	private static ConexionDB myConexion;
	private Connection conexion;
	private static CursoAlumnoDAOImp INSTANCE=null;

	private CursoAlumnoDAOImp(){
		myConexion = ConexionDBImp.getInstance(); //al crear una instancia, se realiza la conexion
		
	}
	
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CursoAlumnoDAOImp();
		}
	}

	public static CursoAlumnoDAOImp getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}
	
	

	@Override
	public void create(CursoAlumnos cursoalumnos) {
		// dar de alta en la tabla curso_emision
		CursoAlumnos aux = null;
		int codigoCurso = createCursoEmision(cursoalumnos);
		aux = cursoalumnos;
		aux.setCodigoEmitido(codigoCurso);
		//crear el registro en la tabla calificación
		crearCursoModuloAlumnos(aux);
	}

	private void crearCursoModuloAlumnos(CursoAlumnos aux) {
		// TODO Auto-generated method stub
		
	}

	private int createCursoEmision(CursoAlumnos cursoalumnos) {
		int codigoCursoEmision = CursoAlumnos.CODIGO_CURSO;
		CursoAlumnos curso = null;
		String sql = "{call insertCursoEmision (?,?,?,?,?)}";
		
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codigo", cursoalumnos.getCodigo());
			cSmt.setInt("codCurso", cursoalumnos.getCodigoEmitido());
			cSmt.setString("referencia", cursoalumnos.getReferencia());
			cSmt.setDate("fInicio", new java.sql.Date(cursoalumnos.getFechaInicio().getTime()));
			try{//si la fecha NO ES NULL
			cSmt.setDate("fFin", new java.sql.Date(cursoalumnos.getFechaFin().getTime()));
			}catch(SQLException e){//SI LA FECHA ES NULL
				
			}
		} catch (SQLException e) {
			curso = getById(cursoalumnos.getCodigo());
			LOG.fatal(e.getMessage());
		}finally{
			myConexion.desconectar();
		}
		
		return codigoCursoEmision;
	}

	@Override
	public CursoAlumnos getById(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(CursoAlumnos cursoalumnos) {
		// si queremos borrar un registro de las dos tablas 
		
	}

	@Override
	public void delete(int codigo) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void deleteEmitidos(int codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCalificacion(CursoAlumnos cursoalumnos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CursoAlumnos> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CursoAlumnos getByAlumnoId(int codigoAlumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addModulosAlumnos(CursoAlumnos cursoalumnos) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

	

}
