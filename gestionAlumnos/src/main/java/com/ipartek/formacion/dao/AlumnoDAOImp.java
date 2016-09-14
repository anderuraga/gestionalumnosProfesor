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
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;
	
	@Override
	public List<Alumno> getAll() {
		List<Alumno>alumnos=null;
		final String sql="SELECT codAlumno, nombre, apellidos, fNacimiento, dni_nie, telefono, email, codGenero FROM alumno";
		try{
			alumnos=jdbctemplate.query(sql, new AlumnoMapper());
		}catch(EmptyResultDataAccessException e){
			alumnos=new ArrayList<Alumno>();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return alumnos;
	}

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
		this.jdbctemplate=new JdbcTemplate(dataSource);
		this.jdbcCall=new SimpleJdbcCall(dataSource);
		
	}

	@Override
	public Alumno getById(int id) {
		Alumno alumno=null;
		final String SQL="SELECT codAlumno, nombre, apellidos, fNacimiento, dni_nie, telefono, email, codGenero FROM alumno WHERE codAlumno=?";
		try{
			alumno=jdbctemplate.queryForObject(SQL, new Object[]{id},new AlumnoMapper());
		}catch(EmptyResultDataAccessException e){
			alumno=new Alumno();
		}
		return alumno;
	}

	@Override
	public Alumno update(Alumno alumno) {
		final String SQL="UPDATE alumno SET nombre=?, apellidos=?, fNacimiento=?, telefono=?, email?=, codGenero=? WHERE codAlumno=?";
		jdbctemplate.update(SQL, alumno.getNombre(), alumno.getApellidos(), alumno.getCodigo());
		return alumno;
	}

	@Override
	public void delete(int id) {
		final String SQL="DELETE FROM alumno WHERE codAlumno=?";
		jdbctemplate.update(SQL, new Object[]{id});
	}

	@Override
	public Alumno create(Alumno alumno) {
		jdbcCall.withProcedureName("insertAlumno");
		SqlParameterSource in =new MapSqlParameterSource().
		addValue("nombre", alumno.getNombre()).
		addValue("apellidos", alumno.getApellidos()).
		addValue("fNacimiento", alumno.getfNacimiento()).
		addValue("dni_nie", alumno.getDni()).
		addValue("telefono", alumno.getTelefono()).
		addValue("email", alumno.getEmail()).
		addValue("codGenero", alumno.getCodGenero());
		
		Map<String,Object> out=jdbcCall.execute(in);
		alumno.setCodigo((Integer) out.get("codalumno"));
		return alumno;
	}

}