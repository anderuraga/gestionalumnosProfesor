package com.ipartek.formacion.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import com.ipartek.formacion.dao.AlumnoDAOImp;
import com.ipartek.formacion.dao.persistence.Alumno;

public class AlumnoMapper implements RowMapper<Alumno> {

	@Override public Alumno mapRow(ResultSet rs, int arg1) throws SQLException {
		Alumno alumno = null;
		alumno = new Alumno();
	/*GETTERS Y SETTERS*/
		alumno.setCodigo(rs.getInt("codigo"));
		alumno.setNombre(rs.getString("nombre"));
		alumno.setApellidos(rs.getString("apellidos"));

		return alumno;
	}}
