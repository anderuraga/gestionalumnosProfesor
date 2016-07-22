package com.ipartek.formacion.services;

import java.util.List;

import com.ipartek.formacion.pojo.Alumno;

/**
 * 
 * Capa service para alumnos, Interfaz encargada de definir los métodos
 * utilizados para unir Alumnoservlet con AlumnoDAO.
 * 
 * @author Josu
 *
 */
public interface AlumnoService {

	/*
	 * CRUD Create Read Update Delete
	 * 
	 */

	/**
	 * Método utilizado para crear un nuevo alumno.
	 *
	 * @param alumno
	 * @return
	 */
	public Alumno createAlumno(Alumno alumno);

	/**
	 * Método utilizado para buscar un alumno concreto en una lista o base de
	 * datos para trabajar con él.
	 * 
	 * @param codigo
	 * @return
	 */
	public Alumno getById(int codigo);

	/**
	 * Método utilizado para borrar un alumno de una lista o base de datos.
	 * 
	 * @param codigo
	 */
	public void delete(int codigo);

	/**
	 * 
	 * Método donde recogemos todos los alumnos de una base de datos y los
	 * volcamos a una lista.
	 * 
	 * @return
	 */
	public List<Alumno> getAll();

	/**
	 * 
	 * Método utilizado para actualizar los datos de un alumno y guardarlos en
	 * una base de datos o lista.
	 * 
	 * @param alumno
	 * @return
	 */
	public Alumno update(Alumno alumno);

}
