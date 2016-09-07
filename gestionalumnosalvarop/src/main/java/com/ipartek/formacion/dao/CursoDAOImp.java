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

@Repository("cursoDAOImp")
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
			e.getMessage();
		}
		
		return cursos;
	}

	@Override
	public Curso getByid(int id) {
	Curso curso=null;
	final String SQL="SELECT nombre FROM curso WHERE codCurso = ?";
		try {
			curso=jdbctemplate.queryForObject(SQL,new Object[]{id} ,new CursoMapper());
		} catch (EmptyResultDataAccessException e) {
			curso=new Curso();
		}
		return curso;
	}

	@Override
	public Curso create(Curso curso) {

		return curso;
	}

	@Override
	public void delete(int id) {
		final String SQL="DELETE FROM curso WHERE codCurso = ?";
		
		jdbctemplate.update(SQL, new Object[]{id});
		jdbctemplate.update(SQL,id);
		
	}

	@Override
	public Curso update(Curso curso) {
		final String SQL="UPDATE alumno SET(nombre=?,apellidos=?) WHERE codAlumno = ?";
		jdbctemplate.update(SQL,curso.getNombre(),curso.getCodigo());
		return curso;
	}

	@Override
	public void setCursoDAO(CursoDAOImp cursDAO) {
		// TODO Auto-generated method stub
		
	}

}
