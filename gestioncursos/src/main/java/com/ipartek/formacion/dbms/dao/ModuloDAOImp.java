package com.ipartek.formacion.dbms.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.pojo.Modulo;
import com.ipartek.formacion.service.Util;

/**
 *
 * @author Curso
 *
 */
public class ModuloDAOImp implements ModuloDAO {
  private final static Logger LOG = Logger.getLogger(ModuloDAOImp.class);
  private static ModuloDAOImp INSTANCE = null;
  private static ConexionDB myConexion;

  /**
   *
   */
  private ModuloDAOImp() {
    myConexion = ConexionDBImp.getInstance();
  }

  /**
   *
   * @return INSTANCE
   */
  public static ModuloDAOImp getInstance() {
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
      INSTANCE = new ModuloDAOImp();
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
    LOG.error("Error al clonar");
    throw new CloneNotSupportedException();
  }

  /**
   * @Override
   * @param codigo
   *          int
   * @return modulo
   */
  @Override
  public Modulo getById(int codigo) {
    Modulo modulo = null;
    String sql = "{call getModuloById(?)}";
    try {
      CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
      cSmt.setInt("codigo", codigo);

      ResultSet rs = cSmt.executeQuery();
      while (rs.next()) {
        modulo = parseModulo(rs);
      }
    } catch (SQLException e) {
      LOG.error(e.getMessage());
    } finally {
      myConexion.desconectar();
    }

    return modulo;
  }

  /**
   *
   * @param rs
   *          ResultSet
   * @return modulo
   */
  private Modulo parseModulo(ResultSet rs) {
    Modulo modulo = null;
    modulo = new Modulo();
    try {
      modulo.setCodigo(rs.getInt("codModulo"));
      modulo.setNombre(rs.getString("nombre"));
      modulo.setuFormativa(rs.getString("uFormativa"));
      int codDuracion = rs.getInt("duracion");
      modulo.setDuracion(Util.parseDuracion(codDuracion));
    } catch (SQLException e) {
      LOG.error(e.getMessage());
    }
    return modulo;
  }

  /**
   * @Override
   * @param modulo
   *          Modulo
   * @return modulo
   */
  @Override
  public Modulo update(Modulo modulo) {
    Modulo mod = null;
    String sql = "{call updateModulo(?,?,?,?)}";

    try {
      CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
      cSmt.setInt("codigo", modulo.getCodigo());
      cSmt.setString("nombre", modulo.getNombre());
      cSmt.setString("uFormativa", modulo.getuFormativa());
      cSmt.setInt("duracion", modulo.getDuracion().getCodigo());
      cSmt.executeUpdate();
      mod = modulo;
      LOG.trace("modulo actualizado" + modulo.toString());
    } catch (SQLException e) {
      mod = getById(modulo.getCodigo());
      LOG.fatal(e.getMessage() + modulo.toString() + " -- Error al actualizar");
    } catch (NullPointerException e) {
      LOG.fatal(e.getMessage() + " -- Error null");
    } finally {
      myConexion.desconectar();
    }
    return mod;
  }

  /**
   * @Override
   * @param modulo
   *          Modulo
   * @return modulo
   */
  @Override
  public Modulo create(Modulo modulo) {
    Modulo mod = null;
    String sql = "{call insertModulo(?,?,?,?)}";

    try {
      CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
      cSmt.setString("nombre", modulo.getNombre());
      cSmt.setString("uFormativa", modulo.getuFormativa());
      cSmt.setInt("duracion", modulo.getDuracion().getDuracion());
      cSmt.executeUpdate();
      mod = modulo;
      mod.setCodigo(cSmt.getInt("codModulo"));
    } catch (SQLException e) {
      LOG.fatal(e.getMessage() + " -- Error al insertar modulo");
    } finally {
      myConexion.desconectar();
    }
    return mod;
  }

  /**
   * @Override
   * @param codigo
   *          int
   */
  @Override
  public void delete(int codigo) {
    String sql = "{call deleteModulo(?)}";
    try {
      CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
      cSmt.setInt("codigo", codigo);
      cSmt.executeUpdate();
    } catch (SQLException e) {
      LOG.fatal(e.getMessage() + " -- Error al borrar");
    } finally {
      myConexion.desconectar();
    }

  }

  /**
   * @Override
   * @return lista de modulos
   */
  @Override
  public List<Modulo> getAll() {
    List<Modulo> modulos = null;
    String sql = "{call getAllModulo()}";
    try {
      Modulo modulo = null;
      CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
      ResultSet rs = cSmt.executeQuery();
      modulos = new ArrayList<Modulo>();
      while (rs.next()) {
        modulo = parseModulo(rs);
        modulos.add(modulo);
      }

    } catch (SQLException e) {
      LOG.error(e.getMessage());
    } finally {
      myConexion.desconectar();
    }
    return modulos;

  }

}
