package com.ipartek.formacion.dbms.dao;

import java.util.List;

import com.ipartek.formacion.pojo.Curso;
import com.ipartek.formacion.pojo.CursoAlumnos;

/**
 * Interfaz que define los métodos de la clase <code>CursoALumno</code> encargada de realizar consultas a BBDD.
 * @author Curso
 *
 */
public interface CursoAlumnosDAO {
	
	
	/**Metodo encargado de dar de alta módulos y alumnos
	 * 
	 * @param cursoalumnos 
	 * 			<code>CursoAlumnos</code> En este objeto se encapsulan los datos del curso, del alumno y 
	 * de los módulos de los alumnos.
	 * @return <code>CursoAlumnos</code>
	 */
	public void create(CursoAlumnos cursoalumnos);
	
	/**Metodo encargado de añadir módulos y alumnos a un curso
	 * 
	 * @param cursoalumnos 
	 * 			<code>CursoAlumnos</code> 
	 * En este objeto se encapsulan los datos del curso, del alumno y 
	 * de los módulos de los alumnos.
	 */
	public void addModulosAlumnos(CursoAlumnos cursoalumnos);
	
	
	/**
	 * Metodo encargado de buscar curso con alumnos y módulos. Permitirá cambiar los datos
	 * <ul>
	 * 		<li>añadir y quitar alumnos</li>
	 * </ul>
	 * 
	 * @param codigoCurso es codigo de la tabla curso_alumno, no codCurso.
	 * 			<code>CursoAlumnos</code> En este objeto se encapsulan los datos del curso, del alumno y 
	 * de los módulos de los alumnos.
	 * @return <code>CursoAlumnos</code> el objeto cursoalumnos
	 */	
	public List<CursoAlumnos> getById(int codigoCurso);
	
	
	/**Este método devuelve el listado completo de cursoAlumnos.
	 * 
	 * 			<code>List<CursoAlumnos></code> En este objeto se encapsulan los datos del curso, del alumno y 
	 * de los módulos de los alumnos.
	 * @return <code>CursoAlumnos</code> el listado completo de curso 
	 */	
	public List<CursoAlumnos> getAll();
	
	/**
	 * Metodo que carga el curso en el que esta matriculado el alumno
	 * @param codigoCurso es codigo de la tabla curso_alumno, no codCurso.
	 * 			<code>int</code> el codigo del alumno.
	 * @return <code>CursoAlumnos</code> el curso emitido
	 * 			<code>Alumno</code>
	 */	
	public CursoAlumnos getByAlumnoId(int codigoAlumno);
	
	
	/**Metodo encargado de dar de actualizar módulos y alumnos
	 * 
	 * @param cursoalumnos 
	 * 			<code>CursoAlumnos</code> En este objeto se encapsulan los datos del curso, del alumno y 
	 * de los módulos de los alumnos.
	 */	
	public void update(CursoAlumnos cursoalumnos);
	
	
	/**Metodo encargado de dar de baja módulos y alumnos borra de tabla calificación
	 * 
	 * @param cursoalumnos 
	 * 			<code>CursoAlumnos</code> 
	 * En este objeto se encapsulan los datos del curso, del alumno y 
	 * de los módulos de los alumnos.
	 */
	public void delete(CursoAlumnos cursoalumnos);
	
	/**Metodo encargado de dar de baja módulos y alumnos de un curso y el curso emitido, .
	 * 
	 * @param codigoCurso
	 * 			<code>CursoAlumnos</code> 
	 * En este objeto se encapsulan los datos del curso, del alumno y 
	 * de los módulos de los alumnos.
	 */
	public void deleteEmitidos(int codigoCurso);
	
	/**Metodo encargado de dar de baja módulos y alumnos borra de tabla calificación
	 * 
	 * @param cursoalumnos 
	 * 			<code>CursoAlumnos</code> 
	 * En este objeto se encapsulan los datos del curso, del alumno y 
	 * de los módulos de los alumnos.
	 */	
	public void deleteCalificacion(CursoAlumnos cursoalumnos);
	
	
	

}
