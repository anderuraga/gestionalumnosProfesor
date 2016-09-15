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
import com.ipartek.formacion.dao.persistencia.Alumno;

@Repository("alumnoDAOImp")
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
			e.printStackTrace();
		}
		return alumnos;
	}

	@Override
	public Alumno create(Alumno alumno) {
		final String SQL = "INSERT INTO alumno (nombre,apellidos,dni,fNacimiento) VALUES (?,?,?,?)";
		this.jdbcTemplate.update(SQL,
				new Object[] { alumno.getNombre(), alumno.getApellidos(),
						alumno.getfNacimiento(), alumno.getDni() });

		return alumno;
	}

	@Override
	public void delete(int id) {
		final String SQL = "DELETE FROM alumno WHERE codAlumno = ?";
		this.jdbcTemplate.update(SQL, new Object[] { id });

	}

	@Override
	public Alumno update(Alumno alumno) {

		final String SQL = "UPDATE alumno SET nombre = ?, apellidos = ?,fNacimiento = ?, dni = ?  WHERE codAlumno = ?";
		this.jdbcTemplate.update(SQL, alumno.getNombre(),
				alumno.getApellidos(), alumno.getCodigo(),
				alumno.getfNacimiento(), alumno.getDni());
		return alumno;
	}

	@Override
	public Alumno getById(int id) {

		Alumno alumno = null;
		final String SQL = "SELECT codAlumno, nombre, apellidos, fNacimiento, dni FROM alumno WHERE codAlumno=?";
		try {
			alumno = jdbcTemplate.queryForObject(SQL, new Object[] { id },
					new AlumnoMapper());
		} catch (EmptyResultDataAccessException e) {
			alumno = new Alumno();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alumno;
	}

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {

		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.jdbcCall = new SimpleJdbcCall(dataSource);

	}
}
