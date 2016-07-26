package com.ipartek.formacion.dbms.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.pojo.Alumno;

/**
 * 
 * 
 */

import com.ipartek.formacion.pojo.CursoAlumnos;
import com.ipartek.formacion.pojo.CursoAlumnos.AlumnoModulo;
import com.ipartek.formacion.service.Util;

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
		//if (codigoCurso == cursoalumnos.CODIGO_CURSO_ALUMNO)
		aux = cursoalumnos;
		aux.setCodigoEmitido(codigoCurso);
		//crear el registro en la tabla calificación
		crearCursoModuloAlumnos(aux);
	}

	private void crearCursoModuloAlumnos(CursoAlumnos aux) {
		String sql = "{call insertCalificacion (?,?,?) }"; //al crear el registro solo insertamos los campos clave (para insertar la nota y fExamen haremos update)
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codCurso", aux.getCodigoEmitido());
			for(AlumnoModulo alumModulo : aux.getAlumnosmodulos()){
				cSmt.setInt("codModulo", alumModulo.getModulo().getCodigo());
				cSmt.setInt("codAlumno", alumModulo.getAlumno().getCodigo());
				try{
				cSmt.executeUpdate();
				}catch(SQLException e){
					LOG.fatal(e.getMessage());
				}
			}
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		}finally{
			myConexion.desconectar();
		}
		
	}

	private int createCursoEmision(CursoAlumnos cursoalumnos) {
		int codigoCursoEmision = CursoAlumnos.CODIGO_CURSO;
		String sql = "{call insertCursoEmision (?,?,?,?,?)}";
		
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codigo", cursoalumnos.getCodigo());
			cSmt.setInt("codCurso", cursoalumnos.getCodigoEmitido());
			cSmt.setString("referencia", cursoalumnos.getReferencia());
			cSmt.setDate("fInicio", new java.sql.Date(cursoalumnos.getFechaInicio().getTime()));
			try{//si la fecha NO ES NULL
				Date fFin = null;
				fFin = cursoalumnos.getFechaFin();
				cSmt.setDate("fFin", new java.sql.Date(cursoalumnos.getFechaFin().getTime()));
			}catch(NullPointerException e){//SI LA FECHA ES NULL 
					LOG.trace(e.getMessage());
					cSmt.setDate("fFIN", null);
			}
			cSmt.executeUpdate();
			codigoCursoEmision = cSmt.getInt("codigo_emision");
			
		} catch (SQLException e) {
			codigoCursoEmision = CursoAlumnos.CODIGO_CURSO;
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
		updateCursoEmision(cursoalumnos);
		updateCalificacion(cursoalumnos);
		
	}

	private void updateCalificacion(CursoAlumnos cursoalumnos) {
		String sql = "{call updateCalificacion(?,?,?,?,?)}";
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codigoCurso", cursoalumnos.getCodigoEmitido());
			for(AlumnoModulo alumMod : cursoalumnos.getAlumnosmodulos()){
				cSmt.setInt("codModulo", alumMod.getModulo().getCodigo());
				cSmt.setInt("codAlumno", alumMod.getAlumno().getCodigo());
				
				try{
					cSmt.setDate("fExamen", new java.sql.Date(alumMod.getfExamen().getTime())); //si la fecha del examen es null, no habrá nota del examen
					cSmt.setInt("nota", alumMod.getNotaExamen());
					
				}catch(NullPointerException e){
					LOG.trace(e.getMessage() + "sin fecha examen");
					cSmt.setDate("fExamen", null); 
					cSmt.setInt("nota", 0);
				}
				cSmt.executeUpdate();
			}
		} catch (SQLException e) {
			LOG.trace(e.getMessage());
		}finally{
			myConexion.desconectar();
		}
		
	}

	private void updateCursoEmision(CursoAlumnos cursoalumnos) {
		String sql = "{call updateCursoEmision(?,?,?,?,?)}";
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codCurso", cursoalumnos.getCodigo());
			cSmt.setInt("codigoCurso", cursoalumnos.getCodigoEmitido());
			cSmt.setString("referencia", cursoalumnos.getReferencia());
			cSmt.setDate("fInicio", new java.sql.Date(cursoalumnos.getFechaInicio().getTime()));
			try{
				cSmt.setDate("fFin", new java.sql.Date(cursoalumnos.getFechaFin().getTime()));
			}catch(NullPointerException e){
				LOG.trace(e.getMessage() + " SIN FECHA FIN");
				cSmt.setDate("fFin", null);
			}
			cSmt.executeUpdate();
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		}finally{
			myConexion.desconectar();
		}
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
		String sql = "{call getAllCursosEmitidos(?,?,?,?)}";
		List<CursoAlumnos> cursoAlumnos = null;
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			ResultSet rs = cSmt.executeQuery();
			cursoAlumnos = new ArrayList<CursoAlumnos>();
			while(rs.next()){
				CursoAlumnos cAlumnos = parseCursoAlumnos(rs);
				cursoAlumnos.add(cAlumnos);
			}
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		}finally{
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
			cAlumnos.setReferencia(rs.getString("codigoPatrocinador"));
			cAlumnos.setNombre(rs.getString("nombre"));
			cAlumnos.setFechaInicio(rs.getDate("fInicio"));
			cAlumnos.setFechaFin(rs.getDate("fFin"));
			int codigo = rs.getInt("codigoTipoCurso");
			cAlumnos.setTipo(Util.parseTipoCurso(codigo));
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		}
		
		return cAlumnos;
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
