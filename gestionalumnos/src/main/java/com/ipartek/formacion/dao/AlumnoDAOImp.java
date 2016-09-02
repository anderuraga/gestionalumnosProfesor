package com.ipartek.formacion.dao;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.ipartek.formacion.dao.interfaces.AlumnoDAO;
import com.ipartek.formacion.dao.mapas.AlumnoMapper;
import com.ipartek.formacion.dao.persistencia.Alumno;

@Repository("alumnoDAOImp")
public class AlumnoDAOImp implements AlumnoDAO {
	@Autowired(required = true)
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Alumno> getAll(){
		List<Alumno> alumnos = null;

		final String sql = "SELECT codigo, nombre, apellidos FROM alumno";
		try{
			alumnos = jdbcTemplate.query(sql, new AlumnoMapper());
			
		}catch(EmptyResultDataAccessException e){
			alumnos = new ArrayList<Alumno>();
		}catch (Exception e){
			e.printStackTrace();
		}
				
		return alumnos;
	}

	@Autowired
	@Override
	
	public void setDataSource(DataSource dataSource) {
		
		this.dataSource = dataSource;
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		
	}
	

}
