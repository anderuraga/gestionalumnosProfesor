package com.ipartek.formacion.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.controller.ModuloController;
import com.ipartek.formacion.dao.persistence.Curso;

public class CursoMapper implements RowMapper<Curso>{
	private static final Logger logger = LoggerFactory.getLogger(CursoMapper.class);


	@Override
	public Curso mapRow(ResultSet rs, int arg1) throws SQLException {

		Curso curso = null;
		
		curso = new Curso();
		
		curso.setCodigo(rs.getInt("codCurso"));
		curso.setNombre(rs.getString("nombre"));
		
		return curso;
	}

}
