package com.ipartek.formacion.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dao.interfaces.CursoDAO;
import com.ipartek.formacion.dao.mappers.AlumnoMapper;
import com.ipartek.formacion.dao.mappers.CursoMapper;
import com.ipartek.formacion.dao.persistence.Alumno;
import com.ipartek.formacion.dao.persistence.Curso;

@Repository("cursoDAOImp")
public class CursoDAOImp implements CursoDAO {
	@Autowired(required=true)
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	
	@Override
	public List<Curso> getAll() {
		List<Curso> cursos = null;
		final String sql = "SELECT codCurso, nombre, codPatrocinador, codTipoCurso FROM curso";
		
		try{
			cursos = jdbctemplate.query(sql, new CursoMapper());
		} catch(EmptyResultDataAccessException e){
			cursos = new ArrayList<Curso>();
		} catch(Exception e){
			
		}
		
		return cursos;
	}

	@Override
	public Curso getById(int id) {
		Curso curso = null;
		
		final String sql = "SELECT codCurso, nombre, codPatrocinador, codTipoCurso FROM curso WHERE codCurso = ?";
		
		try{
			curso = jdbctemplate.queryForObject(sql, new Object[]{id}, new CursoMapper());
		} catch(EmptyResultDataAccessException e){
			curso = new Curso();
		} catch(Exception e){
			
		}
		
		return curso;
	}

	@Override
	public Curso create(Curso curso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curso update(Curso curso) {
		final String sql = "UPDATE curso SET nombre=?, codPatrocinador=?, codTipoCurso=? WHERE codCurso = ?";
		jdbctemplate.update(sql, new Object[]{curso.getNombre(), curso.getCodPatrocinador(), curso.getCodTipoCurso(), curso.getCodigo()});
		return curso;
	}

	@Override
	public void delete(int id) {
		final String sql = "DELETE FROM curso WHERE codCurso = ?";
		jdbctemplate.update(sql, new Object[]{id});
	}
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbctemplate = new JdbcTemplate(dataSource);
	}

}
