package com.ipartek.formacion.dbms.dao;

import java.util.List;

import com.ipartek.formacion.pojo.CursoAlumnos;

public interface CursoAlumnoDAO {
	
	/**
	 * Método encargado de dar de alta módulos y alumnos.
	 */
	public void create(CursoAlumnos cursoalumnos);
	
	
	/**
	 * Vista en detalle del curso con alumnos y modulos. Permitirá:
	 * <ul>
	 * 	<li>Añadir / quitar alumnos</li>
	 * </ul>
	 * @param codigo
	 * 		<code>int</code> el codigo del curso emitido.
	 * @return
	 * 		<code>CursoAlumnos</code> el objeto cursoAlumnos. 
	 */
	public CursoAlumnos getById(int codigo);
	
	/**
	 * Método encargado de actualizar datos
	 * @param cursoalumnos.
	 */
	
	public void update(CursoAlumnos cursoalumnos);
	
	/**
	 * Método encargado de dar de baja módulos y alumnos de un curso y de borrar un
	 */
	public void delete(int codigo);
	
	
	/**
	 * Método encargado de 
	 * @param codigo
	 */
	public void deleteEmitidos(int codigo);
	public void deleteCalificacion(CursoAlumnos cursoalumnos);
	
	/**
	 * Este método devuelve el listado completo de cursos emitidos
	 * @return <code>List<CursoAlumnos></code> el listado de cursos emitidos.
	 */
	public List<CursoAlumnos> getAll();
	
	/**
	 * Método que crga el curso en el que está matriculado el alumno
	 * @param codigoAlumno
	 * 		<code>int</code>el codigo del alumno
	 * @return
	 * 		<code>CursoAlumnos</code>el curso emitido 
	 * 		<code>Alumno</code>.
	 */		
	public CursoAlumnos getByAlumnoId(int codigoAlumno);
	
	/**
	 * Método que permite añadir
	 * @param cursoalumnos
	 */
	public void addModulosAlumnos(CursoAlumnos cursoalumnos);
}


