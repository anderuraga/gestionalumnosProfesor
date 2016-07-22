package com.ipartek.formacion.dbms.dao;

import java.util.List;

import com.ipartek.formacion.pojo.CursoAlumnos;

/**
 * Interfaz que define lso metodos de consultas a base de datos de la clase
 * <code>CursoAlumnos</code>.
 * @author Curso
 *
 */

public interface CursoAlumnosDao {
/**
 * Vista en detalle de curso con alumnos y modulos. permitira cambiar los datos
 * <ul>
 * <li>añadir quitar alumnos</li>
 * <li></li>
 * 
 * </ul>
 * @param <code>int </code>
 * @return <code>CursoAlumnos </code>.El objeto que ha solicitado la carga de alumnos y modulos
 */
  public CursoAlumnos getById(int codigoCurso);
/**
 * Metodo que se encarga de actualizar los datos de los modulos
 *  
 * @param cursoAlumnos
 * @return
 */
  
  

  
  public CursoAlumnos update(CursoAlumnos cursoAlumnos);
/**
 * Metodo encargado de dar de alta modulos y alumnos en la base de datos.
 * @param cursoAlumnos  
 *        <code>CursoAlumnos</code>En este objeto se encapsulan los datos del curso, 
 *        de los alumnos y de los modulos.
 * @return <code>CursoAlumnos</code>
 */
  public void create(CursoAlumnos cursoAlumnos);
/**
 * Metodo encargado de dar de baja modulos y alumnos de un curso.
 * @param cursoAlumnos  
 *        <code>CursoAlumnos</code>En este objeto se encapsulan los datos del curso, 
 *        de los alumnos y de los modulos.
 * 
 */
  
  /**
   * Borra de ambas tablas:cursoEmision y calificacion
   * @param cursoAlumnos
   */
  public void deleteEmitidos(int codigoCurso);
/**
 * Borra de una sola tabla:Calificacion
 * @param cursoAlumnos
 */
  public void deleteCalificacion(CursoAlumnos cursoAlumnos);

/**
 * Metodo que permite añadir modulos y alumnos a un curso 
 * @param cursoAlumnos
 */
  public void addModulosAlumnos(CursoAlumnos cursoAlumnos);
    
  
  
  /**
   * Listado que se encarga de devolver el listado completo de cursos
   * de <code>CursoAlumnos</code>
   * @return <code>List<CursoAlumnos></code>
   */
  public List<CursoAlumnos> getAll();
  
  /**
   * Metodo que carga el curso en el que esta matriculado 
   * @param codigoAlumno<code>int</code>
   * @return <code>CursoAlumnos</code> el curso emitido en el que esta matriculado el <code>Alumno</code>.
   */
  public CursoAlumnos getByAlumno(int codigoAlumno);
}
