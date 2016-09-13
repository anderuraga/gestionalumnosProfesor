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
import com.ipartek.formacion.dao.mappers.CursoMapper;
import com.ipartek.formacion.dao.persistence.Curso;

@Repository
public class CursoDAOImp implements CursoDAO {

	@Autowired
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall jdbcCall;

	@Override
	public List<Curso> getAll() {
		List<Curso> cursos = null;

		final String SQL = "SELECT codCurso, nombre, codPatrocinador, codTipoCurso FROM curso";
		try {
			cursos = jdbcTemplate.query(SQL, new CursoMapper());
		} catch (EmptyResultDataAccessException e) {
			cursos = new ArrayList<Curso>();
		} catch (Exception e) {

		}
		return cursos;
	}

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);

	}

	@Override
	public Curso create(Curso curso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curso getByID(int id) {
		Curso curso = null;

		final String SQL = "SELECT codCurso, nombre, codPatrocinador, codTipoCurso FROM curso WHERE codCurso=?";
		try {
			curso = jdbcTemplate.queryForObject(SQL, new Object[] { id }, new CursoMapper());
		} catch (EmptyResultDataAccessException e) {
			curso = new Curso();
		} catch (Exception e) {

		}
		return curso;
	}

	@Override
	public Curso update(Curso curso) {
		jdbcCall.withProcedureName("updateCurso"); // usando las rutinas / procedures creadas en la BBDD
		SqlParameterSource in = new MapSqlParameterSource().addValue("codigo", curso.getCodigo()).addValue("nombre", curso.getNombre()).addValue("codPatrocinador", curso.getCodPatrocinador()).addValue("codTipoCurso", curso.getCodTipoCurso());
		Map<String, Object> out =jdbcCall.execute(in);
		return curso;
	}

	@Override
	public void delete(int id) {
		final String SQL = "DELETE FROM curso WHERE codCurso=?";

		jdbcTemplate.update(SQL, new Object[] { id });

	}

}
