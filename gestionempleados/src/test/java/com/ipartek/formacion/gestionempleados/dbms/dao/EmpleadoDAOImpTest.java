package com.ipartek.formacion.gestionempleados.dbms.dao;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.dbms.dao.EmpleadoDAO;
import com.ipartek.formacion.dbms.dao.EmpleadoDAOImp;
import com.ipartek.formacion.dbms.dao.exceptions.EmpleadoDAOImpException;
import com.ipartek.formacion.pojo.Departamento;
import com.ipartek.formacion.pojo.Empleado;

public class EmpleadoDAOImpTest {
  private static EmpleadoDAO empDAO;
  private static Empleado empleado;
  private List<Empleado> empleados;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    empDAO = EmpleadoDAOImp.getInstance();
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
    empDAO = null;
  }

  @Before
  public void setUp() throws Exception {
    empleado = new Empleado();
    empleados = new ArrayList<Empleado>();
    empleados = cargarDatos();

  }

  private List<Empleado> cargarDatos() {
    List<Empleado> empleados = new ArrayList<Empleado>();

    return empleados;
  }

  @After
  public void tearDown() throws Exception {
    empleado = null;
  }

  @Test(expected = EmpleadoDAOImpException.class, timeout = 500)
  public void testCreate() throws EmpleadoDAOImpException {
    crearEmpleadoVacio();
    crearEmpleadoDatos();
    crearEmpleados();
  }

  private void crearEmpleados() {
    for (Empleado emp : empleados) {
      try {
        empDAO.create(emp);
      } catch (EmpleadoDAOImpException e) {
        fail();
      }
    }

  }

  private void crearEmpleadoDatos() {
    empleado.setCodigo(0);
    empleado.setfNacimiento(new Date());
    empleado.setfContratacion(new Date());
    empleado.setNombre("");
    empleado.setApellidos("");
    empleado.setnSeguridadSocial("");
    empleado.setnCuentaBancaria("");
    empleado.setDireccion("");
    empleado.setLocalidad("");
    empleado.setCodigoPostal("");
    empleado.setDni("");
    Departamento dep = new Departamento();
    empleado.setDepartamento(dep);
    try {
      empDAO.create(empleado);
    } catch (EmpleadoDAOImpException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  private void crearEmpleadoVacio() throws EmpleadoDAOImpException {
    try {
      empDAO.create(empleado);
    } catch (EmpleadoDAOImpException e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testGetAll() {
    List<Empleado> empleados = empDAO.getAll();
    Assert.assertEquals(this.empleados, empleados);
  }

  @Test
  public void testGetById() {
    fail("Not yet implemented");
  }

  @Test
  public void testUpdate() {
    fail("Not yet implemented");
  }

  @Test
  public void testDelete() {
    fail("Not yet implemented");
  }

}
