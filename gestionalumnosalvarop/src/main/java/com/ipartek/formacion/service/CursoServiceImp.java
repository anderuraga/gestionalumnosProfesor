package com.ipartek.formacion.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.CursoDAOImp;
import com.ipartek.formacion.dao.interfaces.AlumnoDAO;
import com.ipartek.formacion.dao.interfaces.CursoDAO;
import com.ipartek.formacion.dao.persistencia.Alumno;
import com.ipartek.formacion.dao.persistencia.Curso;
import com.ipartek.formacion.service.interfaces.CursoService;

@Service
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
	public void setCursoDAO(CursoDAOImp cursDAO) {
		this.cursoDAO=cursDAO;
		
	}

	@Override
	public Curso getById(int id) {
		Curso curso=cursoDAO.getByid(id);
		return curso;
	}

	@Override
	public Curso update(Curso curso) {
		Curso curs=cursoDAO.update(curso);
		return curs;
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
