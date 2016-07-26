package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.CursoAlumnos;

/**
 * Este interfaz define los metodos de acceso a Bases de Datos
 * que aglutinan los cursos emitidos:
 * <ul>
 * 	<li>dar de alta modulos a un curso</li>
 * 	<li>dar de alta alumnos a un curso</li>
 * 	<li>dar de alta cursos disponibles <code>CursoAlumno</code></li>
 * 	<li>poner las notas de los examenes de los alumnos por cada modulo</li>
 * 	<li>actualizar la lista de alumnos de un curso</li>
 *	<li>actualizar la lista de modulos de un curso</li>
 *	<li>actualizar los datos de curso disponible <code>CursoAlumno</code></li>
 *	<li>obtener el listado de los cursos disponibles</li>
 *	<li>obtener una vista en detalle de un curso disponible</li>
 * </ul>
 * @author Curso
 *
 */

public interface CursoAlumnoService {
	/**
	 * Metodo que nos carga los datos de un <code>CursoAlumno</code> pero la carda de <code>List<ModuloCurso></code>
	 * Se realiza de forma <i>Lazy</i> realizandola solo en la vista en detalle.
	 * @return <code>List<CursoAlumnos></code>
	 */
	
	public List<CursoAlumnos> getAll();
	
	/**
	 * 
	 * @param cursoAlumno <code>CursoAlumnos</code>
	 * @return <code>CursoAlumnos</code>
	 */
	
	public CursoAlumnos getById(int codigoEmitido);
}
