package com.ipartek.formacion.dao;

import com.ipartek.formacion.dao.interfaces.AlumnoDAO;
import com.ipartek.formacion.dao.mappers.AlumnoMapper;
import com.ipartek.formacion.dao.persistence.Alumno;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class AlumnoDAOImp implements AlumnoDAO {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;

	@Override
	public List<Alumno> getAll() {
		List<Alumno> alumnos = null;
		final String SQL = "SELECT codAlumno,nombre,apellidos FROM alumno";
		try {
			alumnos = jdbctemplate.query(SQL, new AlumnoMapper());
		} catch (EmptyResultDataAccessException e) {
			alumnos = new ArrayList<Alumno>();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return alumnos;
	}

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbctemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Alumno getById(int id) {
		Alumno alumnos = null;
		final String SQL = "SELECT codAlumno,nombre,apellidos FROM alumno WHERE codAlumno= ?";
		try {
			alumnos = jdbctemplate.queryForObject(SQL, new Object[] { id }, new AlumnoMapper());
		} catch (EmptyResultDataAccessException e) {
			alumnos = new Alumno();
		}
		return alumnos;
	}


	@Override
	public void delete(int id) {
		Alumno alumnos = null;
		final String SQL = "DELETE FROM alumno WHERE codAlumno= ?";
		jdbctemplate.update(SQL, new Object[] { id });
	}

	@Override
	public Alumno update(Alumno Alumno) {
		Alumno alumnos = null;
		final String SQL = "UPDATE alumno SET(nombre = ?,apellidos =?) WHERE codAlumno= ?";
		jdbctemplate.update(SQL, alumnos.getNombre(), alumnos.getApellidos(), alumnos.getCodigo());
		return alumnos;
	}
	@Override
	public Alumno create(Alumno Alumno) {
		Alumno alumnos = null;
		final String SQL = "INSERT alumno(codAlumno,nombre,apellidos) values(?,?,?)";
		jdbctemplate.update(SQL, alumnos.getNombre(), alumnos.getApellidos(), alumnos.getCodigo());
		return alumnos;
	}
}
