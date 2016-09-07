package com.ipartek.formacion.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dao.interfaces.ModuloDAO;
import com.ipartek.formacion.dao.mappers.ModuloMapper;
import com.ipartek.formacion.dao.persistence.Modulo;

@Repository
public class ModuloDAOImp implements ModuloDAO {

	@Autowired
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);

	}

	@Override
	public List<Modulo> getAll() {
		List<Modulo> modulos = null;
		final String SQL = "SELECT codModulo, nombre FROM modulo";
		try {
			modulos = jdbcTemplate.query(SQL, new ModuloMapper());
		} catch (EmptyResultDataAccessException e) {
			modulos = new ArrayList<Modulo>();
		} catch (Exception e) {

		}
		return modulos;
	}

	@Override
	public Modulo create(Modulo modulo) {
		final String SQL = "INSERT INTO modulo (nombre) Values ('?')";

		jdbcTemplate.update(SQL, modulo.getNombre());
		return modulo;
	}

	@Override
	public Modulo getByID(int id) {
		Modulo modulo = null;

		final String SQL = "SELECT codModulo, nombre FROM modulo WHERE codModulo=?";
		try {
			modulo = jdbcTemplate.queryForObject(SQL, new Object[] { id }, new ModuloMapper());
		} catch (EmptyResultDataAccessException e) {
			modulo = new Modulo();
		} catch (Exception e) {

		}
		return modulo;
	}

	@Override
	public Modulo update(Modulo modulo) {
		final String SQL = "UPDATE modulo SET (nombre=?) WHERE codModulo=?";

		jdbcTemplate.update(SQL, modulo.getNombre(), modulo.getCodigo());
		return modulo;
	}

	@Override
	public void delete(int id) {
		final String SQL = "DELETE FROM modulo WHERE codModulo=?";

		jdbcTemplate.update(SQL, new Object[] { id });

	}
}
