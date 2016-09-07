package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.CursoDAOImp;
import com.ipartek.formacion.dao.interfaces.CursoDAO;
import com.ipartek.formacion.dao.persistencia.Alumno;
import com.ipartek.formacion.dao.persistencia.Curso;
import com.ipartek.formacion.service.interfaces.CursoService;

@Service
public class CursoServiceImp implements CursoService{
	
	@Autowired //por tipo de dato
	CursoDAO curDAO;
	
	@Override
	public List<Curso> getAll() {
		List<Curso> cursos = null;
		cursos = curDAO.getAll();
		
		return cursos;
	}

	@Override
	public void setCurDAO(CursoDAOImp curDAO) {
		this.curDAO = curDAO;
		
	}

	@Override
	public Curso getById(int id) {
		Curso curso = null;
		curso = curDAO.getById(id);
		
		return curso;
	}
	
	@Override
	public void delete(int id) {
		curDAO.delete(id);
	}

	@Override
	public Curso update(Curso curso) {
		
		Curso cur = curDAO.update(curso);
		
		return cur;
		
		
	}

	
	@Override
	public Curso create(Curso curso) {
		curDAO.create(curso);
		
		return curso;
	}



	

	

}

