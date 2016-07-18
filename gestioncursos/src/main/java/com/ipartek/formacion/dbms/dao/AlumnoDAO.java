package com.ipartek.formacion.dbms.dao;

import java.util.List;

import com.ipartek.formacion.pojo.Alumno;

public interface AlumnoDAO {

	public Alumno getByID(int codigo);

	public Alumno update(Alumno alumno);

	public Alumno insert(Alumno alumno);

	public Alumno delete(int codigo);

	public List<Alumno> getAll();

}