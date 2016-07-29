package com.ipartek.formacion.dbms.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.dbms.dao.exceptions.EmpleadoDAOImpException;
import com.ipartek.formacion.pojo.Empleado;

import junit.framework.Assert;

public class EmpleadoDAOImpTest {
	
	private static EmpleadoDAO empleDAO;
	private static Empleado empleado;
	List<Empleado> empleados;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empleDAO = EmpleadoDAOImp.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		empleDAO = null;
	}

	@Before
	public void setUp() throws Exception {
		empleado = new Empleado();
		empleados = new ArrayList<Empleado>();
		
	}
	
	private List<Empleado> cargarDatos(){
		List<Empleado> empleados = new ArrayList<Empleado>();
		
		
		
		return empleados;
	}

	@After
	public void tearDown() throws Exception {
		empleado = null;
	}

	@Test
	public void testGetById() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		empleDAO.update(empleado);
		Assert.assertEquals(empleDAO.update(empleado), empleado);
	}

	@Test(expected = EmpleadoDAOImpException.class, timeout = 500 )
	public void testInsert() throws EmpleadoDAOImpException {
		crearEmpleadoVacio();
		crearEmpleadoDatos();
		crearAlumnos();
	}

	private void crearAlumnos() {
		for(Empleado emple: empleados){
			try {
				Assert.assertNotSame("El codigo no tiene que ser el mismo.", empleDAO.insert(emple), emple);
			} catch (EmpleadoDAOImpException e) {
				fail("Fallo: " + e.getMessage());
			}
		}
	}

	private void crearEmpleadoDatos() {
		try {
			empleDAO.insert(empleado);
		} catch (EmpleadoDAOImpException e) {
			fail("Fallo: " + e.getMessage());
		}
	}

	private void crearEmpleadoVacio() {
		
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAll() {
		List<Empleado> emple = empleDAO.getAll();
		Assert.assertEquals(empleados, emple);
	}

}
