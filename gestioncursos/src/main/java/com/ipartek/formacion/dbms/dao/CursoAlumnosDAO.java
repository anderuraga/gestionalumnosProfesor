package com.ipartek.formacion.dbms.dao;

import com.ipartek.formacion.pojo.CursoAlumnos;

/**
 * @author Borja Garduño
 * Interfaz que define los metodos de consultas a 
 * BDA de la clase <code>CursoAlumnos</code>
 *
 */

public interface CursoAlumnosDAO {
	
	/**
	 * Metodo encargado de dar de alta modulos y alumnos den la BDA
	 * @param cursoalumnos
	 * 			<code>CursoAlumnos</code> 
	 * @return <code>CursoAlumnos</code>
	 */
	public CursoAlumnos create(CursoAlumnos cursoalumnos);
	
}
