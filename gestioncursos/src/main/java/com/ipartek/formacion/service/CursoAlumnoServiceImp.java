package com.ipartek.formacion.service;

import java.security.GeneralSecurityException;
import java.util.List;

import com.ipartek.formacion.dbms.dao.CursoAlumnoDAO;
import com.ipartek.formacion.dbms.dao.CursoAlumnoDAOImp;

/**
 * Clase que implemente <code>CursoAlumnoService</code> gestionando las funcionalidades de <code>CursoAlumnos</code>
 */

import com.ipartek.formacion.pojo.CursoAlumnos;

public class CursoAlumnoServiceImp implements CursoAlumnoService{
	private static CursoAlumnoServiceImp INSTANCE = null;
	private CursoAlumnoDAO cAlumnoDAO;
	
	private CursoAlumnoServiceImp() {
		cAlumnoDAO = CursoAlumnoDAOImp.getInstance();
	}
	
	private static synchronized void createInstance() {
		if(INSTANCE==null){
			INSTANCE = new CursoAlumnoServiceImp();
		}

	}
	
	public static CursoAlumnoServiceImp getInstance(){
		if(INSTANCE==null){
			INSTANCE = new CursoAlumnoServiceImp();
		}
		return INSTANCE;
	}
	
	@Override
	public List<CursoAlumnos> getAll() {
		List<CursoAlumnos> cursoAlumnos = cAlumnoDAO.getAll();
		return null;
	}

	@Override
	public CursoAlumnos getById(CursoAlumnos cursoAlumno) {
		CursoAlumnos cAlumnos = cAlumnoDAO.getById(cursoAlumno.getCodigoEmitido());
		return cAlumnos;
	}

}
