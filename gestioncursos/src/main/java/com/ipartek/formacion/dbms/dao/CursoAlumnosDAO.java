package com.ipartek.formacion.dbms.dao;

import java.util.List;

import com.ipartek.formacion.pojo.CursoAlumnos;

/**
 * Interfaz que define los métodos de consulta a BBDD de la clase
 * <code>CursoAlumnos</code>.
 * 
 * @author Neli
 *
 */
public interface CursoAlumnosDAO {
	/**
	 * Método encargado de dar de alta módulos y alumnos en la BBDD.
	 * 
	 * @param cursoalumnos
	 *            <code>CursoAlumnos</code> En este objeto se encapsulan los
	 *            datos del curso, de los alumnos y de los módulos.
	 */
	public void create(CursoAlumnos cursoalumnos);

	/**
	 * Método que permite añadir módulos y alimnos a un curso emitido.
	 * 
	 * @param cursoalumnos
	 */
	public void addModulosAlumnos(CursoAlumnos cursoalumnos);

	/**
	 * Método que se encarga de dar de baja módulos y alumnos de un curso
	 * emitido.
	 * 
	 * @param int
	 *            <code>CursoAlumnos</code>
	 */
	public void deleteEmitidos(int codCurso);

	/**
	 * 
	 * @param cursoAlumnos
	 */
	public void deleteCalificacion(CursoAlumnos cursoAlumnos);

	/**
	 * Método que se encarga de actualizar los datos.
	 * 
	 * @param cursoalumnos
	 */
	public void update(CursoAlumnos cursoalumnos);

	/**
	 * Vista en detalle del curso con alumnos y modulos. Permitirá:
	 * <ul>
	 * <li>Añadir y quitar alumnos</li>
	 * <li>Añadir y quitar módulos</li>
	 * </ul>
	 * 
	 * @param codCurso
	 *            <code>int</code>
	 * @return <code>CursoAlumnos</code>.
	 */
	public CursoAlumnos getById(int codCurso);

	/**
	 * Este método devuelve el listado completo de cursos emitidos.
	 * 
	 * @return <code>List<CursoAlumnos></code> listado completo de
	 *         <code>CursoAlumnos</code>.
	 */
	public List<CursoAlumnos> getAll();

	/**
	 * Método que carga el curso en el que está matriculado un alumno
	 * 
	 * @param codAlumno
	 *            <code>int</code> el código del alumno
	 * @return <code>CursoAlumnos</code> el curso emitido en el que esta
	 *         matriculado el <code>Alumno</code>.
	 */
	public CursoAlumnos getByAlumnoId(int codAlumno);
}
