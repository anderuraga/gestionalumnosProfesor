package com.ipartek.formacion.dbms.dao;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.pojo.excepciones.CandidatoException;

public class AlumnoDAOImpTest {

	private static AlumnoDAO alumnDAO;
	private static Alumno alumno;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		alumnDAO = AlumnoDAOImp.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		alumnDAO = null;
	}

	@Before
	public void setUp() throws Exception {
		alumno = new Alumno();
		alumno = null; // realmente se inicializa todo
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = CandidatoException.class, timeout=500)// timeout maximo 500 milisegundos en crearse o se dará por malo
	public void testGetByID() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAll() {
		fail("Not yet implemented");
	}

}
