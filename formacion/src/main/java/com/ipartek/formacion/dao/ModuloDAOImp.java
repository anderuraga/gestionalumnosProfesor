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

import com.ipartek.formacion.dao.interfaces.ModuloDAO;
import com.ipartek.formacion.dao.mappers.ModuloMapper;
import com.ipartek.formacion.dao.persistence.Modulo;

@Repository
public class ModuloDAOImp implements ModuloDAO{

	@Autowired(required=true)
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;
	
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbctemplate=new JdbcTemplate(dataSource);
	}

	@Override
	public List<Modulo> getAll() {
		List <Modulo>modulos=null;
		final String sql="SELECT codModulo, nombreModulo, uFormativa, durModulo FROM modulo";
		try {
			modulos=jdbctemplate.query(sql, new ModuloMapper());
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			}
				
		return modulos;
	}

	@Override
	public Modulo getById(int id) {
		Modulo m=null;
		final String sql="SELECT codModulo, nombreModulo, uFormativa, durModulo FROM modulo where codModulo=?";
		try {
			m=jdbctemplate.queryForObject(sql, new Object[]{id},new ModuloMapper());
		} catch (EmptyResultDataAccessException e) {
			m=new Modulo();
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public void delete(int id) {
		final String sql="DELETE FROM modulo WHERE codModulo=?";
		jdbctemplate.update(sql,new Object[]{id});
		
	}

	@Override
	public Modulo update(Modulo m) {
		final String sql="UPDATE modulo SET(nombreModulo=?, uFormativa=?,durModulo=?)where codModulo=?";
		jdbctemplate.update(sql,m.getNombreModulo(),m.getuFormativa(),m.getDuracion(),m.getCodModulo());
		
		return m;
	}

	@Override
	public Modulo create(Modulo m) {
		this.jdbcCall=new SimpleJdbcCall(dataSource)
		.withProcedureName("insertModulo");
				
		SqlParameterSource in=new MapSqlParameterSource().addValue("nombreModulo", m.getNombreModulo()).addValue("u", m.getuFormativa()).addValue("durModulo", m.getDuracion());	
		
		Map<String,Object> out=jdbcCall.execute(in);
		m.setCodModulo((Integer)out.get("codigo"));
		
		return m;
	}

}
