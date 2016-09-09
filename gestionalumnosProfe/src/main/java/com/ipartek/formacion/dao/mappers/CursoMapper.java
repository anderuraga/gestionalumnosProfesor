package com.ipartek.formacion.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dao.persistence.Curso;

public class CursoMapper implements RowMapper<Curso>{

	@Override
	public Curso mapRow(ResultSet rs, int arg1) throws SQLException {
		Curso curso = null;
		curso = new Curso();
		curso.setCodigo(rs.getInt("codCurso"));
		curso.setNombre(rs.getString("nombre"));
		curso.setCodTipoCurso(rs.getInt("codTipoCurso"));
		return curso;
	}

}
