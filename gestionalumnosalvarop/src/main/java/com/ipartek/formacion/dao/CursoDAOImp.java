package com.ipartek.formacion.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dao.interfaces.CursoDAO;
import com.ipartek.formacion.dao.mappers.AlumnoMapper;
import com.ipartek.formacion.dao.mappers.CursoMapper;
import com.ipartek.formacion.dao.persistencia.Curso;

@Repository
public class CursoDAOImp implements CursoDAO{

private JdbcTemplate jdbctemplate;
	
@Autowired(required=true)
private DataSource dataSource;
public DataSource getDataSource() {
	return dataSource;
}

@Autowired
public void setDataSource(DataSource dataSource) {
	this.dataSource = dataSource;
	jdbctemplate=new JdbcTemplate(dataSource);
}

	@Override
	public List<Curso> getAll() {

		List<Curso>cursos=null;
		final String SQL="SELECT codCurso, nombre FROM curso";
		try {
			cursos=jdbctemplate.query(SQL, new CursoMapper());
		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
		}
		
		return cursos;
	}

	@Override
	public Curso getByid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curso create(Curso curso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Curso update(Curso curso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCursoDAO(CursoDAOImp cursDAO) {
		// TODO Auto-generated method stub
		
	}

}
