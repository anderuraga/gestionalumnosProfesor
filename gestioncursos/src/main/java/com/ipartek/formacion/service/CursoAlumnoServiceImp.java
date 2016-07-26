package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.dbms.dao.CursoAlumnosDAO;
import com.ipartek.formacion.dbms.dao.CursoAlumnosDAOImp;
import com.ipartek.formacion.pojo.CursoAlumnos;

/**
 * Clase que implementa el <code>CursoAlumnoService</code> gestionando las
 * funcionalidades de <code>CursoAlumnos</code>
 * 
 * @author Neli
 *
 */

public class CursoAlumnoServiceImp implements CursoAlumnoService {
	private static CursoAlumnoServiceImp INSTANCE = null;
	private CursoAlumnosDAO cAlumnosDAO;

	private CursoAlumnoServiceImp() {
		cAlumnosDAO = CursoAlumnosDAOImp.getInstance();
	}

	private static synchronized void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CursoAlumnoServiceImp();
		}
	}

	public static CursoAlumnoServiceImp getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}

		return INSTANCE;
	}

	@Override
	public List<CursoAlumnos> getAll() {
		List<CursoAlumnos> cursoAlumnos = cAlumnosDAO.getAll();
		return cursoAlumnos;
	}

	@Override
	public CursoAlumnos getById(int codigoEmitido) {
		CursoAlumnos cursoAlumno = cAlumnosDAO.getById(codigoEmitido);
		return cursoAlumno;
	}

}
