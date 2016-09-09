package com.ipartek.formacion.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.controller.ModuloController;
import com.ipartek.formacion.dao.persistence.Modulo;

public class ModuloMapper implements RowMapper<Modulo>{
	private static final Logger logger = LoggerFactory.getLogger(ModuloMapper.class);


	@Override
	public Modulo mapRow(ResultSet rs, int arg1) throws SQLException {

		Modulo modulo = null;
		modulo = new Modulo();
		
		modulo.setCodigo(rs.getInt("codModulo"));
		modulo.setNombre(rs.getString("nombre"));
		
		return modulo;
	}

}
