package com.ipartek.formacion.dao;

import java.security.GeneralSecurityException;
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
import com.ipartek.formacion.dao.persistencia.Curso;

@Repository("cursoDAOImp")
public class CursoDAOImp implements CursoDAO{
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
		jdbctemplate=new JdbcTemplate(dataSource);
		jdbcCall = new SimpleJdbcCall(dataSource);
	}

	@Override
	public List<Curso> getAll() {
		List<Curso>cursos=null;
		final String SQL="SELECT codCurso, nombre, codPatrocinador, codTipoCurso FROM curso";
		try{
			cursos=jdbctemplate.query(SQL, new CursoMapper());
		}catch(EmptyResultDataAccessException e){
			cursos=new ArrayList<Curso>();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return cursos;
	}

	@Override
	public Curso getById(int id) {
		Curso curso=null;
		final String SQL="SELECT codCurso, nombre, codPatrocinador, codTipoCurso FROM curso WHERE codCurso=?";
		try{
			curso=jdbctemplate.queryForObject(SQL, new Object[]{id}, new CursoMapper());
		}catch(EmptyResultDataAccessException e){
			curso=new Curso();
		}
		return curso;
	}

	@Override
	public Curso update(Curso curso) {
		final String SQL="UPDATE curso SET nombre=?, codPatrocinador=?, codTipoCurso=? WHERE codCurso=?";
		jdbctemplate.update(SQL, curso.getNombre(),curso.getCodigo());
		return curso;
	}

	@Override
	public void delete(int id) {
		final String SQL="DELETE FROM curso WHERE codCurso=?";
		jdbctemplate.update(SQL, new Object[]{id});
	}

	@Override
	public Curso create(Curso curso) {
		jdbcCall.withProcedureName("insertCurso");
		SqlParameterSource in= new MapSqlParameterSource().
				addValue("nombre",curso.getNombre()).
				addValue("codPatrocinador", curso.getCodPatrocinador()).
				addValue("codTipoCurso", curso.getCodTipoCurso());
				//addValue("codCurso", curso.getCodigo());
		Map<String,Object> out=jdbcCall.execute(in);
		curso.setCodigo((Integer) out.get("codcurso"));
		return curso;
	}

}
