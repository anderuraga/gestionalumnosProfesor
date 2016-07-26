package com.ipartek.formacion.services;

import java.util.List;

import com.ipartek.formacion.pojo.CursoAlumnos;

/**
 * <div> Este interfaz define los metodos de acceso a la base de datos que
 * aglutinan los cursos emitidos.
 * <ul>
 * <li>dar de alta a modulos de un curso</li>
 * <li>dar de alta a alumnos de un curso</li>
 * <li>dar de alta a cursos disponibles <code>CursoAlumno</code></li>
 * <li>poner las notas de los examenes de los alumnos por cada modulo</li>
 * <li>actualizar la lista de alumnos de un curso</li>
 * <li>actualizar la lista de modulos de un curso</li>
 * <li>actualizar los datos de un curso disponible <code>CursoAlumno</code>
 * Fecha inicio, fecha fin</li>
 * <li>obtener listado de los cursos disponibles</li>
 * <li>obtener listado una vista en detalle de un curso disponible</li>
 * </ul>
 * </div>
 * 
 * @author Josu
 *
 */
public interface CursoAlumnoService {
	/**
	 * <div> Metodo que nos carga los datos de un <code>CursoAlumnos</code> pero
	 * la carga de <code>List<CursoAlumnos></code> se realiza de forma
	 * <i>Lazy</i> realizandola solo en la vista detalle.
	 * 
	 * 
	 * </div>
	 * 
	 * @return <code>List<CursoALumnos></code>.
	 */
	public List<CursoAlumnos> getAll();

	/**
	 * <div> Metodo que carga los datos del <code>CursoAlumnos</code>. </div>
	 * 
	 * @param cursoAlumnos
	 *            <code>CursoAlumnos</code> con el <i>codigo</i> de
	 *            <code>Alumno</code>, el <i>codigoEmitido</i> de
	 *            <code>Modulo</code>.
	 * 
	 * @return <code>CursoAlumnos</code>.
	 */
	public CursoAlumnos getById(int codigoEmitido);

}
