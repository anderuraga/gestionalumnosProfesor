package com.ipartek.formacion.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.controller.ModuloController;
import com.ipartek.formacion.dao.persistence.Alumno;

public class AlumnoMapper implements RowMapper<Alumno>{
	
	private static final Logger logger = LoggerFactory.getLogger(AlumnoMapper.class);

	@Override
	public Alumno mapRow(ResultSet rs, int arg1) throws SQLException {

		Alumno alumno = null;
		
		alumno = new Alumno();
		
		alumno.setCodigo(rs.getInt("codAlumno"));
		alumno.setNombre(rs.getString("nombre"));
		alumno.setApellidos(rs.getString("apellidos"));
		
		return alumno;
	}

}
