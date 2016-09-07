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

import com.ipartek.formacion.dao.interfaces.CursoDAO;
import com.ipartek.formacion.dao.mapas.CursoMapper;
import com.ipartek.formacion.dao.persistencia.Curso;



@Repository
public class CursoDAOImp implements CursoDAO{
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;
	
	@Override
	public List<Curso> getAll() {
		List<Curso> cursos = null;
		final String SQL= "SELECT codCurso,nombre FROM curso";
		try{
			cursos = jdbctemplate.query(SQL, new CursoMapper());
		}catch(EmptyResultDataAccessException e){
			cursos = new ArrayList<Curso>(); //devolvemos la lista vacía
		}catch(Exception e){
			
		}
		
		return cursos;
	}

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(dataSource); 
		this.jdbcCall = new SimpleJdbcCall(dataSource);
	}

	@Override
	public Curso getById(int id) {
		Curso curso = null;
		final String SQL = "SELECT codCurso, nombre FROM curso WHERE codCurso = ?";
		
		try{
			curso = jdbctemplate.queryForObject(SQL,new Object[] {id},new CursoMapper());
		}catch(EmptyResultDataAccessException e){
			curso = new Curso();
		}
		
		return curso;
	}
	
	@Override
	public void delete(int id) {
		final String SQL = "DELETE FROM curso WHERE codCurso = ?";
		
		jdbctemplate.update(SQL, new Object[] {id});
		//jdbctemplate.update(SQL, id); otra forma de hacerlo
		
	}

	@Override
	public Curso update(Curso curso) {
		final String SQL = "UPDATE curso SET nombre = ?  WHERE codCurso = ?";
		
		jdbctemplate.update(SQL,curso.getNombre(),curso.getCodigo());
		
		return curso;
	}

	
	@Override
	public Curso create(Curso curso) {
		SqlParameterSource in = new MapSqlParameterSource().
				addValue("nombre",curso.getNombre() ).
				addValue("codPatrocinador", 1);
				
		Map<String, Object> out = jdbcCall.execute(in);
		curso.setCodigo((Integer) out.get("codCurso") );
		
		return curso;
	}

}