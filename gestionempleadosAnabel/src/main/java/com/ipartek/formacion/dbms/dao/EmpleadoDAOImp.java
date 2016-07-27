package com.ipartek.formacion.dbms.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.pojo.Empleado;

/**
 * Clase que define los metodos encargados de realizar las distintas operaciones con la BB.DD. Estas
 * operaciones son:
 * <ul>
 * <li>Crear un registro de empleado en la BB.DD.</li>
 * <li>Borrar un registro de empleado de la BB.DD.</li>
 * <li>Modificar un registro de empleado de la BB.DD.</li>
 * <li>Obtener los datos de un empleado</li>
 * <li>Obtener un listado de datos de los empleados que se encuentran en la BB.DD.</li>
 * </ul>
 * 
 * @author Anabel
 *
 */
public class EmpleadoDAOImp implements EmpleadoDAO {

  private static EmpleadoDAOImp INSTANCE = null;
  private static final Logger LOG = Logger.getLogger(EmpleadoDAOImp.class);
  private ConexionDB conexionDB;

  public EmpleadoDAOImp() {
    this.conexionDB = ConexionDBImp.getInstance();
  }

  public static EmpleadoDAOImp getInstance() {
    if (INSTANCE == null) {
      createInstance();
    }
    return INSTANCE;
  }

  private static synchronized void createInstance() {
    if (INSTANCE == null) {
      INSTANCE = new EmpleadoDAOImp();
    }

  }

  /**
   * Metodo encargado de crear un registro en la BB.DD. de empleado.
   * 
   * @param empleado
   *          <code>Empleado</code> objeto con los datos que se van a volcar a la BB.DD.
   * @return empleado <code>Empleado</code> objeto con los datos que se han volcado en la BB.DD.
   */
  @Override
  public Empleado create(Empleado empleado) {

    String sql = "{call createEmpleado(?,?,?,?,?,?,?,?,?,?,?,?)";
    try {
      CallableStatement cSmt = conexionDB.getConexion().prepareCall(sql);
      cSmt.setString("nombre", empleado.getNombre());
      cSmt.setString("apellidos", empleado.getApellidos());
      cSmt.setString("direccion", empleado.getDireccion());
      cSmt.setString("localidad", empleado.getLocalidad());
      cSmt.setString("dni", empleado.getDNI());
      cSmt.setInt("CC", empleado.getCuentaCorriente());
      cSmt.setInt("CP", empleado.getCodigoPostal());
      cSmt.setInt("SS", empleado.getSegSocial());
      cSmt.setDate("fNacimiento", new java.sql.Date(empleado.getfNacimiento().getTime()));
      cSmt.setDate("fContratacion", new java.sql.Date(empleado.getfContratacion().getTime()));
      cSmt.setInt("tipoDepartamento", empleado.getTipoDepartamento().getCodigo());
      cSmt.executeUpdate();
      empleado.setCodigo(cSmt.getInt("codigo"));
    } catch (SQLException e) {
      LOG.fatal(e.getMessage() + "Error en la conexion con la BB.DD.");
    } finally {
      conexionDB.desconectar();
    }
    return empleado;
  }

  /**
   * Metodo encargado de borrar un registro de empleado en la BB.DD.
   * 
   * @param codigo
   *          <code>int</code> codigo del empleado que quiere eliminarse de la BB.DD.
   */
  @Override
  public void delete(int codigo) {
    String sql = "{call deleteEmpleado(?)}";
    try {
      CallableStatement cSmt = conexionDB.getConexion().prepareCall(sql);
      cSmt.setInt("codigo", codigo);
      cSmt.executeUpdate();
      // FALTARIA COMPROBAR SI EL NUMERO DE FILAS A ELIMINAR ES UNO.
    } catch (SQLException e) {
      LOG.fatal(e.getMessage() + "Error en la conexion con la BB.DD.");
    } finally {
      conexionDB.desconectar();
    }

  }

  /**
   * Metodo encargado de modificar el registro de un empleado en la BB.DD.
   * 
   * @param empleado
   *          <code>Empleado</code> objeto de tipo empleado con los datos que se van a modificar en
   *          la BB.DD.
   * @return emplado <code>Empleado</code> objeto del tipo empleado con los datos que han sido
   *         modificados en la BB.DD.
   */
  @Override
  public Empleado update(Empleado empleado) {

    String sql = "{call updateEmpleado(?,?,?,?,?,?,?,?,?,?,?,?)";
    try {
      CallableStatement cSmt = conexionDB.getConexion().prepareCall(sql);
      cSmt.setInt("codigo", empleado.getCodigo());
      cSmt.setString("nombre", empleado.getNombre());
      cSmt.setString("apellidos", empleado.getApellidos());
      cSmt.setString("direccion", empleado.getDireccion());
      cSmt.setString("localidad", empleado.getLocalidad());
      cSmt.setString("dni", empleado.getDNI());
      cSmt.setInt("CC", empleado.getCuentaCorriente());
      cSmt.setInt("CP", empleado.getCodigoPostal());
      cSmt.setInt("SS", empleado.getSegSocial());
      cSmt.setInt("tipoDepartamento", empleado.getTipoDepartamento().getCodigo());
      cSmt.setDate("fNacimiento", new java.sql.Date(empleado.getfNacimiento().getTime()));
      cSmt.setDate("fContratacion", new java.sql.Date(empleado.getfContratacion().getTime()));
      cSmt.executeUpdate();

    } catch (SQLException e) {
      LOG.fatal(e.getMessage() + "Error en la conexion con la BB.DD.");
    } finally {
      conexionDB.desconectar();
    }
    return empleado;
  }

  /**
   * Metodo encargado de obtener un empleado de la BB.DD.
   * 
   * @param codigo
   *          <code>int</code> codigo del empleado que se quiere obtener de la BB.DD.
   * @return empleado <code>Empleado</code> objeto del tipo empleado que se descarga de la BB.DD.
   */
  @Override
  public Empleado getById(int codigo) {
    Calendar cal;
    String sql = "{call getByIdEmpleado(?)}";
    Empleado empleado = null;
    try {
      CallableStatement cSmt = conexionDB.getConexion().prepareCall(sql);
      cSmt.setInt("codigo", codigo);
      ResultSet rs = cSmt.executeQuery();

      while (rs.next()) {
        empleado = parseEmpleado(rs);
      }
    } catch (SQLException e) {
      LOG.fatal(e.getMessage() + "Error en la conexion con la BB.DD.");
    } finally {
      conexionDB.desconectar();
    }

    return empleado;
  }

  /**
   * Metodo que se encarga de meter todos los datos que se obtiene de la BB.DD. a un objeto
   * empleado.
   * 
   * @param rs
   *          <code>ResultSet</code> objeto de ResultSet que nos proporciona los datos descargados
   *          de la BB.DD.
   * @return empleado <code>Empleado</code> objeto del tipo empleado con los datos que nos ha
   *         proporcionado la BB.DD.
   */
  private Empleado parseEmpleado(ResultSet rs) {
    Empleado empleado = null;
    empleado = new Empleado();
    try {
      empleado.setNombre(rs.getString("nombre"));
      empleado.setApellidos(rs.getString("apellidos"));
      empleado.setDireccion(rs.getString("direccion"));
      empleado.setDNI(rs.getString("dni"));
      empleado.setLocalidad(rs.getString("localidad"));
      empleado.setCodigoPostal(rs.getInt("CP"));
      empleado.setSegSocial(rs.getInt("SS"));
      empleado.setCuentaCorriente(rs.getInt("CC"));
      empleado.setCodigo(rs.getInt("codigo"));
      empleado.setfNacimiento(rs.getDate("fNacimiento"));
      empleado.setfContratacion(rs.getDate("fContratacion"));
      // FALTA EL TIPO DE DEPARTAMENTO

    } catch (SQLException e) {
      LOG.error(e.getMessage() + "No se ha podido descargar la informacion de la BB.DD.");
    }

    return empleado;

  }

  /**
   * Metodo que devuelve una lista con todos los empleados que se encuentran en la BB.DD.
   * 
   * @return empleados <code>List<Empleado></code> listado con todos los datos de los distintos
   *         empleados que ha devuelto la BB.DD.
   */
  @Override
  public List<Empleado> getAll() {

    List<Empleado> empleados = null;
    Empleado empleado;
    String sql = "{call getAllEmpleados()}";
    try {
      empleados = new ArrayList<Empleado>();
      CallableStatement cSmt = conexionDB.getConexion().prepareCall(sql);
      ResultSet rs = cSmt.executeQuery();

      while (rs.next()) {
        empleado = parseEmpleado(rs);
        empleados.add(empleado);
      }
    } catch (SQLException e) {
      LOG.fatal(e.getMessage() + "Error en la conexion con la BB.DD.");
    }
    return empleados;
  }

}
