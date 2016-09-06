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
		final String SQL = "SELECT codigoModulo,nombreModulo FROM modulo";
		try {
			modulos = jdbctemplate.query(SQL, new ModuloMapper());
		} catch (EmptyResultDataAccessException e) {
			modulos = new ArrayList<Modulo>();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return modulos;
	}

	@Override
	public Modulo getById(int id) {
		Modulo modulos = null;
		final String SQL = "SELECT codigoModulo,nombreModulo from modulo Where codigoModulo =?";
		try {
			modulos = jdbctemplate.queryForObject(SQL, new Object[] { id }, new ModuloMapper());
		} catch (EmptyResultDataAccessException e) {
			modulos = new Modulo();
		}
		return modulos;
	}

	@Override
	public Modulo update(Modulo modulo) {
		Modulo modulos = null;
		final String SQL = "UPDATE modulo SET(nombreModulo = ?) WHERE codigoModulo= ?";
		jdbctemplate.update(SQL, modulos.getNombre(), modulos.getCodigo());
		return modulos;
	}

	@Override
	public Modulo create(Modulo modulo) {
		Modulo modulos = null;
		final String SQL = "INSERT modulo(codigoModulo,nombreModulo) values(?,?)";
		jdbctemplate.update(SQL, modulos.getNombre(), modulos.getCodigo());
		return modulos;
	}

	@Override
	public void delete(int id) {
		final String SQL = "DELETE FROM modulo WHERE codigoModulo= ?";
		jdbctemplate.update(SQL, new Object[] { id });
	}

}
