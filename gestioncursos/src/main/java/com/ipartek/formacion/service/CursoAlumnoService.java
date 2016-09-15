package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.pojo.CursoAlumnos;
import com.ipartek.formacion.pojo.Modulo;

/**
 * Define los metodos de acceso a la DB de CursoAlumnosDAO.
 * 
 * @author Curso.
 *
 */
public interface CursoAlumnoService {
  /**
   * Metodo que nos carga los datos de un CursoAlumno pero la carga se realiza de forma <i>lazy</i>.
   * 
   * @return cursoAlumno.
   */
  public List<CursoAlumnos> getAll();

  /**
   * Obtengo los datos completos de {@link CursoAlumnos}.
   * 
   * @param cursoAlumno
   *          {@link CursoAlumnos} con el codigo de {@link Alumno}, {@link Modulo} y el codigo
   *          Emitido.
   * 
   * @return {@link CursoAlumnos}.
   */
  public CursoAlumnos getById(CursoAlumnos cursoAlumno);
}
