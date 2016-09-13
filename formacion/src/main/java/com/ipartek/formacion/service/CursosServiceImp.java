package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.CursoDAOImp;
import com.ipartek.formacion.dao.persistence.Curso;
import com.ipartek.formacion.service.interfaces.CursoService;

@Service
public class CursosServiceImp implements CursoService {

	@Autowired
	CursoDAOImp cDAO;
	
	public void setCDAO(CursoDAOImp cDAO) {
		this.cDAO = cDAO;
	}

	@Override
	public List<Curso> getAll() {
	
		List <Curso>cursos=null;
		cursos=cDAO.getAll();
		return cursos;
	}

	@Override
	public Curso getById(int id) {
		Curso c=cDAO.getById(id);
		return c;
	}

	@Override
	public Curso update(Curso c) {
		Curso curso=cDAO.update(c);
		return curso;
	}

	@Override
	public void delete(int id) {
		cDAO.delete(id);
		
	}

	@Override
	public Curso create(Curso c) {
		Curso curso=cDAO.create(c);
		
		return curso;
	}

}
