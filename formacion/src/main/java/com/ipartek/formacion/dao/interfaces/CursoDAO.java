package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistence.Curso;

public interface CursoDAO {

	public List<Curso> getAll();
	public Curso getById(int id);
	public Curso update(Curso c);
	public void delete(int id);
	public Curso create(Curso c);
}
