package com.ipartek.formacion.dao;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
	@Autowired(required=true)
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;
	
	@Override
	public List<Alumno> getAll() {
		List<Alumno>alumnos=null;
		final String sql="SELECT codAlumno, nombre, apellidos FROM alumno";
		try {
			alumnos=jdbctemplate.query(sql, new AlumnoMapper());
		} catch (EmptyResultDataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e){
			
		}
		
		
		
		
		return alumnos;
	}

	@Autowired
	public void setDataSource(DataSource dataSource){
		this.dataSource=dataSource;
		jdbctemplate=new JdbcTemplate(dataSource);
	}

	@Override
	public Alumno getById(int id) {
		Alumno a=null;
		final String sql="SELECT codAlumno, nombre, apellidos FROM alumno where codAlumno="+id;
		try {
			a=jdbctemplate.queryForObject(sql,new Object[]{id}, new AlumnoMapper());
		} catch (EmptyResultDataAccessException e) {
			a=new Alumno();
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(int id) {
		final String sql="DELETE FROM alumno WHERE codAlumno="+id;
		jdbctemplate.update(sql,new Object[]{id});
		
	}

	@Override
	public Alumno update(Alumno a) {
		final String sql="Update alumno set(nombre=?, apellidos=?)where codAlumno=?";
		jdbctemplate.update(sql,a.getNombre(),a.getApellidos(),a.getCodigo());
		return a;
	}

	public Alumno create(Alumno a) {
//		final String sql="call insertAlumno(?,?,?,?,?,?,?)";
//		jdbctemplate.update(sql,a.getNombre(),a.getApellidos(),"","",0,"","");
		this.jdbcCall=new SimpleJdbcCall(dataSource)
		.withProcedureName("insertAlumno");
				
		SqlParameterSource in=new MapSqlParameterSource()
		.addValue("nombre", a.getNombre())
		.addValue("apellido", a.getApellidos())
		.addValue("dni_nie", "")
		.addValue("fNacimiento", "")
		.addValue("codGenero", 1)
		.addValue("email", "")
		.addValue("telefono", "");	
		
		Map<String,Object> out=jdbcCall.execute(in);
		a.setCodigo((Integer)out.get("codigo"));
		
		return a;
	}
	
}
