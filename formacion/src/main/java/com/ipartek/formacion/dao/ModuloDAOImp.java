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

import com.ipartek.formacion.controller.AlumnosController;
import com.ipartek.formacion.dao.interfaces.ModuloDAO;
import com.ipartek.formacion.dao.mappers.AlumnoMapper;
import com.ipartek.formacion.dao.mappers.ModuloMapper;
import com.ipartek.formacion.dao.persistence.Modulo;

@Repository("moduloDAOImp")
public class ModuloDAOImp implements ModuloDAO {
	@Autowired(required=true)
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;
	
	private static final Logger logger = LoggerFactory.getLogger(ModuloDAOImp.class);

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(dataSource);
		this.jdbcCall = new SimpleJdbcCall(dataSource);
	}

	@Override
	public List<Modulo> getAll() {
		List<Modulo> modulos = null;
		
		final String sql = "SELECT codModulo, nombre, uFormativa, duracion FROM modulo";
		try{
			modulos = jdbctemplate.query(sql, new ModuloMapper());
		} catch(EmptyResultDataAccessException e){
			modulos = new ArrayList<Modulo>();
		} catch(Exception e){
			
		}
		
		return modulos;
	}

	@Override
	public Modulo getById(int id) {
		Modulo modulo = null;
		
		final String sql = "SELECT codModulo, nombre, uFormativa, duracion FROM modulo WHERE codModulo = ?";
		try{
			modulo = jdbctemplate.queryForObject(sql, new Object[]{id}, new ModuloMapper());
		} catch(EmptyResultDataAccessException e){
			modulo = new Modulo();
		} catch(Exception e){
			
		}
		
		return modulo;
	}

	@Override
	public Modulo create(Modulo modulo) {
		/*
		 * insertModulo --> Es el nombre del procedimiento de la BDA
		 */
		jdbcCall.withProcedureName("insertModulo");
		SqlParameterSource in = new MapSqlParameterSource().
				addValue("nombre", modulo.getNombre()).
				addValue("uFormativa", modulo.getuFormativa()).
				addValue("duracion", modulo.getDuracion());
		
		Map<String, Object> out = jdbcCall.execute(in);
		modulo.setCodigo((Integer) out.get("codmodulo"));
		logger.info("Modulo creado correctamente.");

		return modulo;
	}

	@Override
	public Modulo update(Modulo modulo) {
		final String sql = "UPDATE modulo SET nombre=?, uFormativa=?, duracion=? WHERE codModulo=?";
		jdbctemplate.update(sql, new Object[]{modulo.getNombre(), modulo.getuFormativa(), modulo.getDuracion(), modulo.getCodigo()});
		return modulo;
	}

	@Override
	public void delete(int id) {
		final String sql = "DELETE FROM modulo WHERE codModulo=?";
		jdbctemplate.update(sql, id);
	}

}
