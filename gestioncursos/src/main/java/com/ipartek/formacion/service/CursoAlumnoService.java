package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.CursoAlumnos;

/**
 * <div> Este interfaz define los metodos de acceso a Base de Datos que aglutinan los cursos
 * emitidos:
 * <ul>
 * <li>dar de alta modulos a un curso</li>
 * <li>dar de alta alumnos a un curso</li>
 * <li>dar de alta cursos disponible <code>CursoAlumno</code></li>
 * <li>poner las notas de los examenes de los alumnos por cada modulo</li>
 * <li>actualizar la lista de alumnos de un curso</li>
 * <li>actualizar la lista de modulos de un curso</li>
 * <li>actualizar los datos de curso disponible <code>CursoAlumno</code> Fecha de inicio, Fecha de
 * Fin</li>
 * <li>obtener el listado de los cursos disponibles</li>
 * <li>obtener una vista en detalle de un curso disponible</li>
 * </ul>
 * </div>
 *
 * @author va00
 *
 */
public interface CursoAlumnoService {
  /**
   * <div> Metodo que nos carga los datos de un <code>CursoAlumno</code> pero la carga de
   * <code>List<ModuloCurso></code> se realiza de forma <i>Lazy</i> realizandola sólo en la vista en
   * detalle. </div>
   *
   * @return <code>List<CursoAlumnos></code>
   */
  public List<CursoAlumnos> getAll();

  /**
   * <div> Obtengo los datos completos de <code>CursoAlumnos</code>. </div>
   *
   * @param cursoAlumno
   *          <code>CursoAlumnos</code> con el <i>codigo</i> de <code>Alumno</code>, el
   *          <i>codigoEmitido</i> y el <i>codigo</i> de <code>Modulo</code>.
   * @return <code>CursoAlumnos</code>.
   */
  public CursoAlumnos getById(int codigoEmitido);
}
