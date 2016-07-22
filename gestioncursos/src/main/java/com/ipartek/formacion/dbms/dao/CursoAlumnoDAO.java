package com.ipartek.formacion.dbms.dao;

import com.ipartek.formacion.pojo.CursoAlumnos;

public interface CursoAlumnoDAO {
	
	/**
	 * Método encargado de dar de alta módulos y alumnos
	 */
	
	public void create(CursoAlumnos cursoalumnos);
	
	public CursoAlumnos getById(int codigo);
	
	/**
	 * Método encargado de actualizar datos
	 * @param cursoalumnos
	 */
	
	public void update(CursoAlumnos cursoalumnos);
	
	/**
	 * Método encargado de dar de baja módulos y alumnos de un curso
	 */
	public void delete(int codigo);
	

}
