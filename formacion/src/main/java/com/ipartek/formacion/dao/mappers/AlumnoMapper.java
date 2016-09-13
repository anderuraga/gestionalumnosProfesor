package com.ipartek.formacion.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dao.persistence.Alumno;

public class AlumnoMapper implements RowMapper<Alumno>  {

	@Override
	public Alumno mapRow(ResultSet rS, int arg1) throws SQLException {
		Alumno alumno=null;
		alumno=new Alumno();
		alumno.setCodigo(rS.getInt("codAlumno"));
		alumno.setNombre(rS.getString("nombre"));
		alumno.setApellidos(rS.getString("apellidos"));
		
		
		return alumno;
	}

}
