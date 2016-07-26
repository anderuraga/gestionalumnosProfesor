package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.CursoAlumnos;

/**
 * Este interfaz define los métodos de acceso a Base de Datos que aglutinan los cursos emitidos:
 * <ul>
 * 	<li>dar de alta modulos a un curso</li>
 * 	<li>dar de alta alumnos a un curso</li>
 * 	<li>dar de alta cursos disponibles <code>CursoAlumno</code> </li>
 * 	<li>poner las notas de los examenes de los alumnos por cada modulo</li>
 * 	<li>actualizar la lista de alumnos de un curso</li>
 * 	<li>actualizar la lisya de modulos de un curso</li>
 * 	<li>actualizar los datos de curso disponible <code>CursoAlumno</code> FechaInicio - FechaFin</li>
 * 	<li>obtener el listado de los cursos disponibles</li>
 * 	<li>obtener una vista en detalle de un curso disponible</li>
 *</ul> 
 * @author Curso
 *
 */


public interface CursoAlumnoService {
	/**
	 * Método que nos carga los datos de un <code>CursoAlumno</code> pero la carga de <code>List<ModuloCurso></code>se realiza de forma.
	 * @return <code>List<CursoAlumnos></code>.
	 */
	public List<CursoAlumnos> getAll();
	
	/**
	 * Obtengo los datos completos de <code>CursoAlumnos</code>.
	 * 
	 * @param cursoAlumno 
	 * 			<code>CursoAlumnos</code> con el codigo <i>codigo</i> de <code>Alumno</code>, el <i>codigoEmitido</i>, y el <i>codigo</i> de <code>Modulo</code>.
	 * @return <code>CursoAlumnos</code>.
	 */
	public CursoAlumnos getById(CursoAlumnos cursoAlumno);

}
