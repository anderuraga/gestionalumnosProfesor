package com.ipartek.formacion.dbms.dao;

import java.util.List;

import com.ipartek.formacion.pojo.CursoAlumnos;

/**
 * @author Borja Garduño
 * Interfaz que define los metodos de consultas a 
 * BDA de la clase <code>CursoAlumnos</code>
 *
 */

public interface CursoAlumnosDAO {
	
	/**
	 * Metodo encargado de dar de alta modulos y alumnos de la BDA
	 * @param cursoalumnos
	 * 			<code>CursoAlumnos</code> 
	 * @return <code>CursoAlumnos</code>
	 */
	public void create(CursoAlumnos cursoalumnos);
	
	
	/**
	 * 
	 */
	
	public void addModulosAlumnos(CursoAlumnos cursoalumnos);
	
	
	/**
	 * Metodo que se encarga de dar de baja modulos y alumnos
	 * @param cursoalumnos
	 */
	public void deleteEmitidos(int codigoCurso);
	
	/**
	 * 
	 */
	
	public void deleteCalificacion(CursoAlumnos cursoalumnos);
	
	
	/**
	 * Metodo que se encarga de actualizar los datos de modulos y alumnos en un curso
	 * @param cursoalumnos
	 */
	public void update(CursoAlumnos cursoalumnos);
	

	/**
	 * Vista en detalle del curso con alumnos y modulos
	 * 
	 * <ul>
	 * <li>Añadir quitar alumnos</li>
	 * <li>Añadir quitar alumnos</li>
	 * </ul>
	 * 
	 * @param codigoCurso
	 * @return
	 */
	public CursoAlumnos getById(int codigoCurso);
	
	
	/**
	 * Este metodo devuelve el listado completo de cursos
	 * @return
	 */
	public List<CursoAlumnos> getAll();
	
	
	/**
	 * Metodo que carga el curso en el que esta matriculado un alumno
	 * @param codigoAlumno
	 * @return
	 */
	public CursoAlumnos getByAlumnoId(int codigoAlumno);
}
