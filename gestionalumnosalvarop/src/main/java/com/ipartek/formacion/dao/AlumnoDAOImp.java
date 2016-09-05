package com.ipartek.formacion.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dao.interfaces.AlumnoDAO;
import com.ipartek.formacion.dao.mappers.AlumnoMapper;
import com.ipartek.formacion.dao.persistencia.Alumno;

@Repository
public class AlumnoDAOImp implements AlumnoDAO{
private JdbcTemplate jdbctemplate;

@Autowired(required=true)
private DataSource dataSource;
public DataSource getDataSource() {
	return dataSource;
}

@Autowired
public void setDataSource(DataSource dataSource) {
	this.dataSource = dataSource;
	jdbctemplate=new JdbcTemplate(dataSource);
}


	
	@Override
	public List<Alumno> getAll() {

		List<Alumno> alumnos=null;
		final String sql="SELECT codAlumno, nombre FROM alumno";
		try {
			alumnos=jdbctemplate.query(sql, new AlumnoMapper());
		} catch (EmptyResultDataAccessException e) {
			alumnos=new ArrayList<Alumno>();
		}catch (Exception e) {
			e.getMessage();
		}

		return alumnos;
	}

}
