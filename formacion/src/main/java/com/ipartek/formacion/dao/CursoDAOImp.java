package com.ipartek.formacion.dao;

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
	@Autowired(required=true)
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;
	
	@Override
	public List<Curso> getAll() {
		List<Curso>cursos=null;
		final String sql="SELECT codCurso, nombreCurso, codPatrocinador, tipoCurso FROM curso";
		try {
			cursos=jdbctemplate.query(sql, new CursoMapper());
		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
		}
		
		return cursos;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbctemplate=new JdbcTemplate(dataSource);
	}

	@Override
	public Curso getById(int id) {
		Curso c=null;
		final String sql="SELECT codCurso, nombreCurso, codPatrocinador, tipoCurso FROM curso WHERE codCurso=?";
		try {
			c=jdbctemplate.queryForObject(sql, new Object[]{id},new CursoMapper());
		} catch (EmptyResultDataAccessException e) {
			c=new Curso();
			e.printStackTrace();
		}
		
		return c;
	}

	@Override
	public Curso update(Curso c) {
		final String sql="UPDATE curso SET(nombreCurso=?, codPatrocinador=?, tipoCurso=?)WHERE codCurso=?";
		jdbctemplate.update(sql,c.getNombreCurso(),c.getCodPatrocinador(),c.getTipoCurso(),c.getCodCurso());
		return c;
	}

	@Override
	public void delete(int id) {
		final String sql="DELETE FROM curso WHERE codCurso=?";
		jdbctemplate.update(sql,new Object[]{id});
		
	}

	@Override
	public Curso create(Curso c) {
		this.jdbcCall=new SimpleJdbcCall(dataSource)
		.withProcedureName("insertCurso");
				
		SqlParameterSource in=new MapSqlParameterSource().addValue("nombreCurso", c.getNombreCurso()).addValue("codPatrocinador", c.getCodPatrocinador()).addValue("tCurso", c.getTipoCurso());	
		
		Map<String,Object> out=jdbcCall.execute(in);
		c.setCodCurso((Integer)out.get("codigo"));
		
		return c;
	}

}
