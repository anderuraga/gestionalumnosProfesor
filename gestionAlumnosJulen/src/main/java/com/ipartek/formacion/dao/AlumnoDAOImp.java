package com.ipartek.formacion.dao;

import java.util.ArrayList;
import java.util.Date;
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
public class AlumnoDAOImp implements AlumnoDAO{
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	//Para trabajar con procedimientos almacenados
	private SimpleJdbcCall jdbcCall;
	
	@Override
	public List<Alumno> getAll() {

		List<Alumno> alumnos = null;
		final String sql = "SELECT codAlumno, nombre, apellidos FROM alumno";
		try {
			alumnos = jdbctemplate.query(sql, new AlumnoMapper());

		} catch(EmptyResultDataAccessException e){
		
			alumnos = new ArrayList<Alumno>();
			
		}catch (Exception e) {
			
		}
		
		return alumnos;
	}
	
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbctemplate = new JdbcTemplate(dataSource);
		jdbcCall = new SimpleJdbcCall(dataSource);
		
	}


	@Override
	public Alumno getById(int id) {
		
		Alumno alumno = null;
		
		final String SQL = "SELECT codAlumno, nombre, apellidos FROM alumno WHERE codAlumno = ?";
		
		alumno = jdbctemplate.queryForObject(SQL, new Object[]{id}, new AlumnoMapper());
		
		try {
			
		} catch (EmptyResultDataAccessException e) {
			alumno = new Alumno();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return alumno;
	}


	@Override
	public Alumno create(Alumno alumno) {

		//final String SQL = "INSERT INTO alumno (nombre, apellidos) VALUES (?,?)";
		
		//jdbctemplate.update(SQL, alumno.getNombre(),alumno.getApellidos());
		
		//Con procedimiento almacenado
		jdbcCall.withProcedureName("insertAlumno");
		SqlParameterSource in = new MapSqlParameterSource().addValue("nombre", alumno.getNombre()).addValue("apellidos", alumno.getApellidos()).addValue("dni", "45622967Y").addValue("fecha", "2016-10-14").addValue("email", "email").addValue("telefono", "123456789").addValue("codgenero", "1");
		Map<String, Object> out = jdbcCall.execute(in);
		
		//alumno.setCodigo((Integer) out.get("codAlumno")); 
		
		return alumno;
	}


	@Override
	public Alumno update(Alumno alumno) {

		final String SQL = "UPDATE alumno SET nombre = ?, apellidos = ?  WHERE codAlumno = ?";
		
		jdbctemplate.update(SQL, alumno.getNombre(),alumno.getApellidos(), alumno.getCodigo());
				
		return alumno;
	}


	@Override
	public void delete(int id) {

		final String SQL = "DELETE FROM alumno WHERE codAlumno = ?";
		
		jdbctemplate.update(SQL, new Object[]{id});
	}

	
	
}
