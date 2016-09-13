/**
 * 
 */
package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.CursoAlumnos;

/**
 * @author Curso
 * Este interfaz define los metodos de acceso a Base de Datos 
 * <ul>
 * <li>dar de alta modulos a un curso </li>
 * <li> dar de alta modulos a un curso </li>
 * <li>dar de alta cursos disponible <code>CursoAlumno</code></li>
 * <li>poner las notas de los examenes de los alumnos por cada modulo </li>
 * <li>actualizar la lista de alumnos de un curso </li>
 * <li>actualizar la lista de modulos de un curso </li> 
 * <li>actualizar los datos de curso dispoinble<code>CursoAlumno</code> FechaInicio fecha fin </li>
 * <li>obtener el listado de los cursos disponibles</li>
 * <li>obtener una vista en detalle de un curso dispoinble</li>
 * <li></li>
 * </ul>
 *
 */
public interface CursoAlumnoService {

	/**
	 * Metodo que carga los datos de un <code>CursoAlumnos</code>
	 * @return <code>List<CursoAlumnos></code>
	 */
	
	public List<CursoAlumnos> getAll();
	
	/**
	 * <div>
	 * Obtengo los datos completos de <code>CursoAlumnos</code>.
	 * </div>
	 * 
	 * @param cAlumno <code>CursoAlumnos</code> con el <i>codigo</i> de <code>Alumno</code>, el <i>codigoEmitido</i> y el <i>codigo</i> de <code>Modulo</code>.
	 * @return <code>CursoAlumnos</code>.
	 */
	
	public CursoAlumnos getById(int cEmitido);
	
	
	
}
