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
    // if( codigoCurso==CursoAlumnos.CODIGO_CURSO)
    aux = cursoalumnos;
    aux.setCodigoEmitido(codigoCurso);
    // crear el registro en la tabla calificacion
    crearCursoModuloAlumnos(aux);
  }

  private void crearCursoModuloAlumnos(CursoAlumnos aux) {
    String sql = "{call insertCalificacion(?,?,?)}";
    try {
      CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
      cSmt.setInt("codCurso", aux.getCodigoEmitido());
      for (AlumnoModulo alumModulo : aux.getAlumnosmodulos()) {
        cSmt.setInt("codModulo", alumModulo.getModulo().getCodigo());
        cSmt.setInt("codAlumno", alumModulo.getAlumno().getCodigo());
        try {
          cSmt.executeUpdate();
        } catch (SQLException e) {
          LOG.fatal(e.getMessage());
        }
      }
    } catch (SQLException e) {
      LOG.fatal(e.getMessage());
    } finally {
      myConexion.desconectar();
    }

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
        Date fFin = null;
        fFin = cursoalumnos.getFechaFin();
        cSmt.setDate("fFin", new java.sql.Date(fFin.getTime()));
      } catch (NullPointerException e) {
        LOG.trace(e.getMessage());
        cSmt.setDate("fFin", null);
      }
      cSmt.executeUpdate();
      codigoCursoemision = cSmt.getInt("codigo_emision");
    } catch (SQLException e) {
      LOG.fatal(e.getMessage());
      codigoCursoemision = CursoAlumnos.CODIGO_CURSO;
    } finally {
      myConexion.desconectar();
    }

    return codigoCursoemision;
  }

  @Override
  public void update(CursoAlumnos cursoalumnos) {
    updateCursoEmision(cursoalumnos);
    updateCalificacion(cursoalumnos);
  }

  private void updateCursoEmision(CursoAlumnos cursoalumnos) {
    String sql = "updateCursoEmision(?,?,?,?,?)";
    try {
      CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
      cSmt.setInt("codCurso", cursoalumnos.getCodigo());
      cSmt.setInt("codigoCurso", cursoalumnos.getCodigoEmitido());
      cSmt.setString("referencia", cursoalumnos.getReferencia());
      cSmt.setDate("fInicio", new java.sql.Date(cursoalumnos.getFechaInicio().getTime()));
      try {
        cSmt.setDate("fFin", new java.sql.Date(cursoalumnos.getFechaFin().getTime()));
      } catch (NullPointerException e) {
        LOG.trace(e.getMessage() + " SIN FECHA FIN");
        cSmt.setDate("fFin", null);
      }
      cSmt.executeUpdate();
    } catch (SQLException e) {
      LOG.fatal(e.getMessage());
    } finally {
      myConexion.desconectar();
    }

  }

  private void updateCalificacion(CursoAlumnos cursoalumnos) {
    String sql = "{ call updateCalificacion(?,?,?,?,?)}";
    try {
      CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
      cSmt.setInt("codigoCurso", cursoalumnos.getCodigoEmitido());
      for (AlumnoModulo alumModulo : cursoalumnos.getAlumnosmodulos()) {
        cSmt.setInt("codigoAlumno", alumModulo.getAlumno().getCodigo());
        cSmt.setInt("codigoModulo", alumModulo.getModulo().getCodigo());
        try {
          cSmt.setDate("fExamen", new java.sql.Date(alumModulo.getfExamen().getTime()));
          cSmt.setInt("nota", alumModulo.getNotaExamen());
        } catch (NullPointerException e) {
          LOG.trace(e.getMessage() + " fecha del examen sin fijar");
          cSmt.setDate("fExamen", null);
          cSmt.setInt("nota", 0);
        }
        cSmt.executeUpdate();
      }
    } catch (SQLException e) {
      LOG.fatal(e.getMessage());

    } finally {
      myConexion.desconectar();
    }
  }

  @Override
  public CursoAlumnos getById(int codigoCurso) {

    return null;
  }

  @Override
  public List<CursoAlumnos> getAll() {
    String sql = "{call getAllCursosEmitidos()}";
    List<CursoAlumnos> cursoAlumnos = null;
    try {
      CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
      ResultSet rs = cSmt.executeQuery();
      cursoAlumnos = new ArrayList<CursoAlumnos>();
      while (rs.next()) {
        CursoAlumnos cAlumnos = parseCursoAlumnos(rs);
        cursoAlumnos.add(cAlumnos);
      }
    } catch (SQLException e) {
      LOG.fatal(e.getMessage());
    } finally {
      myConexion.desconectar();
    }

    return cursoAlumnos;
  }

  private CursoAlumnos parseCursoAlumnos(ResultSet rs) {
    CursoAlumnos cAlumnos = null;
    try {
      cAlumnos = new CursoAlumnos();
      cAlumnos.setCodigo(rs.getInt("codigo"));
      cAlumnos.setCodigoEmitido(rs.getInt("codigoEmitido"));
      cAlumnos.setCodigoPatrocinador(rs.getString("codigoPatrocinador"));
      cAlumnos.setNombre(rs.getString("nombre"));
      cAlumnos.setReferencia(rs.getString("referencia"));
      cAlumnos.setFechaInicio(rs.getDate("fInicio"));
      cAlumnos.setFechaFin(rs.getDate("fFin"));
      int codigo = rs.getInt("codigoTipoCurso");
      cAlumnos.setTipo(Util.parseTipo(codigo));
    } catch (SQLException e) {
      LOG.fatal(e.getMessage());
    }
    return cAlumnos;
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
