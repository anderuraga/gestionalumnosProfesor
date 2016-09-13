package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistence.Alumno;

public interface AlumnoDAO {

	public List<Alumno> getAll();
	public Alumno getById(int id);
	public void delete(int id);
	public Alumno update(Alumno a);
}
