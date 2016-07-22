package com.ipartek.formacion.dbms.dao;

import java.util.List;

import com.ipartek.formacion.pojo.Alumno;

/**
 * Esta clase implementa los métodos que implementa Alumno.
 *
 * @author va00
 */
public interface AlumnoDAO {

	public Alumno getById(int codigo);

	public Alumno update(Alumno alumno);

	public Alumno create(Alumno alumno);

	public void delete(int codigo);

	public List<Alumno> getAll();
}
