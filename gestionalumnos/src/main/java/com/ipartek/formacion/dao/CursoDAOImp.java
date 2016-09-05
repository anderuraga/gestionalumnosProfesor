package com.ipartek.formacion.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dao.interfaces.CursoDAO;
import com.ipartek.formacion.dao.mapas.CursoMapper;
import com.ipartek.formacion.dao.persistencia.Alumno;
import com.ipartek.formacion.dao.persistencia.Curso;

@Repository("cursoDAOImp")
public class CursoDAOImp implements CursoDAO {

	@Autowired(required = true)
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Curso> getAll() {
		List<Curso> cursos = null;
		
		final String SQL = "SELECT codCurso, nombre FROM curso";
		try{
			cursos = jdbcTemplate.query(SQL, new CursoMapper());
		}catch(EmptyResultDataAccessException e){
			
		}
		return cursos;
	}

	@Override
	public Curso getById(int id) {
		Curso curso =null;
		final String SQL ="SELECT codCurso, nombre, FROM curso WHERE codCurso = ?";
		
		try{
			curso = jdbcTemplate.queryForObject(SQL, new Object[] {id}, new CursoMapper());
		}catch(EmptyResultDataAccessException e){
			curso = new Curso();
		}
		return curso;
	}

	@Override
	public Curso create(Curso curso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		final String SQL = "DELETE FROM curso WHERE codCurso = ?";
		jdbcTemplate.update(SQL, new Object[] {id});
		
	}

	@Override
	public Curso update(Curso curso) {
		final String SQL ="UPDATE alumno, SET nombre = ? WHERE = ? ";
		jdbcTemplate.update(SQL, curso.getNombre(), curso.getCodigo());
		return null;
	}

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
		
	}

}
