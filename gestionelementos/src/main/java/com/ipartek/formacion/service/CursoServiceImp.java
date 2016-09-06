package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.CursoDAOImp;
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
	public void setCursDAO(CursoDAOImp cursDAO) {
		this.cursDAO = cursDAO;
	}

	@Override
	public Curso getById(int id) {
		return cursDAO.getById(id);
	}

	@Override
	public Curso update(Curso curso) {
		return cursDAO.update(curso);
		}

	@Override
	public Curso create(Curso curso) {
		return cursDAO.create(curso);
		}

	@Override
	public void delete(int id) {
		cursDAO.delete(id);
	}

}
