package com.ipartek.formacion.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dao.interfaces.AlumnoDAO;
import com.ipartek.formacion.dao.mappers.AlumnoMapper;
import com.ipartek.formacion.dao.persistencia.Alumno;

//Anotacion para indicar que accede a BB.DD.
@Repository("alumnoDAOImp")
public class AlumnoDAOImp implements AlumnoDAO {

  // objeto de conexion a BB.DD.
  @Autowired
  private DataSource dataSource;
  /*
   * El JdbcTemplate, se va a encargar de coger cada uno de los datos de alumno y los va a unir para
   * formar el objeto java
   */
  private JdbcTemplate jdbcTemplate;

  @Override
  public List<Alumno> getAll() {

    List<Alumno> alumnos = null;
    final String SQL = "SELECT codAlumno, nombre, apellidos FROM alumno";

    /*
     * La primera excepcion es para asegurarnos de que la BB.DD. devuelve algun alumno. La segunda
     * excepcion es la generica y controla que la sentencia sql este bien
     */
    try {
      alumnos = jdbcTemplate.query(SQL, new AlumnoMapper());
    } catch (EmptyResultDataAccessException e) {
      alumnos = new ArrayList<Alumno>();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return alumnos;
  }

  @Override
  public Alumno create(Alumno alumno) {

    return null;
  }

  @Override
  public void delete(int id) {
    // TODO Auto-generated method stub

  }

  @Override
  public Alumno update(Alumno alumno) {
    // TODO Auto-generated method stub
    return null;
  }

  /*
   * Para pasarle a la BB.DD. la id, tenemos que hacer un array de objetos, (segundo parametro del
   * queryforobject)
   */
  @Override
  public Alumno getById(int id) {

    Alumno alumno = null;
    final String SQL = "SELECT codAlumno, nombre, apellidos FROM alumno WHERE codAlumno=?";
    try {
      alumno = jdbcTemplate.queryForObject(SQL, new Object[] { id }, new AlumnoMapper());
    } catch (EmptyResultDataAccessException e) {
      alumno = new Alumno();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return alumno;
  }

  /*
   * Esto viene de DAOSetter. Tenemos que inyectarle la conexion a la BB.DD
   */
  @Autowired
  @Override
  public void setDataSource(DataSource dataSource) {

    this.dataSource = dataSource;
    this.jdbcTemplate = new JdbcTemplate(dataSource);

  }
}
