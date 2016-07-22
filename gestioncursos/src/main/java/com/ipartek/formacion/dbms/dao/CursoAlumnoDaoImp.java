package com.ipartek.formacion.dbms.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.pojo.CursoAlumno;

/**
 * 
 * Clase encargada de gestionar las altas, bajas y modificaciones en los cursos emitidos.
 * 
 * @author Anabel.
 *
 */
public class CursoAlumnoDaoImp implements CursoAlumnoDAO {

  private static CursoAlumnoDaoImp INSTANCE = null;
  private static final Logger LOG = Logger.getLogger(CursoAlumnoDaoImp.class);

  public static CursoAlumnoDaoImp getInstace() {

    if (INSTANCE == null) {
      createInstance();
    }
    return INSTANCE;
  }

  private static synchronized void createInstance() {
    if (INSTANCE == null) {
      INSTANCE = new CursoAlumnoDaoImp();
    }

  }

  /**
   * Metodo encargado de dar de alta en la tabla curso_emision un curso y dar de alta en la tabla
   * calificacion
   * 
   * @param cursoAlumno
   *          <code>cursoAlumno</code>
   * */
  @Override
  public void create(CursoAlumno cursoAlumno) {
    // dar de alta en la tabla curso_emision
    CursoAlumno aux = null;
    int codigoCurso = createCursoEmision(cursoAlumno);
    aux = cursoAlumno;
    aux.setCodigoEmitido(codigoCurso);
    // crear el registro en la tabla calificacion
    crearCursoModuloAlumnos(aux);

  }

  private int createCursoEmision(CursoAlumno cursoAlumno) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public CursoAlumno update(CursoAlumno cursoAlumno) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public CursoAlumno getById(int codigoCurso) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<CursoAlumno> getAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public CursoAlumno getByAlumnoId(int codigoAlumno) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void addModulosAlumnos(CursoAlumno cursoAlumno) {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteEmitidos(CursoAlumno cursoAlumno) {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteCalificacion(CursoAlumno cursoAlumno) {
    // TODO Auto-generated method stub

  }

}
