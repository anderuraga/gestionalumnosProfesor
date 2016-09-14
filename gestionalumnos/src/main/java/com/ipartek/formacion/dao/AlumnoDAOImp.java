package com.ipartek.formacion.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dao.interfaces.AlumnoDAO;
import com.ipartek.formacion.dao.mappers.AlumnoMapper;
import com.ipartek.formacion.dao.persistence.Alumno;

@Repository
public class AlumnoDAOImp implements AlumnoDAO {
	@Autowired
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall jdbcCall;


	@Override
	public List<Alumno> getAll() {
		List<Alumno> alumnos = null;

		final String SQL = "SELECT codAlumno, nombre, apellidos FROM alumno";
		try {
			alumnos = jdbcTemplate.query(SQL, new AlumnoMapper());
		} catch (EmptyResultDataAccessException e) {
			alumnos = new ArrayList<Alumno>();
		} catch (Exception e) {

		}
		return alumnos;
	}

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.jdbcCall = new SimpleJdbcCall(dataSource);

	}

	@Override
	public Alumno getByID(int id) {
		Alumno alumno = null;
		final String SQL = "SELECT nombre, apellidos FROM alumno WHERE codAlumno=?";
		//jdbcCall.withProcedureName("getByIDAlumno");
		try {
			alumno = jdbcTemplate.queryForObject(SQL, new Object[] { id }, new AlumnoMapper());
		} catch (EmptyResultDataAccessException e) {
			alumno = new Alumno();
		} catch (Exception e) {

		}
		return alumno;
	}

	@Override
	public Alumno update(Alumno alumno) {
		jdbcCall.withProcedureName("updateAlumno"); // usando las rutinas / procedures creadas en la BBDD
		
		SqlParameterSource in = new MapSqlParameterSource().addValue("nombre", alumno.getNombre()).addValue("apellidos", alumno.getApellidos())
				.addValue("fNacimiento",alumno.getfNacimiento()).addValue("DNI", "45628477L").addValue("email", "jo@s").addValue("telefono", "958744789").addValue("codGenero", 1);
		Map<String, Object> out =jdbcCall.execute(in);
		
		return alumno;
	}

	@Override
	public void delete(int id) {
		final String SQL = "DELETE FROM alumno WHERE codAlumno=?";

		jdbcTemplate.update(SQL, new Object[] { id });
	}

	@Override
	public Alumno create(Alumno alumno) {
		jdbcCall.withProcedureName("insertAlumno"); // usando las rutinas / procedures creadas en la BBDD
		SqlParameterSource in = new MapSqlParameterSource().addValue("nombre", alumno.getNombre()).addValue("apellidos", alumno.getApellidos())
				.addValue("fNacimiento",alumno.getfNacimiento()).addValue("DNI", "45628477L").addValue("email", "jo@s").addValue("telefono", "958744789").addValue("codGenero", 1);
		Map<String, Object> out =jdbcCall.execute(in);
		
		alumno.setCodigo((Integer) out.get("codalumno"));
				/*
				 * SqlparameterSource es la clase de tipo Map en la cual se guardan los parametros del procedimiento almacenado.
				 * execute lanza la sentencia. en el out obtendremos la respuestas
				 */
		return alumno;
	}

}
