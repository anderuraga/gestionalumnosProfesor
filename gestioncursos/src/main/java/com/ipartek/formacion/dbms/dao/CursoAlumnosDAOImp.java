package com.ipartek.formacion.dbms.dao;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.pojo.CursoAlumnos;

/**
 * Clase que se engarga de gestionar las altas bajas y modificaciones en los cursos emitidos.
 *
 * @author va00
 *
 */
public class CursoAlumnosDAOImp implements CursoAlumnosDAO {

  private static final Logger LOG = Logger.getLogger(CursoAlumnosDAOImp.class);
  private static CursoAlumnosDAOImp INSTANCE = null;
  private ConexionDB myConexion = null;

  /**
   *
   */
  private CursoAlumnosDAOImp() {
    myConexion = ConexionDBImp.getInstance();
  }

  /**
   *
   * @return INSTANCE
   */
  public static CursoAlumnosDAOImp getInstance() {
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
      INSTANCE = new CursoAlumnosDAOImp();
    }
  }

  /**
   * @Override
   * @return nada
   * @throws CloneNotSupportedException
   *           no se puede cñlonar
   */
  @Override
  protected Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
  }

  @Override
  public void create(CursoAlumnos cursoalumnos) {
    // dar de alta en la tabla curso_emision
    CursoAlumnos aux = null;
    int codigoCurso = createCursoEmision(cursoalumnos);
    aux = cursoalumnos;
    aux.setCodigoEmitido(codigoCurso);
    // crear el registro en la tabla calificacion
    crearCursoModuloAlumnos(aux);
  }

  private void crearCursoModuloAlumnos(CursoAlumnos aux) {
    // TODO Auto-generated method stub

  }

  private int createCursoEmision(CursoAlumnos cursoalumnos) {
    int codigoCursoemision = CursoAlumnos.CODIGO_CURSO;
    String sql = "{call insertCurso_emision(?,?,?,?,?)}";

    try {
      CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
      cSmt.setInt("codCurso", cursoalumnos.getCodigo());
      cSmt.setString("referencia", cursoalumnos.getReferencia());
      cSmt.setDate("fInicio", new java.sql.Date(cursoalumnos.getFechaInicio().getTime()));
      try {

      } catch (NullPointerException e) {

      }

    } catch (SQLException e) {
      LOG.fatal(e.getMessage());
    } finally {
      myConexion.desconectar();
    }

    return codigoCursoemision;
  }

  @Override
  public void update(CursoAlumnos cursoalumnos) {

  }

  @Override
  public CursoAlumnos getById(int codigoCurso) {

    return null;
  }

  @Override
  public List<CursoAlumnos> getAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public CursoAlumnos getByAlumnoId(int codigoAlumno) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void addModulosAlumnos(CursoAlumnos cursoAlumnos) {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteEmitidos(int codigoCurso) {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteCalifacion(CursoAlumnos cursoAlumnos) {
    // TODO Auto-generated method stub

  }

}
