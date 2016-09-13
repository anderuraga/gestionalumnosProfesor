package com.ipartek.formacion.dao.mappers;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dao.persistence.Modulo;

public class ModuloMapper implements RowMapper<Modulo> {

	@Override
	public Modulo mapRow(ResultSet rS, int arg1) throws SQLException {
		Modulo modulo=null;
		modulo=new Modulo();
		modulo.setCodModulo(rS.getInt("codModulo"));
		modulo.setNombreModulo(rS.getString("nombreModulo"));
		modulo.setuFormativa(rS.getString("uFormativa"));
		modulo.setDuracion(rS.getInt("durModulo"));
		return modulo;
	}

}
