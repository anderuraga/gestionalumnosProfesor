package com.ipartek.formacion.dao;

import com.ipartek.formacion.dao.interfaces.AlumnoDAO;
import com.ipartek.formacion.dao.mappers.AlumnoMapper;
import com.ipartek.formacion.dao.persistence.Alumno;

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

@Repository
public class AlumnoDAOImp implements AlumnoDAO {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(dataSource);
		this.jdbcCall = new SimpleJdbcCall(dataSource);
	}

	@Override
	public List<Alumno> getAll() {
		List<Alumno> alumnos = null;
		final String SQL = "SELECT codigoAlumno,nombreAlumno,apellidosAlumno,fechaAlumno FROM alumno";
		try {
			alumnos = jdbctemplate.query(SQL, new AlumnoMapper());
		} catch (EmptyResultDataAccessException e) {
			alumnos = new ArrayList<Alumno>();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return alumnos;
	}

	@Override
	public Alumno getById(int id) {
		Alumno alumnos = null;
		final String SQL = "SELECT codigoAlumno,nombreAlumno,apellidosAlumno,fechaAlumno FROM alumno WHERE codigoAlumno =?";
		try {
			alumnos = jdbctemplate.queryForObject(SQL, new Object[] { id },
					new AlumnoMapper());
		} catch (EmptyResultDataAccessException e) {
			alumnos = new Alumno();
		}
		return alumnos;
	}

	@Override
	public Alumno update(Alumno alumno) {
		Alumno alumnos = null;
		final String SQL = "UPDATE alumno SET(nombreAlumno = ?,apellidosAlumno =?,fechaAlumno =?) WHERE codigoAlumno= ?";
		jdbctemplate.update(SQL, alumnos.getNombre(), alumnos.getApellidos(),
				alumnos.getCodigo());
		return alumnos;
	}

	@Override
	public Alumno create(Alumno alumno) {

		this.jdbcCall = new SimpleJdbcCall(dataSource)
				.withProcedureName("createAlumno");
		SqlParameterSource in = new MapSqlParameterSource().addValue("nombre",
				alumno.getNombre())
				.addValue("apellidos", alumno.getApellidos());
		Map<String, Object> out = jdbcCall.execute(in);
		/*
		 * recogemos el parametro OUT del procedimiento
		 */
		alumno.setCodigo((Integer) out.get("codigoAlumno"));
		return alumno;

	}

	@Override
	public void delete(int id) {
		final String SQL = "DELETE FROM alumno WHERE codigoAlumno= ?";
		jdbctemplate.update(SQL, new Object[] { id });
	}

}