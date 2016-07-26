/**
 * 
 */
package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.dbms.dao.CursoAlumnosDAO;
import com.ipartek.formacion.dbms.dao.CursoAlumnosDAOImp;
import com.ipartek.formacion.pojo.CursoAlumnos;

/**
 * Clase que implementa <code>CursoAlumnoService</code> gestionando las funcionalidades de <code>CursoAlumno</code>
 * @author Curso
 *
 */
public class CursoAlumnoServiceImp implements CursoAlumnoService {
	private static CursoAlumnoServiceImp INSTANCE = null;
	private CursoAlumnosDAO cAlumnoDAO;
	
	private CursoAlumnoServiceImp(){
		cAlumnoDAO = CursoAlumnosDAOImp.getInstance();
		
	}
	
	public static synchronized void createInstance(){
		if(INSTANCE == null){
			INSTANCE = new CursoAlumnoServiceImp();
		}
	}
	
	public static CursoAlumnoServiceImp getInstance(){
		if(INSTANCE == null){
			createInstance();
		}
		return INSTANCE;
	}

	/* (non-Javadoc)
	 * @see com.ipartek.formacion.service.CursoAlumnoService#getAll()
	 */
	@Override
	public List<CursoAlumnos> getAll() {
		List<CursoAlumnos> cursoAlumnos = cAlumnoDAO.getAll();
		return cursoAlumnos;
	}

	/* (non-Javadoc)
	 * @see com.ipartek.formacion.service.CursoAlumnoService#getById(com.ipartek.formacion.pojo.CursoAlumnos)
	 */
	@Override
	public CursoAlumnos getById(int codigoEmitido) {
		CursoAlumnos cAlumno = cAlumnoDAO.getById(codigoEmitido);
		return cAlumno;
	}

}
