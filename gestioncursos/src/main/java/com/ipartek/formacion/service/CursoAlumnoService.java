package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.CursoAlumno;

/**
 * Interfaz que define los metodos de acceso a la BB.DD que aglutinan los cursos emitidos.
 * <ul>
 * <li>Dar de alta modulos a un curso</li>
 * <li>Dar de alta alumnos a un curso</li>
 * <li>Dar de alta cursos disponibles <code>CursoAlumno</code></li>
 * <li>Calificar a los alumnos por cada modulo realizado de un curso determinado</li>
 * <li>Actualizar la lista de alumnos de un curso</li>
 * <li>Actualizar la lista de modulos de un curso</li>
 * <li>actualizar los datos de curso disponible <code>CursoAlumno</code></li>
 * <li>Obtener el listado de cursos disponibles</li>
 * <li>Obtener una vista en detalle de un curso disponible</li>
 * </ul>
 * 
 * @author Curso
 *
 */
public interface CursoAlumnoService {

  /**
   * <div> Metodo que nos carga los datos de un <code>CursoAlumno</code> pero la carga de
   * <code>List<ModuloCurso></code> se realiza de forma <i>Lazy</i> realizando solo en la vista en
   * detalle. </div>
   * 
   * @return <code>List<CursoAlumno></code>
   */
  public List<CursoAlumno> getAll();

  /**
   * <div>Obtengo los datos completos de <code><CursoAlumno</code>.</div>
   * 
   * @param cursoAlumno
   *          <code>CursoAlumno</code> con el <i>codigo</i> de <code>Alumno</code>, el
   *          <i>codigoEmitido</i> y el <i>codigo</i> de <code>Modulo</code>
   * @return <code>CursoAlumno</code>
   */
  public CursoAlumno getById(int CodigoEmitido);

  public void create(CursoAlumno cursoAlumno);

  public void delete(int codigo);
}
