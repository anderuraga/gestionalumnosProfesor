package com.ipartek.formacion.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dao.persistencia.Candidato;

public class CandidatoMapper implements RowMapper<Candidato> {

	@Override
	public Candidato mapRow(ResultSet rs, int arg1) throws SQLException {
		Candidato candidato = null;
		candidato = new Candidato();
		/* GETTERS Y SETTERS */
		candidato.setCodigo(rs.getInt("codigoCandidato"));
		candidato.setNombre(rs.getString("nombreCandidato"));
		candidato.setApellidos(rs.getString("apellidosCandidato"));

		return candidato;
	}
}
