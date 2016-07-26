package com.ipartek.formacion.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.dao.CursoAlumnoDAO;
import com.ipartek.formacion.dbms.dao.CursoAlumnoDAOImp;
import com.ipartek.formacion.pojo.CursoAlumnos;

/**
 * Implementacion de la interfaz {@link CursoAlumnoService}
 * 
 * @author Curso
 *
 */
public class CursoAlumnoServiceImp implements CursoAlumnoService {
  private final static Logger LOG = Logger.getLogger(CursoAlumnoServiceImp.class);
  private static CursoAlumnoServiceImp INSTANCE = null;
  private CursoAlumnoDAO cAlumnoDAO;

  /**
   * Contructor
   */
  private CursoAlumnoServiceImp() {
    cAlumnoDAO = CursoAlumnoDAOImp.getInstance();
  }

  /**
   * 
   * @return intance
   */
  public static CursoAlumnoServiceImp getInstance() {
    if (INSTANCE == null) {
      createInstance();
    }
    return INSTANCE;
  }

  /**
 * 
 */
  private synchronized static void createInstance() {
    if (INSTANCE == null) {
      INSTANCE = new CursoAlumnoServiceImp();
    }
  }

  /**
   * @Override
   * @return no devuelve nada
   * @throws CloneNotSupportedException
   *           no se puede clonar el objeto
   */
  protected Object clone() throws CloneNotSupportedException {
    LOG.error("Error al clonar");
    throw new CloneNotSupportedException();
  }

  /**
   * @Override
   * @return {@link CursoAlumnos}
   */
  public List<CursoAlumnos> getAll() {
    List<CursoAlumnos> cursoAlumnos = cAlumnoDAO.getAll();

    return cursoAlumnos;
  }

  /**
   * @Override
   * @param cursoAlumno
   *          {@link CursoAlumnos}
   * @return {@link CursoAlumnos}
   */
  public CursoAlumnos getById(CursoAlumnos cursoAlumno) {

    return cAlumnoDAO.getById(cursoAlumno.getCodigo());
  }

}
