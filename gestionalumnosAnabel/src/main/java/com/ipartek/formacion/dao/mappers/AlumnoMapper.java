package com.ipartek.formacion.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dao.persistencia.Alumno;

/**
 * Clase que implementa el metodo que mapea los datos de alumno que son proporcionados por la BB.DD
 * a objeto java alumno.
 * 
 * @author Curso
 *
 */
public class AlumnoMapper implements RowMapper<Alumno> {

  /**
   * Metodo que mapea los datos de alumno que nos proporciona la BB.DD a objeto java alumno. Nos
   * proporciona directamente el objeto resultSet, sin necesidad de declarar el CallabletStatement
   */
  @Override
  public Alumno mapRow(ResultSet rs, int arg1) throws SQLException {

    Alumno alumno = null;
    alumno = new Alumno();
    alumno.setCodigo(rs.getInt("codAlumno"));
    alumno.setNombre(rs.getString("nombre"));
    alumno.setApellidos(rs.getString("apellidos"));
    alumno.setfNacimiento(rs.getDate("fNacimiento"));
    alumno.setTelefono(rs.getInt("telefono"));
    alumno.setEmail(rs.getString("email"));
    return alumno;
  }

}
