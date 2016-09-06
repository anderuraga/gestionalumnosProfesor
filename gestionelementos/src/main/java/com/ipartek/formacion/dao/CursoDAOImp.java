package com.ipartek.formacion.dao;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.ipartek.formacion.dao.interfaces.CursoDAO;
import com.ipartek.formacion.dao.mappers.CursoMapper;
import com.ipartek.formacion.dao.persistence.Curso;

@Repository
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
		final String SQL = "SELECT codigoCurso,nombreCurso FROM curso";
		try {
			cursos = jdbctemplate.query(SQL, new CursoMapper());
		} catch (EmptyResultDataAccessException e) {
			cursos = new ArrayList<Curso>();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cursos;
	}

	@Override
	public Curso getById(int id) {
		Curso cursos = null;
		final String SQL = "SELECT codigoCurso,nombreCurso from curso Where codigoCurso =?";
		try {
			cursos = jdbctemplate.queryForObject(SQL, new Object[] { id }, new CursoMapper());
		} catch (EmptyResultDataAccessException e) {
			cursos = new Curso();
		}
		return cursos;
	}

	@Override
	public Curso update(Curso curso) {
		Curso cursos = null;
		final String SQL = "UPDATE curso SET(nombreCurso = ?) WHERE codigoCurso= ?";
		jdbctemplate.update(SQL, cursos.getNombre(), cursos.getCodigo());
		return cursos;
	}

	@Override
	public Curso create(Curso curso) {
		Curso cursos = null;
		final String SQL = "INSERT curso(codigoCurso,nombreCurso) values(?,?)";
		jdbctemplate.update(SQL, cursos.getNombre(), cursos.getCodigo());
		return cursos;
	}

	@Override
	public void delete(int id) {
		final String SQL = "DELETE FROM curso WHERE codigoCurso= ?";
		jdbctemplate.update(SQL, new Object[] { id });
	}

}
