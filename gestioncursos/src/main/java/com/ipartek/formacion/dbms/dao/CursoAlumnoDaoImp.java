package com.ipartek.formacion.dbms.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.pojo.CursoAlumno;
import com.ipartek.formacion.pojo.CursoAlumno.AlumnoModulo;
import com.ipartek.formacion.service.Util;

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
  private ConexionDB conexionDB;

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
    if (cursoAlumno.getAlumnosModulos().size() != 0) {
      createCursoModuloAlumnos(aux);
    }
  }

  private void createCursoModuloAlumnos(CursoAlumno aux) {

    String sql = "{call insertCalificacion(?,?,?)}";
    try {
      CallableStatement cStatement = conexionDB.getConexion().prepareCall(sql);
      cStatement.setInt("codCurso", aux.getCodigoEmitido());
      for (AlumnoModulo alumModulo : aux.getAlumnosModulos()) {
        cStatement.setInt("codAlumno", alumModulo.getAlumno().getCodigo());
        cStatement.setInt("codModulo", alumModulo.getModulo().getCodigo());
        try { // hacemos este segundo try catch, ya que el primero solo nos controla las dos
              // primeras sentencias sql y necesitamos controlar todas las sente
          cStatement.executeUpdate();
        } catch (SQLException e) {
          LOG.fatal(e.getMessage());
        }
      }
    } catch (SQLException e) {
      LOG.error(e.getMessage() + "ERROR EN LA CONEXION A LA BB.DD");
    } finally {
      conexionDB.desconectar();
    }
  }

  private int createCursoEmision(CursoAlumno cursoAlumno) {
    int codigoCursoEmision = CursoAlumno.CODIGO_CURSO;
    String sql = "{call insertCurso_emision(?,?,?,?,?)}";

    try {
      CallableStatement cStatement = conexionDB.getConexion().prepareCall(sql);
      cStatement.setInt("codCurso", cursoAlumno.getCodigo());
      cStatement.setString("referencia", cursoAlumno.getReferencia());
      cStatement.setDate("fInicio", new java.sql.Date(cursoAlumno.getfInicio().getTime()));

      try {
        Date fFin = null;
        fFin = cursoAlumno.getfFin();// Si la fecha es nula, tendremos que hacer saltar la
                                     // excepcion.
        cStatement.setDate("fFin", new java.sql.Date(fFin.getTime()));
      } catch (NullPointerException e) {
        LOG.trace(e.getMessage());
        cStatement.setDate("fFin", null);
      }
      cStatement.executeUpdate();
      codigoCursoEmision = cStatement.getInt("codigo_emision");
    } catch (SQLException e) {
      LOG.fatal(e.getMessage());
    } finally {
      conexionDB.desconectar();
    }
    return codigoCursoEmision;
  }

  @Override
  public CursoAlumno update(CursoAlumno cursoAlumno) {

    // Para poder actualizar curso alumno, necesitamos dos updates, uno correspondiente al curso que
    // estamos emitiendo, con sus correspondientes modulos y alumnos y tambien tendremos que
    // actualizar la tabla de calificaciones
    updateCursoEmision(cursoAlumno);
    updateCalificacion(cursoAlumno);
    return null;
  }

  private void updateCursoEmision(CursoAlumno cursoAlumno) {

    String sql = "{call updateCursoEmision(?,?,?,?,?)";
    try {
      CallableStatement cStatement = conexionDB.getConexion().prepareCall(sql);
      cStatement.setInt("codCurso", cursoAlumno.getCodigo());
      cStatement.setInt("codigoCurso", cursoAlumno.getCodigoEmitido());
      cStatement.setString("referencia", cursoAlumno.getReferencia());
      cStatement.setDate("fInicio", new java.sql.Date(cursoAlumno.getfInicio().getTime()));
      try {// con este try catch vamos a controlar el valor nulo que puede tomar fechaFin en la
           // BB.DD., cuantos menos valores nulos en la BB.DD. mejor
        cStatement.setDate("fFin", new java.sql.Date(cursoAlumno.getfFin().getTime()));
      } catch (NullPointerException e) {
        LOG.trace(e.getMessage() + "fecha fin nula");
        cStatement.setDate("fFin", null);
      }
      cStatement.executeUpdate();
    } catch (SQLException e) {
      LOG.fatal(e.getMessage());
    } finally {
      conexionDB.desconectar();
    }

  }

  private void updateCalificacion(CursoAlumno cursoAlumno) {
    String sql = "{call updateCalificacion(?,?,?,?,?)}";
    try {
      CallableStatement cStatement = conexionDB.getConexion().prepareCall(sql);
      cStatement.setInt("codigoCurso", cursoAlumno.getCodigoEmitido());
      for (AlumnoModulo alumModulo : cursoAlumno.getAlumnosModulos()) {
        cStatement.setInt("codAlumno", alumModulo.getAlumno().getCodigo());
        cStatement.setInt("codModulo", alumModulo.getModulo().getCodigo());
        try {
          cStatement.setDate("fExamen", new java.sql.Date(alumModulo.getfExamen().getTime()));
          cStatement.setInt("nota", alumModulo.getNotaExamen());
        } catch (NullPointerException e) {
          LOG.trace(e.getMessage() + "fecha nula");
          cStatement.setDate("fExamen", null);
          cStatement.setInt("nota", 0);
        }

        cStatement.executeUpdate();
      }
    } catch (SQLException e) {
      LOG.fatal(e.getMessage() + "Error en la conexion a la BB.DD");
    } finally {
      conexionDB.desconectar();
    }
  }

  @Override
  public CursoAlumno getById(int codigoCurso) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<CursoAlumno> getAll() {

    List<CursoAlumno> cursoAlumnos = null;
    CursoAlumno cursoAlumno = null;
    String sql = "{call getAllCursosEmitidos()}";
    try {
      cursoAlumnos = new ArrayList<CursoAlumno>();
      CallableStatement cStatement = conexionDB.getConexion().prepareCall(sql);
      ResultSet rs = cStatement.executeQuery();

      while (rs.next()) {
        cursoAlumno = parseCursoAlumno(rs);
        cursoAlumnos.add(cursoAlumno);
      }
    } catch (SQLException e) {
      LOG.fatal(e.getMessage() + "Error en la conexion a la BB.DD");
    } finally {
      conexionDB.desconectar();
    }
    return null;
  }

  private CursoAlumno parseCursoAlumno(ResultSet rs) {
    CursoAlumno cursoAlumno = null;
    cursoAlumno = new CursoAlumno();
    try {
      cursoAlumno.setCodigo(rs.getInt("codigo"));
      cursoAlumno.setCodigoEmitido(rs.getInt("codigoEmitido"));
      cursoAlumno.setReferencia(rs.getString("referencia"));
      cursoAlumno.setCodPatrocinador(rs.getString("codPatrocinador"));
      cursoAlumno.setfInicio(rs.getDate("fInicio"));
      cursoAlumno.setNombre(rs.getString("nombre"));
      cursoAlumno.setTipo(Util.parseTipoCurso(String.valueOf(rs.getInt("codTipoCurso"))));
      cursoAlumno.setfFin(rs.getDate("fFin"));// en este caso no tenemos que comprobar la excepcion,
                                              // ya que cuando queremos meter un dato(set) y este es
                                              // nulo no hay ningun problema, el problema viene
                                              // cuando es un get
    } catch (SQLException e) {
      LOG.fatal(e.getMessage());
    }

    return cursoAlumno;
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
