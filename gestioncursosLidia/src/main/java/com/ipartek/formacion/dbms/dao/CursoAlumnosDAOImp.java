package com.ipartek.formacion.dbms.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.dbms.ConexionDBImp;
/**
 * clase que gestiona altas,bajas y modificaciones en los cursos emitidos
 */
import com.ipartek.formacion.pojo.CursoAlumnos;

public class CursoAlumnosDAOImp implements CursoAlumnosDAO {
	//SINGLETON
	  private final static Logger LOG = Logger.getLogger(CursoAlumnosDAOImp.class);
	  private static CursoAlumnosDAOImp INSTANCE = null;
	  private static ConexionDB myConexion;

	  /**
	 * 
	 */
	  private CursoAlumnosDAOImp() {
	    myConexion = ConexionDBImp.getInstance();
	  }

	  /**
	   * 
	   * @return INSTANCE
	   */
	  public static CursoAlumnosDAOImp getInstance() {
	    if (INSTANCE == null) {
	      createInstance();
	    }
	    return INSTANCE;
	  }

	  /**
	 * 
	 */
	  private synchronized static void createInstance() {
	    if (INSTANCE == null) {
	      INSTANCE = new CursoAlumnosDAOImp();
	    }
	  }


	@Override
	public void create(CursoAlumnos cursoalumnos) {
		//crear un curso->crear elemento en la tabla curso_emision.en el momento de crear un curso, no hay ningún alumno,por eso en la tabla alumno se crea uno
		//int codigoCurso=createCursoEmision(cursoalumnos);
			
		
		//crear el registro en la tabla calificacion
	}

	@Override
	public void update(CursoAlumnos cursoalumnos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CursoAlumnos getById(int codigoCurso) {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public void deleteEmitidos(CursoAlumnos cursoalumnos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCalificacion(CursoAlumnos cursoalumnos) {
		// TODO Auto-generated method stub
		
	}

}
