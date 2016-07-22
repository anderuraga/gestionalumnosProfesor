package com.ipartek.formacion.dbms.dao;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.pojo.CursoAlumnos;

/**
 * 
 * @author Imanol Operaciones CRUD para Curso_alumno y calificacion.
 *
 */
public class CursoAlumnoDAOImp implements CursoAlumnoDAO {
  private final static Logger LOG = Logger.getLogger(CursoAlumnoDAOImp.class);
  private static CursoAlumnoDAOImp INSTANCE = null;
  private static ConexionDB myConexion;
  private Connection conexion;

  /**
 * 
 */
  private CursoAlumnoDAOImp() {
    myConexion = ConexionDBImp.getInstance();
  }

  /**
   * 
   * @return <code>INSTANCE</code>
   */
  public static CursoAlumnoDAOImp getInstance() {
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
      INSTANCE = new CursoAlumnoDAOImp();
    }
  }

  /**
   * @Override
   * @return nada
   * @throws CloneNotSupportedException
   *           no se puede cñlonar
   */
  protected Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
  }

  /**
   * @Override
   * @param codigoCurso
   *          <code>int</code>
   * @return <code>CursoAlumnos</code>
   */
  public CursoAlumnos getById(int codigoCurso) {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * @Override
   * @param codigoAlumno
   *          <code>int</code>
   * @return <code>CursoAlumnos</code>
   */
  public CursoAlumnos getByAlumnoId(int codigoAlumno) {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * @Override
   * @param cursoAlumnos
   *          <code>CursoAlumnos</code>
   * @return <code>CursoAlumnos</code>
   */
  public CursoAlumnos update(CursoAlumnos cursoAlumnos) {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * @Override
   * @param cursoAlumnos
   *          <code>CursoAlumnos</code>
   */
  public void create(CursoAlumnos cursoAlumnos) {
    // dar de alta en la tabla curso_emision
    CursoAlumnos aux = null;
    int codigoCurso = createCursoEmision(cursoAlumnos);
    aux = cursoAlumnos;
    aux.setCodigoEmitido(codigoCurso);
    // crear el registro en la tabla calificacion

  }

  /**
   * 
   * @param cursoAlumnos
   *          {@link CursoAlumnos}
   * @return <code>int</code>
   */
  private int createCursoEmision(CursoAlumnos cursoAlumnos) {
    int codigo = 0;
    return codigo;

  }

  /**
   * @Override
   * @param codigoCurso
   *          <code>CursoAlumnos</code>
   */
  public void deleteEmitidos(int codigoCurso) {
    // TODO Auto-generated method stub

  }

  /**
   * @Override
   * @param cursoAlumnos
   *          <code>CursoAlumnos</code>
   */
  public void deleteCalificacion(CursoAlumnos cursoAlumnos) {
    // TODO Auto-generated method stub

  }

  /**
   * @Override
   * @param cursoAlumnos
   *          <code>CursoAlumnos</code>
   */
  public void addModulosAlumnos(CursoAlumnos cursoAlumnos) {
    // TODO Auto-generated method stub

  }

  /**
   * @Override
   * @return <code>List<cursoAlumnos></code>
   */
  public List<CursoAlumnos> getAll() {
    // TODO Auto-generated method stub
    return null;
  }

}
