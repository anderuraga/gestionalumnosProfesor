package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipartek.formacion.dao.AlumnoDAOImp;
import com.ipartek.formacion.dao.CursoDAOImp;
import com.ipartek.formacion.dao.interfaces.CursoDAO;
import com.ipartek.formacion.dao.persistencia.Curso;
import com.ipartek.formacion.service.interfaces.CursoService;

public class CursoServiceImp implements CursoService {

	@Autowired
	CursoDAO curDAO;
	
	@Override
	public List<Curso> getAll() {
		List<Curso> cursos = curDAO.getAll();
		return cursos;
	}

	@Override
	public Curso getById(int id) {
		Curso curso = curDAO.getById(id);
		return null;
	}

	@Override
	public Curso create(Curso curso) {
		curDAO.create(curso);
		return null;
	}

	@Override
	public Curso update(Curso curso) {
		curDAO.update(curso);
		return null;
	}

	@Override
	public void delete(int id) {
		curDAO.delete(id);
		
	}
	
	public void setCurDAO(CursoDAOImp curDAO) {
		this.curDAO = curDAO;
				
	}

}
