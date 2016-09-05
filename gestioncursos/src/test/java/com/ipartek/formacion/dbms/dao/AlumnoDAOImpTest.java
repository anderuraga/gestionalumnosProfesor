/**
 *
 */
package com.ipartek.formacion.dbms.dao;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.dbms.dao.exceptions.AlumnoDAOImpException;
import com.ipartek.formacion.pojo.Alumno;

/**
 * @author va00
 *
 */
public class AlumnoDAOImpTest {

  private static AlumnoDAO alumnDAO;
  private static Alumno alumno;
  List<Alumno> alumnos;

  /**
   * @throws java.lang.Exception
   */
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {

    alumnDAO = AlumnoDAOImp.getInstance();
  }

  /**
   * @throws java.lang.Exception
   */
  @AfterClass
  public static void tearDownAfterClass() throws Exception {
    alumnDAO = null;
  }

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    alumno = new Alumno();

    alumnos = cargarDatos();
  }

  private List<Alumno> cargarDatos() {
    List<Alumno> alumnos = new ArrayList<Alumno>();

    return alumnos;

  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {
    alumno = null;
  }

  /**
   * Test method for {@link com.ipartek.formacion.dbms.dao.AlumnoDAOImp#getById(int)}.
   */
  @Test
  public void testGetById() {
    fail("Not yet implemented");
  }

  /**
   * Test method for
   * {@link com.ipartek.formacion.dbms.dao.AlumnoDAOImp#update(com.ipartek.formacion.pojo.Alumno)}.
   */
  @Test
  public void testUpdate() {
    alumnDAO.update(alumno);
    Assert.assertEquals(alumnDAO.getById(alumno.getCodigo()), alumno);

  }

  /**
   * Test method for
   * {@link com.ipartek.formacion.dbms.dao.AlumnoDAOImp#create(com.ipartek.formacion.pojo.Alumno)}.
   *
   * @throws AlumnoDAOImpException
   */
  @Test(expected = AlumnoDAOImpException.class, timeout = 500)
  public void testCreate() throws AlumnoDAOImpException {
    crearAlumnoVacio();
    crearAlumnoDatos();
    crearAlumnos();
  }

  private void crearAlumnos() {
    for (Alumno alum : alumnos) {
      try {
        Assert.assertNotSame("el codigo no tiene que ser mismo", alumnDAO.create(alum), alum);

      } catch (AlumnoDAOImpException e) {
        fail(e.getMessage());
      }
    }

  }

  private void crearAlumnoDatos() {
    try {
      alumnDAO.create(alumno);
    } catch (AlumnoDAOImpException e) {
      fail("" + e.getMessage());
    }

  }

  private void crearAlumnoVacio() throws AlumnoDAOImpException {
    alumnDAO.create(alumno);
  }

  /**
   * Test method for {@link com.ipartek.formacion.dbms.dao.AlumnoDAOImp#delete(int)}.
   */
  @Test
  public void testDelete() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link com.ipartek.formacion.dbms.dao.AlumnoDAOImp#getAll()}.
   */
  @Test
  public void testGetAll() {
    List<Alumno> alums = alumnDAO.getAll();
    Assert.assertEquals(alumnos, alums);
  }
}
