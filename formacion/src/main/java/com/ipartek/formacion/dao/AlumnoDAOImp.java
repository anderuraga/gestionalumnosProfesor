package com.ipartek.formacion.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.controller.AlumnosController;
import com.ipartek.formacion.dao.interfaces.AlumnoDAO;
import com.ipartek.formacion.dao.mappers.AlumnoMapper;
import com.ipartek.formacion.dao.persistence.Alumno;

@Repository("alumnoDAOImp")
public class AlumnoDAOImp implements AlumnoDAO {
	@Autowired(required=true)
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;
	
	private static final Logger logger = LoggerFactory.getLogger(AlumnoDAOImp.class);
	
	@Override
	public List<Alumno> getAll() {
		List<Alumno> alumnos = null;
		
		final String sql = "SELECT codAlumno, nombre, apellidos, dni_nie, fNacimiento, email, telefono, codGenero FROM alumno";
		try{
			alumnos = jdbctemplate.query(sql, new AlumnoMapper());
		} catch(EmptyResultDataAccessException e){
			alumnos = new ArrayList<Alumno>();
		} catch(Exception e){
			
		}
		
		return alumnos;
	}

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcCall = new SimpleJdbcCall(dataSource);
		this.jdbctemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Alumno getById(int id) {
		Alumno alumno = null;
		
		final String sql = "SELECT codAlumno, nombre, apellidos, dni_nie, fNacimiento, email, telefono, codGenero FROM alumno WHERE codAlumno = ?";
		
		try{
			alumno = jdbctemplate.queryForObject(sql, new Object[]{id}, new AlumnoMapper());
		} catch(EmptyResultDataAccessException e){
			alumno = new Alumno();
		} catch(Exception e){
			
		}
		
		return alumno;
	}

	@Override
	public Alumno create(Alumno alumno) {
		/*
		 * insertAlumno --> Es el nombre del procedimiento de la BDA
		 */
		jdbcCall.withProcedureName("insertAlumno");
		SqlParameterSource in = new MapSqlParameterSource().
				addValue("nombre", alumno.getNombre()).
				addValue("apellidos", alumno.getApellidos()).
				addValue("dni_nie", alumno.getDni_nie()).
				addValue("fNacimiento", alumno.getfNacimiento()).
				addValue("email", alumno.getEmail()).
				addValue("telefono", alumno.getTelefono()).
				addValue("codGenero", alumno.getCodGenero());
		
		Map<String, Object> out = jdbcCall.execute(in);
		alumno.setCodigo((Integer) out.get("codalumno"));
		logger.info("Alumno creado correctamente.");

		return alumno;
	}

	@Override
	public Alumno update(Alumno alumno) {
		final String sql = "UPDATE alumno SET nombre=UPPER(?), apellidos=UPPER(?), dni_nie=UPPER(?), fNacimiento=?, email=UPPER(?), telefono=?, codGenero=? WHERE codAlumno = ?";
		jdbctemplate.update(sql, new Object[]{alumno.getNombre(), alumno.getApellidos(), 
											alumno.getDni_nie(), alumno.getfNacimiento(), 
											alumno.getEmail(), alumno.getTelefono(), 
											alumno.getCodGenero(), alumno.getCodigo()});
		return alumno;
	}

	@Override
	public void delete(int id) {
		final String sql = "DELETE FROM alumno WHERE codAlumno = ?";
		jdbctemplate.update(sql, new Object[]{id});
		// Las dos opciones son iguales
		//jdbctemplate.update(sql, id);
	}

}
