package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipartek.formacion.dao.interfaces.CursoDAO;
import com.ipartek.formacion.dao.persistence.Curso;
import com.ipartek.formacion.service.interfaces.CursoService;

public class CursoServiceImp implements CursoService{
	
	@Autowired
	CursoDAO cursoDAO;

	public void setCursoDAO(CursoDAO cursoDAO) {
		this.cursoDAO = cursoDAO;
	}

	@Override
	public List<Curso> getAll() {

		List<Curso> cursos = null;
		
		cursos = cursoDAO.getAll();
		
		return cursos;
	}

	@Override
	public Curso getById(int id) {

		Curso curso = cursoDAO.getById(id);
		
		return curso;
	}

	@Override
	public Curso update(Curso curso) {

		return cursoDAO.update(curso);
	}

	@Override
	public void delete(int id) {

		cursoDAO.delete(id);
	}

	@Override
	public Curso create(Curso curso) {

		return cursoDAO.create(curso);
	}

}
