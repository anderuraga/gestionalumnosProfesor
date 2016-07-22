package com.ipartek.formacion.dbms.dao;

import java.util.List;

import com.ipartek.formacion.pojo.CursoAlumno;

/**
 * Interfaz que define los metodos de las consultas a la BB.DD de la clase CursoAlumno.
 * 
 * @author anabel.
 * 
 * */
public interface CursoAlumnoDAO {

  /**
   * Metodo encargado de dar de alta modulos y alumnos.
   * 
   * 
   * @param cursoalumnos
   *          <code>CursoAlumnos</code> En este objeto de encapsulan los datos del curso, del alumno
   *          y de los modulos.
   * 
   * @return <code>CursoAlumnos</code>.
   */

  public void create(CursoAlumno cursoAlumno);

  /**
   * Metodo que permite añadir modulos y alumnos a un curso emitido.
   * 
   * @param cursoalumnos
   *          <code>CursoAlumnos</code> En este objeto de encapsulan los datos del curso, del alumno
   *          y de los modulos.
   */
  public void addModulosAlumnos(CursoAlumno cursoAlumno);

  /**
   * Metodo encargado de dar de baja modulos y alumnos de un curso y las calificaciones asociadas.
   * 
   * @param cursoalumnos
   *          <code>CursoAlumnos</code> En este objeto de encapsulan los datos del curso, del alumno
   *          y de los modulos.
   */

  public void deleteEmitidos(CursoAlumno cursoAlumno);

  /**
   * Metodo encargado de dar de baja modulos y alumnos de un curso y las calificaciones asociadas.
   * 
   * @param cursoalumnos
   *          <code>int</code> Codigo del curso emitido a borrar.
   */

  public void deleteCalificacion(CursoAlumno cursoAlumno);

  /**
   * Metodo encargado de modificar un alumno o un modulo.
   * 
   * @param cursoalumnos
   *          <code>CursoAlumno</code> En este objeto de encapsulan los datos del curso, del alumno
   *          y de los modulos.
   * 
   * @return <code>CursoAlumnos</code> Objeto curso que se ha solicitado con el listado de alumnos y
   *         modulos.
   */

  public CursoAlumno update(CursoAlumno cursoAlumno);

  /**
   * Vista en detalle del curso con alumnos y modulos. Permitira:
   * <ul>
   * <li>añadir quitar alumnos</li>
   * <li>añadir quitar alumnos</li>
   * </ul>
   * 
   * @param cursoalumnos
   *          <code>int</code> codigo del curso.
   * 
   * @return <code>CursoAlumnos</code> objeto curso que se ha solicitado con el listado de alumnos y
   *         modulos.
   */

  public CursoAlumno getById(int codigoCurso);

  /**
   * Este metodo devuelve el listado completo de curso.
   * 
   * @return <code>List<CursoAlumno></code> el listado completo de cursos.
   */

  public List<CursoAlumno> getAll();

  /**
   * Metodo que carga el curso en el que esta matriculado el alumno.
   * 
   * @param codigoAlumno
   *          <code>int</code> el codigo del alumno.
   * 
   * @return <code>CursoAlumnos</code> el curso emitido . <code>Alumno</code>.
   */
  public CursoAlumno getByAlumnoId(int codigoAlumno);
}
