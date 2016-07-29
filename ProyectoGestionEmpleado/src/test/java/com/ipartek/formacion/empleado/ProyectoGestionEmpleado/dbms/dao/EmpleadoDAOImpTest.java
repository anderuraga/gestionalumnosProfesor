package com.ipartek.formacion.empleado.ProyectoGestionEmpleado.dbms.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.empleado.ProyectoGestionEmpleado.pojo.Empleado;

public class EmpleadoDAOImpTest {
	
	private static EmpleadoDAO empleadoDao;
	private static Empleado empleado;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empleadoDao = EmpleadoDAOImp.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		empleadoDao = null;
	}

	@Before
	public void setUp() throws Exception {
		empleado = new Empleado();
		//dar valores
		
	}

	@After
	public void tearDown() throws Exception {
		empleado=null;
	}

	@Test
	public void testCreateEmpleadoDAO() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetByIdDAO() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteDAO() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllDAO() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateDAO() {
		fail("Not yet implemented");
	}

}
