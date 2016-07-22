package com.ipartek.formacion.dbms.dao;

import java.util.List;

import com.ipartek.formacion.pojo.CursoAlumnos;
/**
 * interfaz q  define métodos de consulta a bbdd de la clase CursoAlumnos.
 * @param cursoalumnos
 * @return
 */

public interface CursoAlumnosDAO {

/**
 * método que da de alta módulos y/o alumnos en la bbdd.
 * 
 * @param cursoalumnos
 * 				<code>CursoAlumnos</code> En éste objetose encapsulan los datos del curso,de los alumnos y de los módulos
 * @return 		<code>CursoAlumnos</code>
 */
	public void create (CursoAlumnos cursoalumnos);
	/**
	 * metodo q permite añadir modulos y alumnos a un curso ya creado
	 * @param cursoalumnos
	 */
	public void addModulosAlumnos(CursoAlumnos cursoalumnos);
	/**
	 * método q da de baja módulos y/o alumnos en la bbdd
	 * @param cursoalumnos
	 */
	public void deleteEmitidos (CursoAlumnos cursoalumnos);
	
	public void deleteCalificacion (CursoAlumnos cursoalumnos);
	/**
	 * método que actualiza los datos de módulos alumnos 
	 * @param cursoalumnos
	 */
	public void update(CursoAlumnos cursoalumnos);
	/**
	 * vista en detalle del curso con alumnos y modulos
	 * @param codigoCurso
	 * @return
	 */
	public CursoAlumnos getById(int codigoCurso);//getById será el código del curso
	/**
	 * metodo que devuelve el listado completo de cursos
	 * @return
	 */
	public List<CursoAlumnos> getAll();
	/**
	 * metodo que carga el curso en el que está matriculado el alumno
	 * @return
	 */
	public CursoAlumnos getByAlumnoId(int codigoAlumno);
}

