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
		final String SQL = "SELECT codCurso,nombre FROM curso";
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
		final String SQL = "SELECT codCurso,Nombre from curso Where codCurso =?";
		try {
			cursos = jdbctemplate.queryForObject(SQL, new Object[] { id }, new CursoMapper());
		} catch (EmptyResultDataAccessException e) {
			cursos = new Curso();
		}
		return cursos;
	}

	@Override
	public Curso create(Curso curso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curso update(Curso curso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
