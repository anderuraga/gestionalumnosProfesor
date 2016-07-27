package com.ipartek.formacion.dbms.dao;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.pojo.Departamento;

/**
 * Clase que implementa los metodos encargados de gestionar las consultas con la BB.DD. Estas pueden
 * ser:
 * <ul>
 * <li>Crear un registro de departamento en la BB.DD.</li>
 * <li>Eliminar un registro de departamento de la BB.DD</li>
 * <li>Modificar un registro de departamento de la BB.DD.</li>
 * <li>Obtener un registro de departamento de la BB.DD.</li>
 * <li>Obtener un listado de todos los registros de departamentos que se encuentren en la BB.DD.</li>
 * </ul>
 * 
 * @author Curso
 *
 */
public class DepartamentoDAOImp implements DepartamentoDAO {

  private ConexionDB conexionDB;
  private static final Logger LOG = Logger.getLogger(DepartamentoDAOImp.class);
  private static DepartamentoDAOImp INSTANCE = null;

  /**
   * Constructor de la clase DepartamentoDaoImp
   */
  public DepartamentoDAOImp() {
    this.conexionDB = ConexionDBImp.getInstance();
  }

  /**
   * Metodo que se encarga de retornar la instancia para poder ser utilizada.
   * 
   * @return INSTANCE <code>DepartamentoDAOImp</code>
   */
  public static DepartamentoDAOImp getInstance() {

    if (INSTANCE == null) {
      createInstance();
    }
    return INSTANCE;
  }

  /**
   * Metodo que se encarga de crear la instancia para poder utilizar la clase.
   */
  private static void createInstance() {
    if (INSTANCE == null) {
      INSTANCE = new DepartamentoDAOImp();
    }

  }

  /**
   * Metodo encargado de crear un registro de departamento en la BB.DD.
   * 
   * @param departamento
   *          <code>Departamento</code> objeto de tipo departamento con todos los datos que se
   *          quieren introducir en la BB.DD.
   * @return departamento <code>Departamento</code> objeto de tipo departamento con todos los datos
   *         que se han introducido en la BB.DD.
   */
  @Override
  public Departamento create(Departamento departamento) {
    String sql = "{call createDepartamento(?,?,?)}";
    try {
      CallableStatement cSmt = this.conexionDB.getConexion().prepareCall(sql);
      cSmt.setString("nombreDep", departamento.getNombre());
      cSmt.setString("descripcion", departamento.getDescripcion());
      cSmt.executeUpdate();
      departamento.setCodigo(cSmt.getInt("codigo"));
    } catch (SQLException e) {
      LOG.fatal(e.getMessage() + "Error en la conexion con la BB.DD.");
    } finally {
      this.conexionDB.desconectar();
    }

    return departamento;
  }

  /**
   * Metodo encargado de borrar un registro de tipo departamento de la BB.DD.
   * 
   * @param codigo
   *          <code>int</code> codigo del departamento que se quiere eliminar de la BB.DD.
   */
  @Override
  public void delete(int codigo) {
    String sql = "{call deleteDepartamento(?)}";
    try {
      CallableStatement cSmt = this.conexionDB.getConexion().prepareCall(sql);
      cSmt.setInt("codigo", codigo);
      cSmt.executeUpdate();
    } catch (SQLException e) {
      LOG.fatal(e.getMessage() + "Error en la conexion con la BB.DD.");
    } finally {
      this.conexionDB.desconectar();
    }

  }

  @Override
  public Departamento update(Departamento departamento) {
    String sql = "{call updateDepartamento(?,?,?)}";
    try {
      CallableStatement cSmt = this.conexionDB.getConexion().prepareCall(sql);
    } catch (SQLException e) {
      LOG.fatal(e.getMessage() + "Error en la conexion con la BB.DD");
    } finally {
      this.conexionDB.desconectar();
    }

    return null;
  }

  @Override
  public Departamento getById(int codigo) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Departamento> getAll() {
    // TODO Auto-generated method stub
    return null;
  }

}
