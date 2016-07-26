package com.ipartek.formacion.service;
/**
 * Esta interfaz define los métodos de acceso a BBDD que aglutinan los cursos emitidos 
 * <ul>
	 * 	<li>dar de alta módulos a un curso</li>
	 * 	<li>dar de alta alumnos a un curso</li>
	 * 	<li>dar de alta cursos disponibles<code>CursoAlumno</code></li>
	 * 	<li>poner notas de los exámenes de los alumnos por cada módulo</li>
	 * 	<li>actualizar la lista de alumnos de un curso</li>
	 *  <li>actualizar la lista de módulos de un curso</li>
	 *  <li>actualizar lod datos de un curso disponible <code>CursoAlumnos</code> Fecha Inicio, Fecha Fin</li>
	 *  <li>obtener el listado de los cursos disponibles</li>
	 *  <li>obtener vista en detalle de un curso disponible</li>
 * </ul>.
 * @author Curso
 *
 */

import java.util.List;
import com.ipartek.formacion.pojo.CursoAlumnos;


public interface CursoAlumnoService {
	/**
	 * Método carga los datos de un <code>CursoAlumno</code> pero la carga de <code>List<ModuloCurso></code> se realiza de forma <i>Lazy</i>
	 * realizándola sólo en la vista detalle.
	 * 
	 * @return <code>List<CursoAlumnos></code>.
	 */
	public List<CursoAlumnos> getAll();
	
	/**
	 * Obtengo los datos completos de <code>CursoAlumnos</code>.
	 * 
	 * @param cursoAlumno
	 * 			<code>CursoAlumnos</code> con el <i>código</i> de <code>Alumno</code>, el <i>codigoEmitido</i>, y el <i>codigo</i> de 
	 * <code>Modulo</code>.
	 * 
	 * @return <code>CursoAlumnos</code>.
	 */
	
	public CursoAlumnos getById(int codigoEmitido);
	
	 

}