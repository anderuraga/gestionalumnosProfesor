package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.CursoAlumnos;

/**
 * Este interfaz define los métodos de acceso a BBDD que aglutinan los cursos
 * emitidos
 * <ul>
 * <li>Dar de alta módulos a un curso</li>
 * <li>Dar de alta alumnos a un curso</li>
 * <li>Dar de alta cursos disponibles <code>CursoAlumno</code></li>
 * <li>Poner las notas de los examenes de los alumno por cada módulo</li>
 * <li>Actualizar la lista de alumnos de un curso</li>
 * <li>Actualizar la lista de módulos de un curso></li>
 * <li>Actualizar los datos de curso disponible <code>CursoAlumno</code>fecha
 * inicio, fecha fin</li>
 * <li>Obtener el listado de los cursos disponibles</li>
 * <li>Obtener una vista en detalle de un curso disponible</li>
 * </ul>
 * 
 * @author Neli
 *
 */
public interface CursoAlumnoService {
	/**
	 * Método que nos carga los datos de un <code>CursoAlumnos</code> pero la
	 * carga de <code>List<ModuloCurso></code> se realiza de forma <i>Lazy</i>
	 * realizándola sólo en la vista con detalle
	 * 
	 * @return <code>List <CursoAlumnos></code>
	 */
	public List<CursoAlumnos> getAll();

	/**
	 * Obtengo los datos completos de <code>CursoAlumnos</code>.
	 * 
	 * @param cursoAlumnos
	 *            <code>CursoAlumnos</code> con el <i>código</i> de
	 *            <code>Alumno</code>, el <i>codigoEmitido</i> y el
	 *            <i>codigo</i> de <code>Modulo</code>.
	 * @return <code>CursoAlumnos</code>.
	 */
	public CursoAlumnos getById(int codigoEmitido);

}
