package com.ipartek.formacion.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ipartek.formacion.dao.interfaces.ModuloDAO;
import com.ipartek.formacion.dao.persistencia.Modulo;

public class ModuloDAOImp implements ModuloDAO{
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Modulo getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Modulo create(Modulo modulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Modulo delete(Modulo modulo) {
		// TODO Auto-generated method stub
		return null;
	}

}
