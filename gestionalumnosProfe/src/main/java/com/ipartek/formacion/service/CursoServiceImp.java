package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.interfaces.AlumnoDAO;
import com.ipartek.formacion.dao.interfaces.CursoDAO;
import com.ipartek.formacion.dao.persistence.Curso;
import com.ipartek.formacion.service.interfaces.CursoService;
@Service
public class CursoServiceImp implements CursoService {
	@Autowired
	CursoDAO cursoDAO;
	@Override
	public List<Curso> getAll() {
		List<Curso> cursos =null;
		cursos=cursoDAO.getAll();
		return cursos;
	}

	@Override
	public Curso getById(int id) {
	
		return cursoDAO.getById(id);
	}

	@Override
	public Curso update(Curso curso) {
		
		return cursoDAO.update(curso);
	}

	@Override
	public void delete(int id) {
		cursoDAO.delete(id);
		
	}

	
}
