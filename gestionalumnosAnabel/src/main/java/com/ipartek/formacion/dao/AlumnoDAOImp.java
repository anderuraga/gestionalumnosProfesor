package com.ipartek.formacion.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dao.interfaces.AlumnoDAO;
import com.ipartek.formacion.dao.mappers.AlumnoMapper;
import com.ipartek.formacion.dao.persistencia.Alumno;

//Anotacion para indicar que accede a BB.DD.
@Repository
public class AlumnoDAOImp implements AlumnoDAO {

  // objeto de conexion a BB.DD.
  private DataSource dataSource;
  /*
   * El JdbcTemplate, se va a encargar de coger cada uno de los datos de alumno y los va a unir para
   * formar el objeto java
   */
  private JdbcTemplate jdbcTemplate;

  @Override
  public List<Alumno> getAll() {

    List<Alumno> alumnos = null;
    final String sql = "SELECT codAlumno, nombre, apellidos FROM alumno";

    /*
     * La primera excepcion es para asegurarnos de que la BB.DD. devuelve algun alumno. La segunda
     * excepcion es la generica y controla que la sentencia sql este bien
     */
    try {
      alumnos = jdbcTemplate.query(sql, new AlumnoMapper());
    } catch (EmptyResultDataAccessException e) {
      alumnos = new ArrayList<Alumno>();
    } catch (Exception e) {

    }
    return alumnos;
  }

  /*
   * Esto viene de DAOSetter. Tenemos que inyectarle la conexion a la BB.DD
   */
  @Override
  public void setDataSource(DataSource dataSource) {

    this.dataSource = dataSource;
    this.jdbcTemplate = new JdbcTemplate(dataSource);

  }
}
