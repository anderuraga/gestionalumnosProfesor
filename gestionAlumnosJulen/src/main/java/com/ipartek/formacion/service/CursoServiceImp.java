package com.ipartek.formacion.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.controller.ModuloController;
import com.ipartek.formacion.dao.interfaces.CursoDAO;
import com.ipartek.formacion.dao.persistence.Curso;
import com.ipartek.formacion.service.interfaces.CursoService;
@Service
public class CursoServiceImp implements CursoService{
	
	private static final Logger logger = LoggerFactory.getLogger(CursoServiceImp.class);

	
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
