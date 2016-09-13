package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import javax.sql.DataSource;

import com.ipartek.formacion.dao.persistencia.Curso;

/**
 * @author Erasmo
 */
public interface CursoDAO extends DAOSetter {
	public List<Curso> getAll();

	public Curso getById(int id);

	public Curso create(Curso curso);

	public Curso update(Curso curso);

	public void delete(int id);

	void setDataSource(DataSource dataSource);
}
