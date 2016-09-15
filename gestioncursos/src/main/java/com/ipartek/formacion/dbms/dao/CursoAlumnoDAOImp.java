package com.ipartek.formacion.dbms.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.pojo.CursoAlumnos;
import com.ipartek.formacion.pojo.CursoAlumnos.AlumnoModulo;
import com.ipartek.formacion.service.Util;

/**
 * 
 * @author Imanol Operaciones CRUD para Curso_alumno y calificacion.
 *
 */
public class CursoAlumnoDAOImp implements CursoAlumnoDAO {
  private final static Logger LOG = Logger.getLogger(CursoAlumnoDAOImp.class);
  private static CursoAlumnoDAOImp INSTANCE = null;
  private static ConexionDB myConexion;

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
   */
  public void update(CursoAlumnos cursoAlumnos) {
    updateCursoEmision(cursoAlumnos);
    updateCalificacion(cursoAlumnos);
  }

  /**
   * 
   * @param cursoAlumnos
   *          {@link CursoAlumnos}
   */
  private void updateCalificacion(CursoAlumnos cursoAlumnos) {
    String sql = "{call updateCalificacion(?,?,?,?,?)}";
    try {
      CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
      cSmt.setInt("codigoCurso", cursoAlumnos.getCodigoEmitido());
      for (AlumnoModulo alumModulo : cursoAlumnos.getAlumnosModulos()) {
        cSmt.setInt("codigoAlumno", alumModulo.getAlumno().getCodigo());
        cSmt.setInt("codigoModulo", alumModulo.getModulo().getCodigo());
        try {
          cSmt.setDate("fExamen", new java.sql.Date(alumModulo.getFechaExamen().getTime()));
          cSmt.setInt("nota", alumModulo.getNotaExamen());
        } catch (NullPointerException e) {
          LOG.trace(e.getMessage() + " Sin fecha de examen");
          cSmt.setDate("fExamen", null);
          cSmt.setInt("nota", 0);
        }
        try {
          cSmt.executeUpdate();
        } catch (SQLException e) {
          LOG.fatal(e.getMessage());
        }
      }

    } catch (SQLException e) {
      LOG.fatal(e.getMessage() + " --Error al actualizar calificacion");
    } finally {
      myConexion.desconectar();
    }

  }

  /**
   * 
   * @param cursoAlumnos
   *          {@link CursoAlumnos}
   */
  private void updateCursoEmision(CursoAlumnos cursoAlumnos) {
    String sql = "{call updateCurso_emision(?,?,?,?,?)}";
    try {
      CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
      cSmt.setInt("codCurso", cursoAlumnos.getCodigo());
      cSmt.setInt("codigoCurso", cursoAlumnos.getCodigoEmitido());
      cSmt.setString("referencia", cursoAlumnos.getReferencia());
      cSmt.setDate("fInicio", new java.sql.Date(cursoAlumnos.getFechaInicio().getTime()));
      try {
        cSmt.setDate("fFin", new java.sql.Date(cursoAlumnos.getFechaFin().getTime()));
      } catch (NullPointerException e) {
        LOG.trace(e.getMessage() + " Sin fecha fin");
        cSmt.setDate("fFin", null);
      }
      cSmt.executeUpdate();
    } catch (SQLException e) {
      LOG.fatal(e.getMessage() + " --Error al actualizar curso_emision");
    } finally {
      myConexion.desconectar();
    }

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
    if (codigoCurso == CursoAlumnos.CODIGO_CURSO_ALUMNO) {

    }
    aux = cursoAlumnos;
    aux.setCodigoEmitido(codigoCurso);
    // crear el registro en la tabla calificacion

    crearCursoModuloAlumnos(aux);

  }

  /**
   * @param cursoAlumnos
   *          {@link CursoAlumnos}
   */
  private void crearCursoModuloAlumnos(CursoAlumnos cursoAlumnos) {
    String sql = "{call insertCalificacion(?,?,?)}";
    try {
      CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
      cSmt.setInt("codCurso", cursoAlumnos.getCodigoEmitido());
      for (AlumnoModulo alumModulo : cursoAlumnos.getAlumnosModulos()) {
        cSmt.setInt("codAlumno", alumModulo.getAlumno().getCodigo());
        cSmt.setInt("codModulo", alumModulo.getModulo().getCodigo());
        try {
          cSmt.executeUpdate();
        } catch (SQLException e) {
          LOG.fatal(e.getMessage());
        }
      }

    } catch (SQLException e) {
      LOG.fatal(e.getMessage() + " --Error al crear calificacion");
    } finally {
      myConexion.desconectar();
    }
  }

  /**
   * @param cursoAlumnos
   *          {@link CursoAlumnos}
   * @return <code>int</code>
   */
  private int createCursoEmision(CursoAlumnos cursoAlumnos) {
    int codigoCursoEmision = CursoAlumnos.CODIGO_CURSO_ALUMNO;
    String sql = "{call insertCurso_emision(?,?,?,?,?)}";
    try {
      CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
      cSmt.setInt("codCurso", cursoAlumnos.getCodigo());
      cSmt.setString("referencia", cursoAlumnos.getReferencia());
      cSmt.setDate("fInicio", new java.sql.Date(cursoAlumnos.getFechaInicio().getTime()));
      try {
        cSmt.setDate("fFin", new java.sql.Date(cursoAlumnos.getFechaFin().getTime()));
      } catch (NullPointerException e) {
        LOG.trace(e.getMessage());
        cSmt.setDate("fFin", null);
      } catch (SQLException e) {
        LOG.fatal(e.getMessage());
        codigoCursoEmision = -1;
      }
      cSmt.executeUpdate();
      codigoCursoEmision = cSmt.getInt("codEmision");
    } catch (SQLException e) {
      LOG.fatal(e.getMessage() + " --Error al crear curso_emision");
    } finally {
      myConexion.desconectar();
    }
    return codigoCursoEmision;

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
    List<CursoAlumnos> cursoAlumnos = null;
    String sql = "{call getAllCursosEmitidos()}";
    try {
      CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
      ResultSet rs = cSmt.executeQuery();
      cursoAlumnos = new ArrayList<CursoAlumnos>();
      while (rs.next()) {
        cursoAlumnos.add(parseCursoAlumnos(rs));
      }

    } catch (SQLException e) {
      LOG.fatal(e.getMessage());
    } finally {
      myConexion.desconectar();
    }

    return cursoAlumnos;
  }

  /**
   * 
   * @param rs
   *          {@link ResultSet}
   * @return cursoAlumnos
   */
  private CursoAlumnos parseCursoAlumnos(ResultSet rs) {
    CursoAlumnos cursoAlum = null;
    cursoAlum = new CursoAlumnos();
    try {
      cursoAlum.setCodigo(rs.getInt("codigo"));
      cursoAlum.setCodigoEmitido(rs.getInt("codigoEmitido"));
      cursoAlum.setCodigoPatrocinador(rs.getString("codigoPatrocinador"));
      cursoAlum.setNombre(rs.getString("nombre"));
      cursoAlum.setReferencia(rs.getString("referencia"));
      cursoAlum.setFechaInicio(new Date(rs.getDate("fInicio").getTime()));
      cursoAlum.setFechaFin(new Date(rs.getDate("fFin").getTime()));
      cursoAlum.setTipo(Util.parseTipo(rs.getInt("codTipoCurso")));

    } catch (SQLException e) {
      LOG.fatal(e.getMessage());
    }
    return cursoAlum;
  }
}
