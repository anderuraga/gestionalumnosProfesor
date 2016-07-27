package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.CursoAlumnos;

/**
 * Este interfaz define los metodos de acceso a base de datos que 
 * aglutinan los cursos emitidos
 * <ul>
 * <li>dar de alta modulos a un curso </li>
 * <li>dar de alta alumnos  a un curso </li>
 * <li>dar de alta cursos disponibles </li><code>CursoAlumno</code>
 * <li>dar de altamodulos a un curso </li>
 * <li>poner las notas de los examenes de los alumnos por cada modulo </li>
 * <li>actualizar la lista de modulos de un curso </li>
 * <li>Obtener u </li>
 * 
 * </ul>
 * @author Curso
 *
 */
public interface CursoAlumnoService {

  //crud
  /**
   * metodo   que carga los datos de un <code>CursoAlumno</code> pero la carga de 
   * <code>List<CursoAlumnos></code> se realiza de forma <i>lazy</i>
   * @return <code>List</code>
   */
  public List<CursoAlumnos> getAll();
  /**
   * 
   * @param cursoAlumnos
   * @return CursoAlumnos
   */
  public CursoAlumnos getById(CursoAlumnos cursoAlumnos);
  
  
}
