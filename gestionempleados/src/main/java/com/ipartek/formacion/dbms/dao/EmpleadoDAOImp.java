package com.ipartek.formacion.dbms.dao;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.pojo.Empleado;

public class EmpleadoDAOImp implements EmpleadoDAO {
  private static final Logger LOG = Logger.getLogger(EmpleadoDAOImp.class);
  private static EmpleadoDAOImp INSTANCE = null;
  private static ConexionDB myConexion;

  /**
   * 
   */
  private EmpleadoDAOImp() {
    myConexion = ConexionDBImp.getInstance();
  }

  /**
   * 
   * @return INSTANCE
   */
  public static EmpleadoDAOImp getInstance() {
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
      INSTANCE = new EmpleadoDAOImp();
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
   * @param emp
   *          <code>Empleadp</code>
   */
  public Empleado create(Empleado empleado) {
    Empleado emp = null;
    String sql = "{call insertEmpleado(?,?,?,?,?,?,?,?,?,?,?,?)}";
    try {
      CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
      cSmt.setDate("fNac", new java.sql.Date(empleado.getfNacimiento().getTime()));
      cSmt.setDate("fCont", new java.sql.Date(empleado.getfContratacion().getTime()));
      cSmt.setString("nombre", empleado.getNombre());
      cSmt.setString("apellidos", empleado.getApellidos());
      cSmt.setString("nSS", empleado.getnSeguridadSocial());
      cSmt.setString("nCC", empleado.getnCuentaBancaria());
      cSmt.setString("direccion", empleado.getDireccion());
      cSmt.setString("localidad", empleado.getLocalidad());
      cSmt.setString("cp", empleado.getCodigoPostal());
      cSmt.setString("dni", empleado.getDni());
      cSmt.setInt("codDep", empleado.getDepartamento().getCodigo());
      cSmt.executeUpdate();
      emp = empleado;
      emp.setCodigo(cSmt.getInt("codEmp"));
    } catch (SQLException e) {
      LOG.fatal(e.getMessage() + "Error al crear empleado");
    }
    return emp;
  }

  /**
   * Obtiene la lista completa de empleados.
   * 
   * @return lista de empleados
   */
  public List<Empleado> getAll() {
    List<Empleado> listaEmpleados = null;
    return listaEmpleados;
  }

  /**
   * Obtiene el empleado que tenga el codEmpleado solicitado.
   * 
   * @param codEmpleado
   *          <code>int</code>
   * @return <code>Empleado</code>
   */
  public Empleado getById(int codEmpleado) {
    Empleado emp = null;
    return emp;
  }

  /**
   * Actualiza los datos de empleado.
   * 
   * @param emp
   *          <code>Empleado</code>
   * @return <code>Empleado</code>
   */
  public Empleado update(Empleado empleado) {
    Empleado emp = null;
    return emp;
  }

  /**
   * Elimina el empleado con codigo = <code>codEmpleado</code>.
   * 
   * @param codEmpleado
   *          <code>int</code>
   */
  public void delete(int codEmpleado) {

  }

}
