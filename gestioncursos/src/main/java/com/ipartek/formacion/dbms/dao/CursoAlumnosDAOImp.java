package com.ipartek.formacion.dbms.dao;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.pojo.CursoAlumnos;
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
		aux = cursoalumnos;
		aux.setCodigoEmitido(codigoCurso);
		
		//crear el registro en la tabla calificacion
		crearCursoModulosAlumnos(aux);
		
	}
	
	private void crearCursoModulosAlumnos(CursoAlumnos aux) {
		// TODO Auto-generated method stub
		
	}

	private int createCursoEmision(CursoAlumnos cursoalumnos) {
		int codigoCursoemision= CursoAlumnos.CODIGO_CURSO;
		String sql = "{call insertCurso_emision(?,?,?,?,?)}";
		
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codigo", cursoalumnos.getCodigo());
			cSmt.setString("referencia", cursoalumnos.getReferencia());
			cSmt.setDate("fInicio", new java.sql.Date(cursoalumnos.getFechaInicio().getTime()));
			cSmt.setDate("fFin", new java.sql.Date(cursoalumnos.getFechaFin().getTime()));
/*			cSmt.executeUpdate();
			modu = modulo;
			modu.setCodigo(cSmt.getInt("codModulo"));*/
		}catch(NullPointerException e){
			
		}catch (SQLException e) {
			LOG.fatal(e.getMessage() + " -- Error al crear el curso");
		} finally {
			myConexion.desconectar();
		}
		
		return codigoCursoemision;
	}

	public List<CursoAlumnos> getById(int codigoCurso) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<CursoAlumnos> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public CursoAlumnos getByAlumnoId(int codigoAlumno) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void update(CursoAlumnos cursoalumnos) {
		// TODO Auto-generated method stub
		
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
