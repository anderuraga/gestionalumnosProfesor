package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistencia.Alumno;

/**
 * 
 * @author Curso
 *
 */

public interface AlumnoDAO extends DAOSetter{

	public List<Alumno> getAll();
	
	public Alumno getById(int id);
	
	public Alumno update(Alumno alumno);
	
	public void delete(int id);
	
	public Alumno create(Alumno alumno);
	
}