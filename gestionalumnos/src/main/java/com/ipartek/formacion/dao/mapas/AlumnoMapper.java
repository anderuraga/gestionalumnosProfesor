package com.ipartek.formacion.dao.mapas;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.ipartek.formacion.dao.persistencia.Alumno;

public class AlumnoMapper implements RowMapper<Alumno> {

	
	public Alumno mapRow(ResultSet rs, int codigo) throws SQLException {
		
		Alumno alumno = new Alumno();
		alumno.setCodigo(rs.getInt("codigo"));
		alumno.setNombre(rs.getString("nombre"));
		alumno.setApellidos(rs.getString("apellidos"));
		return alumno;
	}


}
