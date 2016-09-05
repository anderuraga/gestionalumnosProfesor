package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistencia.Alumno;

/**
 * 
 * @author Curso
 *
 */

public interface AlumnoDAO extends DaoSetter{
	
	public List<Alumno> getAll();
	
	public Alumno create(Alumno alumno);
	
	public Alumno getById(int id);
	
	public Alumno update(Alumno alumno);
	
	public void delete(int id);

}
