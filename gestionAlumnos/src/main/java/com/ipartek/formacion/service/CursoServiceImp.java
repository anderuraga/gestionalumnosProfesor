package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipartek.formacion.dao.CursoDAOImp;
import com.ipartek.formacion.dao.interfaces.CursoDAO;
import com.ipartek.formacion.dao.persistencia.Curso;

public class CursoServiceImp implements CursoService{
	@Autowired
	CursoDAO cursoDAO;
	@Override
	public List<Curso> getAll() {
		List<Curso>cursos=null;
		cursos=cursoDAO.getAll();
		return cursos;
	}

	@Override
	public void setCursoDAO(CursoDAOImp cursoDAO) {
		this.cursoDAO=cursoDAO;
	}

	@Override
	public Curso getById(int id) {
		Curso curso=cursoDAO.getById(id);
		return curso;
	}

	@Override
	public Curso update(Curso curso) {
		Curso cur=cursoDAO.update(curso);
		return cur;
	}

	@Override
	public void delete(int id) {
		cursoDAO.delete(id);
	}

}
