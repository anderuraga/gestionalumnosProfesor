package com.ipartek.formacion.dbms.dao;

import java.util.List;

import com.ipartek.formacion.pojo.CursoAlumnos;

/**
 * 
 * Interfaz que define los metodos de consulta a base de datos de la clase
 * <code>CursoAlumnos</code>.
 * 
 * @author Curso
 *
 */
public interface CursoAlumnosDAO {
	/**
	 * Metodo encargado de buscar modulos y/o alumnos en la base de datos. Vista
	 * en detalle del curso con alumnos y modulos. Permitirá cambiar los datos
	 * <ul>
	 * <li>añadir quitar alumnos</li>
	 * <li>añadir quitar alumnos</li>
	 * </ul>
	 * 
	 * @param codigocurso
	 *            <code>int</code> el codigo del curso emitido.
	 *            <code>CursoAlumnos</code> objeto que encapsula alumnos, cursos
	 *            y modulos.
	 * 
	 * @return
	 */
	public CursoAlumnos getByID(int codigoCurso);

	/**
	 * Metodo encargado de actualizar modulos y/o alumnos en la base de datos.
	 * 
	 * @param cursoalumnos
	 *            En este objeto se encapsulan los datos del curso, modulo y
	 *            alumnos.
	 * @return
	 */
	public void update(CursoAlumnos cursoalumnos);

	/**
	 * Metodo encargado de dar de alta modulos y/o alumnos en la base de datos.
	 * 
	 * @param cursoalumnos
	 *            En este objeto se encapsulan los datos del curso, modulo y
	 *            alumnos.
	 * @return
	 */
	public void insert(CursoAlumnos cursoalumnos);

	/**
	 * Metodo encargado de eliminar modulos y/o alumnos en la base de datos.
	 * 
	 * @param codigoCurso
	 * @return
	 */
	public void deleteEmitido(int codigoCurso);

	/**
	 * Metodo encargado de eliminar modulos y/o alumnos en la base de datos.
	 * 
	 * @param codigoCurso
	 * @return
	 */
	public void deleteCalificacion(int codigoCurso);

	/**
	 * 
	 * Metodo que permite añadir modulos y alumnos a un curso
	 * 
	 * 
	 * 
	 * @param cursoalumnos
	 */

	public void addModulosAlumnos(CursoAlumnos cursoalumnos);

	/**
	 * 
	 * Este metodo devuelve el listado completo de curso.
	 * 
	 * 
	 * @return <code>List<CursoAlumnos></code> el listado de alumnos.
	 */

	public List<CursoAlumnos> getAll();

	/**
	 * Metodo que carga el curso en el que esta matriculado el alumno.
	 * 
	 * @param codigoalumno
	 *            <code>int</code> el codigo del alumno.
	 * 
	 * 
	 * 
	 * @return <code>CursoAlumnos</code> el curso emitido en el que esta
	 *         matriculado el alumno. <code>Alumno</code>.
	 */
	public CursoAlumnos getByAlumnoId(int codigoalumno);

}
