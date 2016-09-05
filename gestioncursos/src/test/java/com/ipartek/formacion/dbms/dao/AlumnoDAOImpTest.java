package com.ipartek.formacion.dbms.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.pojo.Alumno;

public class AlumnoDAOImpTest {

  private static  AlumnoDAO alumnDAO;
  private static Alumno alumno;
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    alumnDAO=AlumnoDAOImp.getInstance();
    
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
    alumno=new Alumno();
    //dar valores
    
  }

  @After
  public void tearDown() throws Exception {
    alumno=null;
    
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
  public void testCreate() {
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
