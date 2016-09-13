package com.ipartek.formacion.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dao.interfaces.CandidatoDAO;
import com.ipartek.formacion.dao.mappers.CandidatoMapper;
import com.ipartek.formacion.dao.persistencia.Alumno;
import com.ipartek.formacion.dao.persistencia.Candidato;

@Repository
public class CandidatoDAOImp implements CandidatoDAO {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(dataSource);
		this.jdbcCall = new SimpleJdbcCall(dataSource);
	}

	@Override
	public List<Candidato> getAll() {
		List<Candidato> candidatos = null;
		final String SQL = "SELECT codigoCandidato,nombreCandidato,apellidosCandidato FROM candidato";
		try {
			candidatos = jdbctemplate.query(SQL, new CandidatoMapper());
		} catch (EmptyResultDataAccessException e) {
			candidatos = new ArrayList<Candidato>();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return candidatos;
	}

	@Override
	public Candidato getById(int id) {
		Candidato candidatos = null;
		final String SQL = "SELECT codigoCandidato,nombreCandidato,apellidosCandidato from candidato Where codigoCandidato =?";
		try {
			candidatos = jdbctemplate.queryForObject(SQL, new Object[] { id },
					new CandidatoMapper());
		} catch (EmptyResultDataAccessException e) {
			candidatos = new Candidato();
		}
		return candidatos;
	}

	@Override
	public Candidato update(Candidato candidato) {
		Candidato candidatos = null;
		final String SQL = "UPDATE candidato SET(nombreCandidato = ?, apellidosCandidato = ?) WHERE codigoCandidato = ?";
		jdbctemplate.update(SQL, candidato.getNombre(),
				candidato.getApellidos(), candidato.getCodigo());
		return candidatos;
	}

	@Override
	public Candidato create(Candidato candidato) {
		/*
		 * insertCandidato --> Es el nombre del procedimiento almacenado
		 */
		this.jdbcCall = new SimpleJdbcCall(dataSource)
				.withProcedureName("createCandidato");

		/*
		 * SqlParameterSource es la clase de tipo Map en la cual se guardan los
		 * parametros del procedimiento almacenado
		 */
		SqlParameterSource in = new MapSqlParameterSource().addValue("nombreCandidato",
				candidato.getNombre()).addValue("apellidosCandidato",
				candidato.getApellidos());

		/*
		 * execute ejecuta el Procedimiento almacenado y out recoge los
		 * parametros OUT de Procedimiento
		 */
		Map<String, Object> out = jdbcCall.execute(in);
		/*
		 * recogemos el parametro OUT del procedimiento
		 */
		candidato.setCodigo((Integer) out.get("codigoCandidato"));
		return candidato;
	}

	@Override
	public void delete(int id) {
		final String SQL = "DELETE FROM candidatos WHERE codigoCandidato= ?";
		jdbctemplate.update(SQL, new Object[] { id });
	}

}
