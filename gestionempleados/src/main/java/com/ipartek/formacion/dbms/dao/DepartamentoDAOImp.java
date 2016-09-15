package com.ipartek.formacion.dbms.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.pojo.Departamento;
import com.ipartek.formacion.pojo.Empleado;

/**
 * 
 * @author Imanol Jimenez
 *
 */
public class DepartamentoDAOImp implements DepartamentoDAO {
  private static final Logger LOG = Logger.getLogger(DepartamentoDAOImp.class);
  private static DepartamentoDAOImp INSTANCE = null;
  private static ConexionDB myConexion;

  /**
   * 
   */
  private DepartamentoDAOImp() {
    myConexion = ConexionDBImp.getInstance();
  }

  /**
   * 
   * @return INSTANCE
   */
  public static DepartamentoDAOImp getInstance() {
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
      INSTANCE = new DepartamentoDAOImp();
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

  @Override
  public Departamento create(Departamento departamento) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Departamento> getAll() {
    String sql = "{call getAllDep()}";
    List<Departamento> departamentos = new ArrayList<Departamento>();
    Departamento dep = null;
    try {
      CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
      ResultSet rs = cSmt.executeQuery();
      while (rs.next()) {
        dep = new Departamento();
        dep = parseDepartamento(rs);
        departamentos.add(dep);
      }
    } catch (SQLException e) {
      LOG.fatal(e.getMessage() + " -- Error al obtener el listado de departamentos");
    }
    return departamentos;
  }

  private Departamento parseDepartamento(ResultSet rs) {
    Departamento dep = new Departamento();
    try {
      dep.setCodigo(rs.getInt("codigo"));
      dep.setNombre(rs.getString("nombre"));
      dep.setDescripcion(rs.getString("descripcion"));
    } catch (SQLException e) {
      LOG.fatal(e.getMessage() + " --  Error al parsear departamento");
    }
    return dep;
  }

  @Override
  public Departamento getById(int codDepartamento) {
    String sql = "{call getByIdDep()}";
    List<Empleado> empleados = null;
    Empleado empleado = null;
    Departamento dep = null;
    try {
      CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
      ResultSet rs = cSmt.executeQuery();
      dep = new Departamento();
      dep = parseDepartamento(rs);
      empleados = new ArrayList<Empleado>();
      do {
        empleado = new Empleado();
        empleado = parseEmpleado(rs);
        empleados.add(empleado);
      } while (rs.next());
      dep.setEmpleados(empleados);
    } catch (SQLException e) {
      LOG.fatal(e.getMessage());

    }

    return dep;
  }

  private Empleado parseEmpleado(ResultSet rs) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Departamento update(Departamento departamento) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void delete(int codDepartamento) {
    // TODO Auto-generated method stub

  }

}
