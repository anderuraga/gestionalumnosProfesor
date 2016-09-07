package com.ipartek.formacion.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.controller.HomeController;
import com.ipartek.formacion.dao.interfaces.AlumnoDAO;
import com.ipartek.formacion.dao.mappers.AlumnoMapper;
import com.ipartek.formacion.dao.persistence.Alumno;

@Repository("alumnoDAOImp")
public class AlumnoDAOImp implements AlumnoDAO {
	private static final Logger logger = LoggerFactory
			.getLogger(AlumnoDAOImp.class);
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;

	@Override
	public List<Alumno> getAll() {
		List<Alumno> alumnos = null;
		final String SQL = "SELECT codAlumno, nombre, apellidos FROM alumno";
		try {
			alumnos = jdbctemplate.query(SQL, new AlumnoMapper());
		} catch (EmptyResultDataAccessException e) {
			alumnos = new ArrayList<Alumno>();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return alumnos;
	}

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbctemplate = new JdbcTemplate(dataSource);
		this.jdbcCall=new SimpleJdbcCall(dataSource);
	}

	@Override
	public Alumno getById(int id) {
		Alumno alumno = null;
		final String SQL = "SELECT codAlumno, nombre, apellidos FROM alumno WHERE codAlumno = ?";
		try {
			alumno = jdbctemplate.queryForObject(SQL, new Object[] { id },
					new AlumnoMapper());
		} catch (EmptyResultDataAccessException e) {
			alumno = new Alumno();
		}
		return alumno;
	}

	@Override
	public Alumno create(Alumno alumno) {
		final String SQL="INSERT INTO alumno nombre=?,apellidos=?";
		jdbcCall.withProcedureName("insertAlumno");
		
		
		SqlParameterSource in = new MapSqlParameterSource()
		.addValue("nombre", alumno.getNombre())
		.addValue("apellidos", alumno.getApellidos())
		.addValue("dni",alumno.getNombre())
		.addValue("fecha", new java.sql.Date(new java.util.Date().getTime()))
		.addValue("email", "")
		.addValue("telefono", "")
		.addValue("codGenero", alumno.getCodigo());
		
		Map<String,Object> out=jdbcCall.execute(in);
		
		alumno.setCodigo((Integer)out.get("codAlumno"));
		return alumno;
	}

	@Override
	public void delete(int id) {
		final String SQL = "DELETE FROM alumno WHERE codAlumno = ?";
		jdbctemplate.update(SQL, new Object[] { id });
		// jdbctemplate.update(SQL, id);
	}

	@Override
	public Alumno update(Alumno alumno) {
		
		final String SQL = "UPDATE `alumno` SET nombre=?,apellidos=? WHERE `codAlumno`=?";
		jdbctemplate.update(SQL, alumno.getNombre(), alumno.getApellidos(),
				alumno.getCodigo());
		return alumno;
	}
}
