package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.dbms.dao.CursoAlumnosDAO;
import com.ipartek.formacion.dbms.dao.CursoAlumnosDAOImp;
import com.ipartek.formacion.pojo.CursoAlumnos;

/**
 * Clase que implementa el <code>CursoAlumnoService</code> gestionando las funcionalidades
 * de <code>CursoAlumnos</code>
 * @author Curso
 *
 */

public class CursoAlumnoServiceImp implements CursoAlumnoService {
	
	private static CursoAlumnoServiceImp INSTANCE = null;
	private CursoAlumnosDAO cAlumnoDAO;
	
	public CursoAlumnoServiceImp(){
		cAlumnoDAO = CursoAlumnosDAOImp.getInstance();
	}
	
	public CursoAlumnoServiceImp getInstance(){
		if(INSTANCE == null){
			createInstance();
		}
		
		return INSTANCE;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	private synchronized static void createInstance() {
		if(INSTANCE == null){
			INSTANCE = new CursoAlumnoServiceImp();
		}
	}
	
	@Override
	public List<CursoAlumnos> getAll() {
		List<CursoAlumnos> cursoAlumnos = cAlumnoDAO.getAll();
		return cursoAlumnos;
	}

	@Override
	public CursoAlumnos getById(int codigoEmitido) {
		CursoAlumnos cursoAlumnos = cAlumnoDAO.getById(codigoEmitido);
		
		return cursoAlumnos;
	}

}
