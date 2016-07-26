package com.ipartek.formacion.services;

import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.dao.CursoAlumnosDAO;
import com.ipartek.formacion.dbms.dao.CursoAlumnosDAOImp;
import com.ipartek.formacion.pojo.CursoAlumnos;

/**
 * <div> Clase que implementa <code>CursoAlumnoService</code> gestionando las
 * funcionalidades de la interfaz. </div>
 * 
 * @author Josu
 *
 */
public class CursoAlumnoServiceImp implements CursoAlumnoService {
	private static final Logger LOG = Logger.getLogger(CursoAlumnoServiceImp.class);
	private static CursoAlumnoServiceImp INSTANCE = null;
	private CursoAlumnosDAO cAlumnoDAO;

	private CursoAlumnoServiceImp() {
		cAlumnoDAO = CursoAlumnosDAOImp.getInstance();
	}

	private static synchronized void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CursoAlumnoServiceImp();
		}
	}

	public CursoAlumnoServiceImp getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	@Override
	public List<CursoAlumnos> getAll() {
		List<CursoAlumnos> cursoAlumnos = cAlumnoDAO.getAll();
		return cursoAlumnos;
	}

	@Override
	public CursoAlumnos getById(int codigoEmitido) {
		CursoAlumnos cAlumnos = cAlumnoDAO.getByID(codigoEmitido);
		return cAlumnos;
	}

}
