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
import com.ipartek.formacion.pojo.Modulo;
import com.ipartek.formacion.service.Util;

public class ModuloDAOImp implements ModuloDAO {

  private static ModuloDAOImp INSTANCE = null;
  private ConexionDB conexionDB = null;
  private static Logger LOG = Logger.getLogger(ModuloDAOImp.class);

  public ModuloDAOImp() {
    conexionDB = ConexionDBImp.getInstance();
  }

  public static ModuloDAO getInstance() {
    if (INSTANCE == null) {
      createInstance();
    }
    return INSTANCE;
  }

  private static synchronized void createInstance() {

    if (INSTANCE == null) {
      INSTANCE = new ModuloDAOImp();
    }
  }

  @Override
  public Modulo getById(int codigo) {

    String sql = "{call getModuloById(?)}";
    Modulo modulo = null;

    Connection connection = conexionDB.getConexion();
    try {
      CallableStatement cStatement = connection.prepareCall(sql);
      cStatement.setInt("codigo", codigo);
      ResultSet rs = cStatement.executeQuery();

      while (rs.next()) {
        modulo = parseModulo(rs);
      }
    } catch (SQLException e) {
      LOG.fatal(e.getMessage());
    } finally {
      conexionDB.desconectar();
    }
    return modulo;
  }

  private Modulo parseModulo(ResultSet rs) {

    Modulo modulo = null;
    modulo = new Modulo();
    try {
      modulo.setCodigo(rs.getInt("codModulo"));
      modulo.setNombre(rs.getString("nombre"));
      modulo.setDuracion(Util.parseDuracion(String.valueOf(rs.getInt("duracion"))));
      modulo.setReferencia(rs.getString("uFormativa"));
    } catch (SQLException e) {
      LOG.fatal(e.getMessage());
    }
    return modulo;
  }

  @Override
  public Modulo create(Modulo modulo) {

    String sql = "{call insertModulo(?,?,?,?)}";
    Modulo mod = null;

    Connection connection = conexionDB.getConexion();
    try {
      CallableStatement cStatement = connection.prepareCall(sql);
      cStatement.setString("nombre", modulo.getNombre());
      cStatement.setString("uFormativa", modulo.getReferencia());
      cStatement.setInt("duracion", modulo.getDuracion().getCodigo());
      cStatement.executeUpdate();
      mod = modulo;
      mod.setCodigo(cStatement.getInt("codModulo"));
    } catch (SQLException e) {
      LOG.fatal(e.getMessage());
      mod = getById(modulo.getCodigo());
    } finally {
      conexionDB.desconectar();
    }

    return mod;
  }

  @Override
  public void delete(int codigo) {

    String sql = "{call deleteModulo(?)}";

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
  public Modulo update(Modulo modulo) {

    String sql = "{call updateModulo(?,?,?,?)}";
    Modulo mod = null;

    Connection connection = conexionDB.getConexion();
    try {
      CallableStatement cStatement = connection.prepareCall(sql);
      cStatement.setInt("codigo", modulo.getCodigo());
      cStatement.setString("nombre", modulo.getNombre());
      cStatement.setString("uFormativa", modulo.getReferencia());
      cStatement.setInt("duracion", modulo.getDuracion().getCodigo());
      cStatement.executeUpdate();
      mod = modulo;
    } catch (SQLException e) {
      LOG.fatal(e.getMessage());
      mod = getById(modulo.getCodigo());
    } finally {
      conexionDB.desconectar();
    }
    return mod;
  }

  @Override
  public List<Modulo> getAll() {

    String sql = "{call getAllModulo()}";
    List<Modulo> modulos = null;
    Modulo mod = null;
    Connection connection = conexionDB.getConexion();

    try {
      modulos = new ArrayList<Modulo>();
      CallableStatement cStatement = connection.prepareCall(sql);
      ResultSet rs = cStatement.executeQuery();

      while (rs.next()) {
        mod = parseModulo(rs);
        modulos.add(mod);
      }
    } catch (SQLException e) {
      LOG.fatal(e.getMessage());
    } finally {
      conexionDB.desconectar();
    }

    return modulos;
  }
}
