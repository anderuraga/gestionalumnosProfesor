package com.ipartek.formacion.dbms.dao;

import java.util.List;

import com.ipartek.formacion.pojo.CursoAlumnos;

/**
 * Interfaz que define los metodos de consulta a Base de Datos de la clase <code>CursoAlumnos</code>
 * .
 *
 * @author Curso
 *
 */
public interface CursoAlumnosDAO {
  /**
   * Metodo encargado de dar alta modulos y alumnos en la Base de Datos.
   *
   * @param cursoalumnos
   *          <code>CursoAlumnos</code> En este objeto se encapsulan los datos del curso, de los
   *          alumnos y de los modulos.
   * @return <code>CursoAlumnos</code>
   */
  public void create(CursoAlumnos cursoalumnos);

  /**
   *
   * Metodo que permite añadir modulos y alumnos a un curso emitido.
   * 
   * @param cursoalumnos
   *          <code>CursoAlumnos</code> En este objeto se encapsulan los datos del curso, de los
   *          alumnos y de los modulos.
   */

  public void addModulosAlumnos(CursoAlumnos cursoAlumnos);

  /**
   * Metodo que se encarga de dar de baja modulos y alumnos de un curso y de borrar un curso
   * emitido.
   *
   * @param cursoalumnos
   *          <code>int</code> el codigo del curso emitido a borrar.
   */
  public void deleteEmitidos(int codigoCurso);

  /**
   * Metodo que se encarga de dar de baja modulos y alumnos de un curso y de borrar un curso
   * emitido.
   *
   * @param cursoalumnos
   *          <code>CursoAlumnos</code> En este objeto se encapsulan los datos del curso, de los
   *          alumnos y de los modulos.
   */
  public void deleteCalifacion(CursoAlumnos cursoAlumnos);

  /**
   * Metodo que se encarga de actualizar los datos de modulos y alumnos de un curso.
   *
   * @param cursoalumnos
   */
  public void update(CursoAlumnos cursoalumnos);

  /**
   * Vista en detalle del curso con alumnos y modulos. Permitira
   *
   * @param codigoCurso
   *          <code>int</code> el codigo del curos emitido.
   * @return <code>CursoAlumnos</code> el objeto curso que se ha solicitado con el listado de
   *         alumnos y modulos.
   */
  public CursoAlumnos getById(int codigoCurso);

  /**
   * Este metodo devuelve el listado completo de cursos emitidos.
   *
   * @return <code>List<CursoAlumnos></code> el listado completo de <code>CursoAlumnos</code>.
   */
  public List<CursoAlumnos> getAll();

  /**
   * Metodo que carga el curso en el que esta matriculado el alumno.
   *
   * @param codigoAlumno
   *          <code>int</code> el codigo del alumno.
   * @return <code>CursoAlumnos</code> el curso emitido en el que esta matriculado el
   *         <code>Alumno</code>.
   */
  public CursoAlumnos getByAlumnoId(int codigoAlumno);
}