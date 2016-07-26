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
import com.ipartek.formacion.service.Util;
/**
 * Clase encargada de gestionar las altas, bajas y modificaciones en los cursos emitidos.
 * @author Curso
 *
 */
public class CursoAlumnosDAOImp implements CursoAlumnosDAO{
	 private static final Logger LOG = Logger.getLogger(CursoAlumnosDAOImp.class);
	 private ConexionDB myConexion;
	 private static CursoAlumnosDAOImp INSTANCE;
	 
	 

	 private CursoAlumnosDAOImp() {
			myConexion = ConexionDBImp.getInstance();
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

		protected Object clone() throws CloneNotSupportedException {
			throw new CloneNotSupportedException();
		}
	
	public void create(CursoAlumnos cursoalumnos) {
		// dar de alta en la tabla curso_emision
		
		CursoAlumnos aux = null;
		int codigoCurso = createCursoEmision(cursoalumnos);
		//if(codigoCurso == CursoAlumnos.CODIGO_CURSO)
		aux = cursoalumnos;
		aux.setCodigoEmitido(codigoCurso);
		
		//crear el registro en la tabla calificacion
		crearCursoModulosAlumnos(aux);
		
	}
	
	private void crearCursoModulosAlumnos(CursoAlumnos aux) {
		String sql = "{call insertCalificacion(?,?,?,?)}";
		
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codCurso", aux.getCodigo());
			for(AlumnoModulo alumModulo: aux.getAlumnosmodulos()){
				cSmt.setInt("codModulo",alumModulo.getModulo().getCodigo());
				cSmt.setInt("codAlumno", alumModulo.getAlumno().getCodigo());
				try{
					cSmt.executeUpdate();
				}catch (SQLException e) {
					LOG.fatal(e.getMessage() + " -- Error al añadir alumnos al curso");
				}
			}
		}catch (SQLException e) {
			LOG.fatal(e.getMessage() + " -- Error");
		}finally{
			myConexion.desconectar();
		}
	}

	private int createCursoEmision(CursoAlumnos cursoalumnos) {
		int codigoCursoemision= CursoAlumnos.CODIGO_CURSO;
		String sql = "{call insertCurso_emision(?,?,?,?,?)}";
		
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codigo", cursoalumnos.getCodigo());
			cSmt.setString("referencia", cursoalumnos.getReferencia());
			cSmt.setDate("fInicio", new java.sql.Date(cursoalumnos.getFechaInicio().getTime()));
			Date fFin = null;
			try{
				fFin = cursoalumnos.getFechaFin();
				cSmt.setDate("fFin", new java.sql.Date(fFin.getTime()));
			}
			catch(NullPointerException e){
				LOG.trace(e.getMessage());
				cSmt.setDate("fFin", null);
			}
			cSmt.executeUpdate();
			codigoCursoemision = cSmt.getInt("codigo_emision");
		}catch (SQLException e) {
			LOG.fatal(e.getMessage() + " -- Error al crear el curso");
			codigoCursoemision = CursoAlumnos.CODIGO_CURSO;
		} finally {
			myConexion.desconectar();
		}
		
		return codigoCursoemision;
	}

	public List<CursoAlumnos> getById(int codigoCurso) {
		
		return null;
	}

	
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
		}catch (SQLException e) {
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
			cAlumnos.setCodigoPatrocinador(rs.getString("codigoPatrocinador"));
			cAlumnos.setNombre(rs.getString("nombre"));
			cAlumnos.setReferencia(rs.getString("referencia"));
			cAlumnos.setFechaInicio(rs.getDate("fInicio"));
			cAlumnos.setFechaFin(rs.getDate("fFin"));
			int codigo = rs.getInt("codigoTipoCurso");
//			cAlumnos.setTipo(Util.parseTipoCurso(codigo));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cAlumnos;
	}

	public CursoAlumnos getByAlumnoId(int codigoAlumno) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void update(CursoAlumnos cursoalumnos) {
		updateCursoEmision(cursoalumnos);
		updateCalificacion(cursoalumnos);
		
	}

	
	private void updateCursoEmision(CursoAlumnos cursoalumnos) {
		String sql =  "{call updateCursoEmision(?,?,?,?,?)}";
		
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codCurso", cursoalumnos.getCodigo());
			cSmt.setInt("codigoCurso",cursoalumnos.getCodigoEmitido());
			cSmt.setString("referencia", cursoalumnos.getReferencia());
			cSmt.setDate("fInicio", new java.sql.Date(cursoalumnos.getFechaInicio().getTime()));
			
			try{
				cSmt.setDate("fFin", new java.sql.Date(cursoalumnos.getFechaFin().getTime()));
			}catch(NullPointerException e){
				LOG.trace(e.getMessage() + "Sin fecha fin");
				cSmt.setDate("fFin", null);
			}
			
			cSmt.executeUpdate();
			
		}catch (SQLException e) {
			LOG.fatal(e.getMessage());
			
		} finally {
			myConexion.desconectar();
		}		
	}

	private void updateCalificacion(CursoAlumnos cursoalumnos) {
		String sql =  "{call updateCalificacion(?,?,?,?,?)}";
		
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codigoCurso", cursoalumnos.getCodigoEmitido());
			
			for(AlumnoModulo alumModulo: cursoalumnos.getAlumnosmodulos()){
				cSmt.setInt("codigoModulo",alumModulo.getModulo().getCodigo());
				cSmt.setInt("codigoAlumno", alumModulo.getAlumno().getCodigo());
				try{
					cSmt.setDate("fExamen",new java.sql.Date(alumModulo.getfExamen().getTime()));
					cSmt.setInt("nota",alumModulo.getNotaExamen());
				}catch(NullPointerException e){
					LOG.trace(e.getMessage() + "fecha del examen sin fijar");
					cSmt.setDate("fExamen",null);
					cSmt.setInt("nota",0);
				}
			}
			cSmt.executeUpdate();
		}catch (SQLException e) {
				LOG.fatal(e.getMessage() + " -- Error al añadir alumnos al curso");
		}finally {
			myConexion.desconectar();
		}	
	}

	public void delete(CursoAlumnos cursoalumnos) {
		// Si queremos borrar un registro de las dos tablas
		
	}

	
	public void addModulosAlumnos(CursoAlumnos cursoalumnos) {
		// TODO Auto-generated method stub
		
	}

	
	public void deleteEmitidos(int codigoCurso) {
		// TODO Auto-generated method stub
		
	}

	
	public void deleteCalificacion(CursoAlumnos cursoalumnos) {
		// TODO Auto-generated method stub
		
	}

}
