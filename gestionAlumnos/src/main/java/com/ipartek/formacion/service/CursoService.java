package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.dao.CursoDAOImp;
import com.ipartek.formacion.dao.persistencia.Curso;

public interface CursoService {
	public List<Curso>getAll();
	public void setCursoDAO(CursoDAOImp cursoDAO);
	public Curso getById(int id);
	public Curso update(Curso curso);
	public void delete(int id);
}
