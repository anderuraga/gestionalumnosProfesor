package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.CursoDAOImp;
import com.ipartek.formacion.dao.persistence.Curso;

public interface CursoService {
	public List<Curso> getAll();

	public Curso getByID(int id);

	public Curso update(Curso curso);

	public void delete(int id);

	public void setCurDAO(CursoDAOImp curDAO);

}
