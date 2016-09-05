package com.ipartek.formacion.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dao.persistencia.Alumno;

public class AlumnoMapper implements RowMapper<Alumno>{

	@Override
	public Alumno mapRow(ResultSet rs, int arg1) throws SQLException {
		
		Alumno alumno=null;
		
		alumno=new Alumno();
		alumno.setCodigo(rs.getInt("codAlumno"));
		alumno.setNombre(rs.getString("nombre"));
		alumno.setApellidos(rs.getString("apellidos"));
		
		return alumno;
	}

}
