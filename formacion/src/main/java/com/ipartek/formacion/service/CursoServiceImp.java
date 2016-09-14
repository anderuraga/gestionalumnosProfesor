package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.interfaces.CursoDAO;
import com.ipartek.formacion.dao.persistence.Curso;
import com.ipartek.formacion.service.interfaces.CursoService;

@Service
public class CursoServiceImp implements CursoService {

	@Autowired
	CursoDAO cursDAO;
	
	@Override
	public List<Curso> getAll() {
		List<Curso> cursos = null;
		cursos = cursDAO.getAll();
		return cursos;
	}

	@Override
	public Curso getById(int id) {
		Curso curso = cursDAO.getById(id);
		return curso;
	}

	@Override
	public Curso update(Curso curso) {
		Curso curs = cursDAO.update(curso);
		return curs;
	}

	@Override
	public void delete(int id) {
		cursDAO.delete(id);
	}
	
	@Override
	public Curso create(Curso curso){
		return cursDAO.create(curso);
	}
}
