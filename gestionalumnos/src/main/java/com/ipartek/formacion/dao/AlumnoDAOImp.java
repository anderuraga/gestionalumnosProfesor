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

		final String SQL = "SELECT codAlumno, nombre, apellidos FROM alumno";
		try{
			alumnos = jdbcTemplate.query(SQL, new AlumnoMapper());
			
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

	@Override
	public Alumno create(Alumno alumno) {
		final String SQL ="";
		return alumno;
	}

	@Override
	public Alumno getById(int id) {
		Alumno alumno = null;
		final String SQL = "SELECT codAlumno, nombre, apellidos FROM alumno WHERE codAlumno = ?";
		
		try{
			alumno = jdbcTemplate.queryForObject(SQL, new Object[] {id}, new AlumnoMapper());
			
		}catch(EmptyResultDataAccessException e){
			alumno = new Alumno();
		}
		return alumno;
		
	}
	public Alumno update(Alumno alumno) {
		
		final String SQL = "UPDATE alumno, SET nombre = ?, apellidos = ? WHERE = ? ";		
		jdbcTemplate.update(SQL, alumno.getNombre(), alumno.getApellidos(), alumno.getCodigo());
		
		return alumno;
	}

	@Override
	public void delete(int id) {
		final String SQL = "DELETE FROM alumno WHERE codAlumno = ?";
		
		jdbcTemplate.update(SQL, new Object[] {id});
		
	}
	

}
