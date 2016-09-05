package com.ipartek.formacion.dbms.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.dbms.dao.exceptions.EmpleadoDAOImpException;
import com.ipartek.formacion.pojo.Empleado;
import com.ipartek.formacion.service.EmpleadoService;

import junit.framework.Assert;

public class EmpleadoDAOImpTest {
	private static EmpleadoDAO empleDAO;
	private Empleado empleado;
	List<Empleado> empleados;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empleDAO=EmpleadoDAOImp.getInstance(); 
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		empleDAO=null; 
	}

	@Before
	public void setUp() throws Exception {
		empleado = new Empleado();
		
		empleados= cargarDatos();
	}

	private List<Empleado> cargarDatos(){
		List<Empleado> empleados = new ArrayList<Empleado>();
		
		return empleados;
	}
	
	/*
	private void crearEmpleados(){
		for(Empleado emp:empleados){
			try{
				empleDAO.create(emp);
			}catch{
				
			}
		}
	}*/
	@After
	public void tearDown() throws Exception {
		empleado = null;
	}

	@Test(expected = EmpleadoDAOImpException.class, timeout=500)
	public void testCreate() {
		empleDAO.create(empleado);
	}
	
	/*
	@Test
	public void crearEmpleadoDatos() {
		try{
		empleDAO.create(empleado);
		}catch(EmpleadoDAOImpException e){
			
		}
	}*/

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAll() {
		List<Empleado> empleados = empleDAO.getAll();
	}

}
