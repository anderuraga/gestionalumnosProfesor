package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistence.Curso;

/**
 *
 * @author va00
 *
 */
public interface CursoService {
	/**
	 *
	 * @return
	 */
	public List<Curso> getAll();

	public Curso getById(int id);

	public Curso update(Curso curso);

	public void delete(int id);
	public Curso create(Curso curso);
}
