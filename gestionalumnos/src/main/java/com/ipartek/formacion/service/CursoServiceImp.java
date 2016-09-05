package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipartek.formacion.dao.CursoDAOImp;
import com.ipartek.formacion.dao.interfaces.CursoDAO;
import com.ipartek.formacion.dao.persistence.Curso;
import com.ipartek.formacion.service.interfaces.CursoService;

public class CursoServiceImp implements CursoService {

	@Autowired
	CursoDAO curDAO;

	@Override
	public List<Curso> getAll() {
		List<Curso> cursos = null;
		cursos = curDAO.getAll();
		return cursos;
	}

	@Override
	public Curso getByID(int id) {
		Curso curso = curDAO.getByID(id);
		return curso;
	}

	@Override
	public Curso update(Curso curso) {
		Curso cur = curDAO.update(curso);
		return cur;
	}

	@Override
	public void delete(int id) {
		curDAO.delete(id);

	}

	@Override
	public void setCurDAO(CursoDAOImp curDAO) {
		this.curDAO = curDAO;

	}

}
