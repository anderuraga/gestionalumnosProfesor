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
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dao.interfaces.CursoDAO;
import com.ipartek.formacion.dao.mapas.CursoMapper;
import com.ipartek.formacion.dao.persistence.Curso;

@Repository
public class CursoDAOImp implements CursoDAO {
	private static final Logger logger = LoggerFactory
			.getLogger(CursoDAOImp.class);
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;

	@Override
	public List<Curso> getAll() {
		List<Curso> cursos = new ArrayList<Curso>();
		final String SQL = "SELECT codCurso, nombre FROM curso;";
		try {
			cursos = jdbctemplate.query(SQL, new CursoMapper());
		} catch (EmptyResultDataAccessException e) {
			cursos = new ArrayList<Curso>();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return cursos;
	}

	@Override
	public Curso getById(int id) {
		Curso curso = null;
		final String SQL = "SELECT codCurso, nombre FROM curso WHERE codCurso = ?;";
		try {
			curso = jdbctemplate.queryForObject(SQL, new Object[] { id },
					new CursoMapper());
		} catch (EmptyResultDataAccessException e) {
			curso = new Curso();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return curso;
	}

	@Override
	public Curso create(Curso curso) {
		jdbcCall.withProcedureName("insertCurso");
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("nombre", curso.getNombre())
				.addValue("codTipoCurso", 1)
				.addValue("codPatrocinador", "a");
		Map<String, Object> out = jdbcCall.execute(in);
		curso.setCodigo((Integer) out.get("codcurso"));
		return curso;
	}

	@Override
	public Curso update(Curso curso) {
		final String SQL = "UPDATE curso SET nombre = ? WHERE codCurso = ?;";
		jdbctemplate.update(SQL,
				new Object[] { curso.getNombre(), curso.getCodigo() });
		return curso;
	}

	@Override
	public void delete(int id) {
		final String SQL = "DELETE FROM curso WHERE codCurso = ?;";
		jdbctemplate.update(SQL, id);
	}

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(dataSource);
		this.jdbcCall = new SimpleJdbcCall(dataSource);
	}
}
