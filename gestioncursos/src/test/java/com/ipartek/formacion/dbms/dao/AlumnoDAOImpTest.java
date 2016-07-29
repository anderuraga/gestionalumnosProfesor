package com.ipartek.formacion.dbms.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.dbms.dao.exceptions.AlumnoDAOImpException;
import com.ipartek.formacion.pojo.Alumno;

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
List<Alumno> alumnos ? new ArrayList<Alumno>();  }

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

  @Test(expected = AlumnoDAOImpException.class)

  public void testCreate() {
 crearAlumnoVacio();
 crearAlumnoDatos();
 crearAlumno();
  }

  private void crearAlumnoDatos() {
    // TODO Auto-generated method stub
    
  }

  private void crearAlumnopDatos() {
try{
  alumnDAO.create(alumno);
  
} catch(AlumnoDAOImpException e )  { 
}
}
  

  private void crearAlumnoVacio() {
}

  @Test
  public void testDelete() {
    fail("Not yet implemented");
  }

  @Test
  public void testGetAll() {
alumnDAO.getAll();

  }

List<Alumno> alumnos = alumnDAO.getAll();
