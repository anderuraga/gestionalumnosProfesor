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
import com.ipartek.formacion.dbms.dao.exceptions.EmpleadoDAOImpException;
import com.ipartek.formacion.pojo.Departamento;
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
   * @throws EmpleadoDAOImpException
   */
  public Empleado create(Empleado empleado) throws EmpleadoDAOImpException {
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
      throw new EmpleadoDAOImpException(EmpleadoDAOImpException.CODIGO_ERROR_INSERT,
          EmpleadoDAOImpException.MSG_ERROR_EMPLEADO_INSERT);
    }
    return emp;
  }

  /**
   * Obtiene la lista completa de empleados.
   * 
   * @return lista de empleados
   */
  public List<Empleado> getAll() {
    String sql = "{call getAllEmp()}";
    List<Empleado> listaEmpleados = null;
    Empleado emp = null;
    try {
      CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
      ResultSet rs = cSmt.executeQuery();
      listaEmpleados = new ArrayList<Empleado>();
      while (rs.next()) {
        emp = new Empleado();
        emp = parseEmpleado(rs);
        listaEmpleados.add(emp);
      }
    } catch (SQLException e) {
      LOG.fatal(e.getMessage() + " -- Error al cargar lista de empleados");
    }
    return listaEmpleados;
  }

  private Empleado parseEmpleado(ResultSet rs) {
    Empleado emp = new Empleado();
    try {
      emp.setCodigo(rs.getInt("codigo"));
      emp.setfNacimiento(new Date(rs.getDate("fNacimiento").getTime()));
      emp.setfContratacion(new Date(rs.getDate("fContratacion").getTime()));
      emp.setNombre(rs.getString("nombre"));
      emp.setApellidos(rs.getString("apellidos"));
      emp.setnSeguridadSocial(rs.getString("nSeguridadSocial"));
      emp.setnCuentaBancaria(rs.getString("nCuentaBancaria"));
      emp.setDireccion(rs.getString("direccion"));
      emp.setLocalidad(rs.getString("localidad"));
      emp.setCodigoPostal(rs.getString("codigoPostal"));
      emp.setDni(rs.getString("dni"));
      Departamento dep = new Departamento();
      dep.setCodigo(rs.getInt("codDepartamento"));
      emp.setDepartamento(dep);
    } catch (Exception e) {
      LOG.fatal(e.getMessage() + " -- Error parseEmpleado");
    }
    return emp;
  }

  /**
   * Obtiene el empleado que tenga el codEmpleado solicitado.
   * 
   * @param codEmpleado
   *          <code>int</code>
   * @return <code>Empleado</code>
   */
  public Empleado getById(int codEmpleado) {
    String sql = "{call getByIdEmp(?)}";
    Empleado emp = null;
    try {
      CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
      emp = new Empleado();
      cSmt.setInt("codEmp", codEmpleado);
      ResultSet rs = cSmt.executeQuery();
      while (rs.next()) {
        emp = parseEmpleado(rs);
      }
    } catch (SQLException e) {
      LOG.fatal(e.getMessage() + " -- Error getByIdEmp");
    }
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
