package com.ipartek.formacion.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.ipartek.formacion.dao.persistence.Alumno;

public class AlumnoMapper implements RowMapper<Alumno> {

	@Override
	public Alumno mapRow(ResultSet rs, int arg1) throws SQLException {
		Alumno alumno = null;
		alumno = new Alumno();
		/* GETTERS Y SETTERS */
		alumno.setCodigo(rs.getInt("codigoAlumno"));
		alumno.setNombre(rs.getString("nombreAlumno"));
		alumno.setApellidos(rs.getString("apellidosAlumno"));
		alumno.setFechaNacimiento(rs.getDate("fechaAlumno"));

		return alumno;
	}
}
