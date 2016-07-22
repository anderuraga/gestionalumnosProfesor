package com.ipartek.formacion.dbms.dao;

import java.util.List;

import com.ipartek.formacion.pojo.CursoAlumnos;

/**
 * Interfaz que define los metodos de consulta de la base de datos <code>CursoAlumnos</code>.
 * 
 * @author Imanol Jimenez
 *
 */
public interface CursoAlumnoDAO {
  /**
   * @param codigoCurso
   *          <code>int</code> codigo del curso emitido.
   * @return cursoAlumnos {@link CursoAlumnos}
   */
  public CursoAlumnos getById(int codigoCurso);

  /**
   * @param codigoAlumno
   *          <code>int</code> codigo del alumno
   * @return cursoAlumnos {@link CursoAlumnos}
   */
  public CursoAlumnos getByAlumnoId(int codigoAlumno);

  /**
   * 
   * @param cursoAlumnos
   *          {@link CursoAlumnos}
   * @return cursoAlumnos actualizado
   */
  public CursoAlumnos update(CursoAlumnos cursoAlumnos);

  /**
   * Metodo encargado de dar de alta modulos y alumnos en la DB.
   * 
   * @param cursoAlumnos
   *          {@link CursoAlumnos}
   */
  public void create(CursoAlumnos cursoAlumnos);

  /**
   * Da de baja modulos y alumnos y borra el curso emitido.
   * 
   * @param codigoCurso
   *          <code>int</code> codigo de curso emitido.
   */
  public void deleteEmitidos(int codigoCurso);

  /**
   * Solamente de baja modulos y alumnos
   * 
   * @param cursoAlumnos
   *          {@link CursoAlumnos}
   */
  public void deleteCalificacion(CursoAlumnos cursoAlumnos);

  /**
   * 
   * @return <code>List<CursoAlumnos></code>
   */
  public List<CursoAlumnos> getAll();

  /**
   * 
   * @param cursoAlumnos
   *          <code>CursoAlumnos</code>
   */
  public void addModulosAlumnos(CursoAlumnos cursoAlumnos);
}
