package com.ipartek.formacion.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.ipartek.formacion.dao.interfaces.ModuloDAO;
import com.ipartek.formacion.dao.persistencia.Modulo;

public class ModuloDAOImp implements ModuloDAO{
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;
	
	@Autowired(required=true)
	private DataSource dataSource;
	public DataSource getDataSource() {
		return dataSource;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcCall=new SimpleJdbcCall(dataSource);
		jdbctemplate=new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Modulo> getAll() {
		List<Modulo>modulos=null;
		return modulos;
	}

	@Override
	public Modulo getByid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Modulo create(Modulo modulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Modulo update(Modulo modulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setModuloDAO(ModuloDAOImp modulDAO) {
		// TODO Auto-generated method stub
		
	}



}
