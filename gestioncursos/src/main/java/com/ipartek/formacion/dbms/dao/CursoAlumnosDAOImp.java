package com.ipartek.formacion.dbms.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.pojo.CursoAlumnos;
import com.ipartek.formacion.pojo.CursoAlumnos.AlumnoModulo;
import com.ipartek.formacion.service.Util;

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
		String sql = "{call insertCalificacion(?, ?, ?)}";
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codCurso", aux.getCodigoEmitido());
			
			for(AlumnoModulo alumModulo: aux.getAlumnosmodulos()){
				cSmt.setInt("codAlumno", alumModulo.getAlumno().getCodigo());
				cSmt.setInt("codModulo", alumModulo.getModulo().getCodigo());
				cSmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			LOG.error("Error SQLException:" + e.getMessage());
		} finally{
			myConexion.desconectar();
		}
	}

	private int createCursoEmision(CursoAlumnos cursoalumnos) {
		int codigoCursoemision = CursoAlumnos.CODIGO_CURSO;
		String sql = "{call insertCurso_emision(?, ?, ?, ?, ?)}";
		
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codCurso", cursoalumnos.getCodigo());
			cSmt.setString("referencia", cursoalumnos.getReferencia());
			cSmt.setDate("fInicio", new java.sql.Date(cursoalumnos.getFechaInicio().getTime()));

			try{
				Date fFin = null;
				fFin = cursoalumnos.getFechaFin();
				cSmt.setDate("fFin", new java.sql.Date(fFin.getTime()));
			} catch(NullPointerException e){
				LOG.error("Error NullPointerException:" + e.getMessage());
				cSmt.setDate("fFin", null);
			}
			
			cSmt.executeUpdate();
			codigoCursoemision = cSmt.getInt("codigo_emision");
			
		} catch (SQLException e) {
			LOG.error("Error SQLException:" + e.getMessage());
			codigoCursoemision = CursoAlumnos.CODIGO_CURSO;
		} finally{
			myConexion.desconectar();
		}
		
		return codigoCursoemision;
	}

	@Override
	public void addModulosAlumnos(CursoAlumnos cursoalumnos) {
		updateCursoEmision(cursoalumnos);
		updateCalificacion(cursoalumnos);
	}

	private void updateCalificacion(CursoAlumnos cursoalumnos) {
		String sql = "{call updateCalificacion(?, ?, ?, ?, ?)}";
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codigoCurso", cursoalumnos.getCodigoEmitido());
			
			for(AlumnoModulo alumModulo: cursoalumnos.getAlumnosmodulos()){
				cSmt.setInt("codigoAlumno", alumModulo.getAlumno().getCodigo());
				cSmt.setInt("codigoModulo", alumModulo.getModulo().getCodigo());
				
				try{
					cSmt.setDate("fExamen", new java.sql.Date(alumModulo.getfExamen().getTime()));
					cSmt.setInt("nota", alumModulo.getNotaExamen());
				} catch(NullPointerException e){
					LOG.trace("Error NullPointerException:" + e.getMessage());
					cSmt.setDate("fExamen", null);
					cSmt.setInt("nota", 0);
				}

				cSmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			LOG.error("Error SQLException:" + e.getMessage());
		} finally{
			myConexion.desconectar();
		}
	}

	private void updateCursoEmision(CursoAlumnos cursoalumnos) {
		String sql = "{call updateCursoEmision(?, ?, ?, ?, ?)}";
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codCurso", cursoalumnos.getCodigo());
			cSmt.setInt("codigoCurso", cursoalumnos.getCodigoEmitido());
			cSmt.setString("referencia", cursoalumnos.getReferencia());
			cSmt.setDate("fInicio", new java.sql.Date(cursoalumnos.getFechaInicio().getTime()));
			
			try{
				cSmt.setDate("fFin", new java.sql.Date(cursoalumnos.getFechaFin().getTime()));
			} catch(NullPointerException e){
				LOG.error("Error NullPointerException:" + e.getMessage());
				cSmt.setDate("fFin", null);
			}
			
		} catch (SQLException e) {
			LOG.error("Error SQLException:" + e.getMessage());
		} finally{
			myConexion.desconectar();
		}
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
		String sql = "{call getAllCursosEmitidos()}";
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
			LOG.error("Error SQLException:" + e.getMessage());
		} finally{
			myConexion.desconectar();
		}
		
		
		return cursoAlumnos;
	}

	private CursoAlumnos parseCursoAlumnos(ResultSet rs) {
		CursoAlumnos cAlumnos = null;
		
		cAlumnos = new CursoAlumnos();
		try {
			cAlumnos.setCodigo(rs.getInt("codigo"));
			cAlumnos.setCodigoEmitido(rs.getInt("codigoEmitido"));
			cAlumnos.setCodigoPatrocinador(rs.getString("codigoPatrocinador"));
			cAlumnos.setNombre(rs.getString("nombre"));
			cAlumnos.setReferencia(rs.getString("referencia"));
			cAlumnos.setFechaInicio(rs.getDate("fechaInicio"));
			cAlumnos.setFechaFin(rs.getDate("fechaFin"));
			
			int codigo = rs.getInt("codigoTipoCurso");
			cAlumnos.setTipoCurso(Util.parseTipoCurso(codigo));
		} catch (SQLException e) {
			LOG.error("Error SQLException:" + e.getMessage());
		}
		
		return cAlumnos;
	}

	@Override
	public CursoAlumnos getByAlumnoId(int codigoAlumno) {
		
		return null;
	}
}
