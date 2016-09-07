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

@Repository("alumnoDAOImp")
public class AlumnoDAOImp implements AlumnoDAO {
	@Autowired(required=true)
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;
	
	@Override
	public List<Alumno> getAll() {
		List<Alumno> alumnos = null;
		
		final String sql = "SELECT codAlumno, nombre, apellidos FROM alumno";
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
		
		final String sql = "SELECT codAlumno, nombre, apellidos FROM alumno WHERE codAlumno = ?";
		
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
		addValue("apellidos", alumno.getApellidos());
		
		Map<String, Object> out = jdbcCall.execute(in);
		alumno.setCodigo((Integer) out.get("codAlumno"));
		alumno.setNombre((String) out.get("nombre"));
		alumno.setApellidos((String) out.get("apellidos"));
		
		return alumno;
	}

	@Override
	public Alumno update(Alumno alumno) {
		final String sql = "UPDATE alumno SET(nombre=?, apellidos=?) WHERE codAlumno = ?";
		jdbctemplate.update(sql, new Object[]{alumno.getNombre(), alumno.getApellidos(), alumno.getCodigo()});
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
