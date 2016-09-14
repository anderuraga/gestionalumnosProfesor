package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.CursoDAOImp;
import com.ipartek.formacion.dao.persistence.Curso;

/**
 * @author Erasmo
 */
public interface CursoService {
	public List<Curso> getAll();

	public Curso getById(int id);

	public Curso create(Curso curso);

	public Curso update(Curso curso);

	public void delete(int id);

	void setCursoDAO(CursoDAOImp cursDAO);
}
