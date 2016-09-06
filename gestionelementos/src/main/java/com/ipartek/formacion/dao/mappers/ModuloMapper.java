package com.ipartek.formacion.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.ipartek.formacion.dao.persistence.Modulo;

public class ModuloMapper implements RowMapper<Modulo> {

	@Override
	public Modulo mapRow(ResultSet rs, int arg1) throws SQLException {
		Modulo modulo = null;
		modulo = new Modulo();
		/* GETTERS Y SETTERS */
		modulo.setCodigo(rs.getInt("codigoModulo"));
		modulo.setNombre(rs.getString("nombreModulo"));

		return modulo;
	}
}
