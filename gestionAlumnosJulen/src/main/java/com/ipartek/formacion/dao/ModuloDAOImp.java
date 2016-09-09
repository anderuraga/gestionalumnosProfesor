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

import com.ipartek.formacion.controller.ModuloController;
import com.ipartek.formacion.dao.interfaces.ModuloDAO;
import com.ipartek.formacion.dao.mappers.CursoMapper;
import com.ipartek.formacion.dao.mappers.ModuloMapper;
import com.ipartek.formacion.dao.persistence.Curso;
import com.ipartek.formacion.dao.persistence.Modulo;

public class ModuloDAOImp implements ModuloDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(ModuloDAOImp.class);

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;
	

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbctemplate = new JdbcTemplate(dataSource);
		jdbcCall = new SimpleJdbcCall(dataSource);
	}

	@Override
	public List<Modulo> getAll() {

		List<Modulo> modulos = null;
		final String SQL = "SELECT codModulo, nombre FROM modulo";
		
		try {
			modulos = jdbctemplate.query(SQL, new ModuloMapper());
		}catch (EmptyResultDataAccessException e) {
			modulos = new ArrayList<Modulo>();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return modulos;
	}

	@Override
	public Modulo getById(int id) {
		Modulo modulo = null;
		
		final String SQL = "SELECT codModulo, nombre FROM modulo WHERE codModulo = ?";
		
		modulo = jdbctemplate.queryForObject(SQL, new Object[]{id}, new ModuloMapper());
		
		try {
			
		} catch (EmptyResultDataAccessException e) {
			modulo = new Modulo();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return modulo;
	}

	@Override
	public Modulo create(Modulo modulo) {
		jdbcCall.withProcedureName("insertModulo");
		SqlParameterSource in = new MapSqlParameterSource().addValue("nombre", modulo.getNombre()).addValue("uFormativa", "uno").addValue("duracion", "60");
		Map<String, Object> out = jdbcCall.execute(in);
		
		return modulo;
	}

	@Override
	public Modulo update(Modulo modulo) {
		jdbcCall.withProcedureName("updateModulo");
		SqlParameterSource in = new MapSqlParameterSource().addValue("codigo", modulo.getCodigo()).addValue("nombre", modulo.getNombre()).addValue("uFormativa", "uno").addValue("duracion", "60");
		Map<String, Object> out = jdbcCall.execute(in);
		
		return modulo;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
