package com.ipartek.formacion.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.ipartek.formacion.controller.ModuloController;
import com.ipartek.formacion.dao.interfaces.CursoDAO;
import com.ipartek.formacion.dao.mappers.AlumnoMapper;
import com.ipartek.formacion.dao.mappers.CursoMapper;
import com.ipartek.formacion.dao.persistence.Alumno;
import com.ipartek.formacion.dao.persistence.Curso;

public class CursoDAOImp implements CursoDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(CursoDAOImp.class);

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbctemplate = new JdbcTemplate(dataSource);
		jdbcCall = new SimpleJdbcCall(dataSource);
	}

	@Override
	public List<Curso> getAll() {

		List<Curso> cursos = null;
		final String SQL = "SELECT codCurso, nombre FROM curso";
		
		try {
			cursos = jdbctemplate.query(SQL, new CursoMapper());
		}catch (EmptyResultDataAccessException e) {

			cursos = new ArrayList<Curso>();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return cursos;
	}

	@Override
	public Curso getById(int id) {
		
		Curso curso = null;
		
		final String SQL = "SELECT codCurso, nombre FROM curso WHERE codCurso = ?";
		
		curso = jdbctemplate.queryForObject(SQL, new Object[]{id}, new CursoMapper());
		
		try {
			
		} catch (EmptyResultDataAccessException e) {
			curso = new Curso();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return curso;
	}

	@Override
	public Curso create(Curso curso) {

		jdbcCall.withProcedureName("insertCurso");
		SqlParameterSource in = new MapSqlParameterSource().addValue("nombre", curso.getNombre()).addValue("codTipoCurso", "1").addValue("codPatrocinador", "s");
		Map<String, Object> out = jdbcCall.execute(in);
		
		return curso;
	}

	@Override
	public Curso update(Curso curso) {

		jdbcCall.withProcedureName("updateCurso");
		SqlParameterSource in = new MapSqlParameterSource().addValue("codigo", curso.getCodigo()).addValue("nombre", curso.getNombre()).addValue("codTipo", "1").addValue("codPatrocinador", "s");
		Map<String, Object> out = jdbcCall.execute(in);
		
		return curso;
	}

	@Override
	public void delete(int id) {

		final String SQL = "DELETE FROM curso WHERE codCurso = ?";
		
		jdbctemplate.update(SQL, new Object[]{id});
	}

}
