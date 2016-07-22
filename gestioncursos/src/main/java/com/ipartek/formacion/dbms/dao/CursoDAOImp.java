package com.ipartek.formacion.dbms.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.pojo.Curso;
import com.ipartek.formacion.service.Util;

public class CursoDAOImp implements CursoDAO {

  private static final Logger LOG = Logger.getLogger(CursoDAOImp.class);
  private ConexionDB conexionDB;
  private static CursoDAOImp INSTANCE = null;

  private CursoDAOImp() {
    this.conexionDB = ConexionDBImp.getInstance();
  }

  // Los siguientes dos metodos, son los metodos relativos al SINGLETON
  public static CursoDAOImp getInstance() {

    if (INSTANCE == null) {
      createInstance();
    }
    return INSTANCE;
  }

  private synchronized static void createInstance() {

    if (INSTANCE == null) {
      INSTANCE = new CursoDAOImp();
    }
  }

  @Override
  public Curso getById(int codigo) {

    Curso curso = null;
    String sql = "{call getCursoById(?)}";
    conexionDB.conectar();
    Connection connection = conexionDB.getConexion();
    try {
      CallableStatement cStatement = connection.prepareCall(sql);
      cStatement.setInt("codigo", codigo);
      ResultSet set = cStatement.executeQuery();// Nos devuelve los
      // parametros que
      // queremos, pero
      // tendremos que
      // parsearlo a curso
      while (set.next()) {
        curso = parseCurso(set);
      }
    } catch (SQLException e) {
      LOG.fatal(e.getMessage());
    } finally {
      conexionDB.desconectar();
    }

    return curso;
  }

  private Curso parseCurso(ResultSet set) {

    Curso curso = null;
    curso = new Curso();
    try {
      curso.setCodigo(set.getInt("codCurso"));
      curso.setNombre(set.getString("nCurso"));
      int tipoCurso = set.getInt("codTipoCurso");
      curso.setTipo(Util.parseTipoCurso(String.valueOf(tipoCurso)));
      curso.setCodPatrocinador(set.getString("codPatrocinador"));
    } catch (SQLException e) {
      LOG.fatal(e.getMessage());
    }
    return curso;
  }

  @Override
  public Curso update(Curso curso) {

    Curso cur = null;
    String sql = "{call updateCurso(?,?,?,?)}";
    conexionDB.conectar();
    Connection connection = conexionDB.getConexion();

    try {
      CallableStatement cStatement = connection.prepareCall(sql);
      cStatement.setInt("codigo", curso.getCodigo());
      cStatement.setInt("codTipoCurso", curso.getTipo().getCodigo());
      cStatement.setString("nombre", curso.getNombre());
      cStatement.setString("codPatrocinador", curso.getCodPatrocinador());
      cur = curso;
      cStatement.executeUpdate();
    } catch (SQLException e) {
      LOG.fatal(e.getMessage());
      cur = getById(curso.getCodigo());
    } finally {
      conexionDB.desconectar();
    }

    return cur;
  }

  @Override
  public Curso create(Curso curso) {
    Curso cur = null;
    String sql = "{call insertCurso(?,?,?,?)}";
    conexionDB.conectar();
    Connection connection = conexionDB.getConexion();

    try {
      CallableStatement cStatement = connection.prepareCall(sql);
      cStatement.setInt("codCurso", curso.getCodigo());
      cStatement.setInt("codTipoCurso", curso.getTipo().getCodigo());
      cStatement.setString("nombre", curso.getNombre());
      cStatement.setString("codPatrocinador", curso.getCodPatrocinador());
      cStatement.executeUpdate();
      cur = curso;
      cur.setCodigo(cStatement.getInt("codigo"));
    } catch (SQLException e) {
      LOG.fatal(e.getMessage());
      cur = getById(curso.getCodigo());
    } finally {
      conexionDB.desconectar();
    }
    return cur;
  }

  @Override
  public void delete(int codigo) {

    String sql = "{call deleteCurso(?)}";
    conexionDB.conectar();
    Connection connection = conexionDB.getConexion();

    try {
      CallableStatement cStatement = connection.prepareCall(sql);
      cStatement.setInt("codigo", codigo);
      cStatement.executeUpdate();
    } catch (SQLException e) {
      LOG.fatal(e.getMessage());
    } finally {
      conexionDB.desconectar();
    }

  }

  @Override
  public List<Curso> getAll() {

    String sql = "{call getAllCurso()}";
    List<Curso> cursos = null;
    Curso curso = null;

    // conexionDB.conectar();
    Connection connection = conexionDB.getConexion();
    try {
      CallableStatement callableStatement = connection.prepareCall(sql);
      ResultSet rs = callableStatement.executeQuery();

      cursos = new ArrayList<Curso>();
      while (rs.next()) {
        curso = parseCurso(rs);
        cursos.add(curso);
      }
    } catch (SQLException e) {
      LOG.fatal(e.getMessage() + "esta mal aqui");
    } finally {
      conexionDB.desconectar();

    }

    return cursos;
  }

}
