package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistencia.Alumno;

/**
 * Interfaz que define los metodos, que van a contactar con la BB.DD en referencia con Alumnos.
 * 
 * @author Curso
 *
 */
public interface AlumnoDAO extends DAOSetter {

  /**
   * Metodo que devuelve todos los alumnos que hay en la BB.DD.
   * 
   * @return alumnos <code>List<Alumno></code> listado de todos los alumnos
   */
  public List<Alumno> getAll();
}
