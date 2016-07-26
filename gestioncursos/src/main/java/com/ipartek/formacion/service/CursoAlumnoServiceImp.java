package com.ipartek.formacion.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.dao.CursoAlumnoDAO;
import com.ipartek.formacion.dbms.dao.CursoAlumnoDaoImp;
import com.ipartek.formacion.pojo.CursoAlumno;

/**
 * Clase que implementa el <code>CursoAlumnoService</code> gestiona las funcionalidades de
 * <code>CursoAlumnoService</code>
 * 
 * @author Curso
 *
 */
public class CursoAlumnoServiceImp implements CursoAlumnoService {

  private static CursoAlumnoServiceImp INSTANCE = null;
  private Logger LOG = Logger.getLogger(CursoAlumnoServiceImp.class);
  private CursoAlumnoDAO cAlumnoDAO;

  public CursoAlumnoServiceImp() {
    cAlumnoDAO = CursoAlumnoDaoImp.getInstace();
  }

  public static CursoAlumnoServiceImp getInstance() {
    if (INSTANCE == null) {
      createInstance();
    }
    return INSTANCE;

  }

  private static synchronized void createInstance() {

    if (INSTANCE == null) {
      INSTANCE = new CursoAlumnoServiceImp();
    }
  }

  @Override
  public List<CursoAlumno> getAll() {

    List<CursoAlumno> cursoAlumnos = cAlumnoDAO.getAll();

    return cursoAlumnos;
  }

  @Override
  public CursoAlumno getById(int codigoEmitido) {
    CursoAlumno cAlu = null;
    cAlu = cAlumnoDAO.getById(codigoEmitido);
    return cAlu;
  }

  @Override
  public void create(CursoAlumno cursoAlumno) {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(int codigo) {
    // TODO Auto-generated method stub

  }

}
