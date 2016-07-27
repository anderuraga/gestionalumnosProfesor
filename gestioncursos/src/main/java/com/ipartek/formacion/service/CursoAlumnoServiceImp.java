/**
 * 
 */
package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.dbms.dao.CursoAlumnosDAO;
import com.ipartek.formacion.dbms.dao.CursoAlumnosDAOImp;
import com.ipartek.formacion.pojo.CursoAlumnos;

/**
 * Clase que implementa el <code>CursoAlumnoService</code> gestionando las funcionalidades de <code>CursoAlumnos</code>.
 * @author Curso
 *
 */
public class CursoAlumnoServiceImp implements CursoAlumnoService {
	
	private static CursoAlumnoServiceImp INSTANCE=null;
	private CursoAlumnosDAO cAlumDao;
	private CursoAlumnoServiceImp(){
		cAlumDao=CursoAlumnosDAOImp.getInstance();
		
		
	}
	
	private static synchronized void createInstance(){
		if (INSTANCE==null) {
			INSTANCE=new CursoAlumnoServiceImp();
		}
	}
	
	public static CursoAlumnoServiceImp getInstance(){
		if (INSTANCE==null) {
			createInstance();
		}
		return INSTANCE;
	}
	

	/* (non-Javadoc)
	 * @see com.ipartek.formacion.service.CursoAlumnoService#getAll()
	 */
	@Override
	public List<CursoAlumnos> getAll() {
		List<CursoAlumnos> cursoAlumnos=cAlumDao.getAll();
		
		return cursoAlumnos;
	}

	/* (non-Javadoc)
	 * @see com.ipartek.formacion.service.CursoAlumnoService#getById(com.ipartek.formacion.pojo.CursoAlumnos)
	 */
	@Override
	public CursoAlumnos getById(int codigoEmitido) {
		CursoAlumnos cA=cAlumDao.getById(codigoEmitido);
		return cA;
	}

}
