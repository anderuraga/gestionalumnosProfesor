package com.ipartek.formacion.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dao.interfaces.ModuloDAO;
import com.ipartek.formacion.dao.mappers.AlumnoMapper;
import com.ipartek.formacion.dao.mappers.ModuloMapper;
import com.ipartek.formacion.dao.persistence.Modulo;

@Repository("moduloDAOImp")
public class ModuloDAOImp implements ModuloDAO {
	@Autowired(required=true)
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbctemplate = new JdbcTemplate(dataSource);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Modulo update(Modulo modulo) {
		final String sql = "UPDATE modulo SET(nombre=?, uFormativa=?, duracion=?) WHERE codModulo=?";
		jdbctemplate.update(sql, new Object[]{modulo.getNombre(), modulo.getuFormativa(), modulo.getDuracion(), modulo.getCodigo()});
		return modulo;
	}

	@Override
	public void delete(int id) {
		final String sql = "DELETE FROM modulo WHERE codModulo=?";
		jdbctemplate.update(sql, id);
	}

}
