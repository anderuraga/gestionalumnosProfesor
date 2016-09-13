package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import javax.sql.DataSource;

import com.ipartek.formacion.dao.persistencia.Alumno;

/**
 * @author Erasmo
 */
public interface AlumnoDAO extends DAOSetter {
	public List<Alumno> getAll();

	public Alumno getById(int id);

	public Alumno create(Alumno alumno);

	public Alumno update(Alumno alumno);

	public void delete(int id);

	void setDataSource(DataSource dataSource);
}
