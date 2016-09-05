package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistence.Alumno;

/**
 *
 * @author va00
 *
 */
public interface AlumnoDAO extends DAOSetter {

	/**
	 *
	 * @return
	 */
	public List<Alumno> getAll();

	/**
	 *
	 * @param id
	 * @return
	 */
	public Alumno getById(int id);

	public Alumno create(Alumno Alumno);

	public void delete(int id);

	public Alumno update(Alumno alumno);
}
