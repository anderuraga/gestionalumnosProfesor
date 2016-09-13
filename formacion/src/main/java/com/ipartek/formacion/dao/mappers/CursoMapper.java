package com.ipartek.formacion.dao.mappers;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dao.persistence.Curso;

public class CursoMapper implements RowMapper<Curso> {

	@Override
	public Curso mapRow(ResultSet rS, int arg1) throws SQLException {
		Curso curso=null;
		curso=new Curso();
		curso.setCodCurso(rS.getInt("codCurso"));
		curso.setNombreCurso(rS.getString("nombreCurso"));
		curso.setCodPatrocinador(rS.getString("codPatrocinador"));
		curso.setTipoCurso(rS.getInt("tipoCurso"));
		return curso;
	}

}
