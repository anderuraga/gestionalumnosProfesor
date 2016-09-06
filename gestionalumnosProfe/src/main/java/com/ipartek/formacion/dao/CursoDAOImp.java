package com.ipartek.formacion.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ipartek.formacion.dao.interfaces.CursoDAO;
import com.ipartek.formacion.dao.mappers.CursoMapper;
import com.ipartek.formacion.dao.mappers.CursoMapper;
import com.ipartek.formacion.dao.persistence.Curso;
import com.ipartek.formacion.dao.persistence.Curso;
import com.ipartek.formacion.dao.persistence.Curso;

public class CursoDAOImp implements CursoDAO {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbctemplate = new JdbcTemplate(dataSource);

	}

	@Override
	public List<Curso> getAll() {
		List<Curso> cursos = null;
		final String SQL = "SELECT codCurso, nombre FROM curso";
		try {
			cursos = jdbctemplate.query(SQL, new CursoMapper());
		} catch (EmptyResultDataAccessException e) {
			cursos = new ArrayList<Curso>();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cursos;
	}

	@Override
	public Curso getById(int id) {
		Curso curso = null;
		final String SQL = "SELECT codCurso, nombre FROM curso WHERE codCurso = ?";
		try {
			curso = jdbctemplate.queryForObject(SQL, new Object[] { id },
					new CursoMapper());
		} catch (EmptyResultDataAccessException e) {
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
		final String SQL = "DELETE FROM alumno WHERE codAlumno = ?";
		jdbctemplate.update(SQL, new Object[] { id });
		// jdbctemplate.update(SQL, id);

	}

	@Override
	public Curso update(Curso curso) {
		final String SQL = "UPDATE curso SET(nombre = ?) WHERE = ?";
		jdbctemplate.update(SQL, curso.getNombre(),
				curso.getCodigo());
		return curso;
	}

}
