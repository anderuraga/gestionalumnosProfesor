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
import com.ipartek.formacion.dao.mapas.AlumnoMapper;
import com.ipartek.formacion.dao.persistencia.Alumno;

@Repository
public class AlumnoDAOImp implements AlumnoDAO{
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;
	
	@Override
	public List<Alumno> getAll() {
		List<Alumno> alumnos = null;
		final String SQL= "SELECT codAlumno,nombre,apellidos FROM alumno";
		try{
			alumnos = jdbctemplate.query(SQL, new AlumnoMapper());
		}catch(EmptyResultDataAccessException e){
			alumnos = new ArrayList<Alumno>(); //devolvemos la lista vacía
		}catch(Exception e){
			
		}
		
		return alumnos;
	}

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(dataSource); 
		this.jdbcCall = new SimpleJdbcCall(dataSource);
	}

	@Override
	public Alumno getById(int id) {
		Alumno alumno = null;
		final String SQL = "SELECT codAlumno, nombre, apellidos FROM alumno WHERE codAlumno = ?";
		
		try{
			alumno = jdbctemplate.queryForObject(SQL,new Object[] {id},new AlumnoMapper());
		}catch(EmptyResultDataAccessException e){
			alumno = new Alumno();
		}
		
		return alumno;
	}
	
	@Override
	public void delete(int id) {
		final String SQL = "DELETE FROM alumno WHERE codAlumno = ?";
		
		jdbctemplate.update(SQL, new Object[] {id});
		//jdbctemplate.update(SQL, id); otra forma de hacerlo
		
	}

	@Override
	public Alumno update(Alumno alumno) {
		final String SQL = "UPDATE alumno SET nombre = ? ,apellidos = ? WHERE codAlumno = ?";
		
		jdbctemplate.update(SQL,alumno.getNombre(),alumno.getApellidos(),alumno.getCodigo());
		
		return alumno;
	}

	
	@Override
	public Alumno create(Alumno alumno) {
		
		jdbcCall.withProcedureName("insertAlumno");
		SqlParameterSource in = new MapSqlParameterSource().
				addValue("nombre",alumno.getNombre() ).
				addValue("apellidos", alumno.getApellidos()).
				addValue("dni", "123").
				addValue("fNacimiento", new java.util.Date()).
				addValue("email", "123").
				addValue("telef", "123").
				addValue("codGenero", 2);
						
		/*
		 * execute ejecuta el Procedimientyo almacenado
		 */
		
		Map<String, Object> out = jdbcCall.execute(in);
		
		alumno.setCodigo((Integer) out.get("codalumno") );
		
		return alumno;
	}

}
