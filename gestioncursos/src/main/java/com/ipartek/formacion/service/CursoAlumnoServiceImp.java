package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.dbms.dao.CursoAlumnosDao;
import com.ipartek.formacion.dbms.dao.CursoAlumnosDaoImp;
import com.ipartek.formacion.pojo.CursoAlumnos;
/**
 * Clase que implementa <code>CursoAlumnoService</curso> gestionando las funcionalidades
 * @author Curso
 *
 */
public class CursoAlumnoServiceImp implements CursoAlumnoService {
private static CursoAlumnoServiceImp INSTANCE=null;
private CursoAlumnosDao cAlumnoDAO;

private CursoAlumnoServiceImp(){
  cAlumnoDAO=CursoAlumnosDaoImp.getInstance();
}

private static synchronized void createInstance(){
  if (INSTANCE==null) {
    INSTANCE=new CursoAlumnoServiceImp();
  }
}
public static CursoAlumnoServiceImp getInstance(){
  if (INSTANCE==null) {
    createInstance();
  }
  
  
  return INSTANCE;
  
}

  @Override
  public List<CursoAlumnos> getAll() {
    List<CursoAlumnos>cursoAlumnos=cAlumnoDAO.getAll();
    
    
    return cursoAlumno;
  }

  @Override
  public CursoAlumnos getById(int  codigoEmitido) {

    CursoAlumnos cAlumno=cAlumnoDAO.getByAlumno(cursoAlumno.getCodigoEmitido());
    return null;
  }

}
