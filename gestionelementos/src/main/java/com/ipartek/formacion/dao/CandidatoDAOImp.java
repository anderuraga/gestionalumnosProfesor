package com.ipartek.formacion.dao;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dao.interfaces.CandidatoDAO;
import com.ipartek.formacion.dao.mappers.CandidatoMapper;
import com.ipartek.formacion.dao.persistence.Candidato;

@Repository
public class CandidatoDAOImp implements CandidatoDAO {
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
			candidatos = jdbctemplate.queryForObject(SQL, new Object[] { id }, new CandidatoMapper());
		} catch (EmptyResultDataAccessException e) {
			candidatos = new Candidato();
		}
		return candidatos;
	}

	@Override
	public Candidato update(Candidato candidato) {
		Candidato candidatos = null;
		final String SQL = "UPDATE candidato SET(nombreCandidato = ?,apellidosCandidato = ?) WHERE codigoCandidato= ?";
		jdbctemplate.update(SQL, candidatos.getNombre(), candidatos.getApellidos(), candidatos.getCodigo());
		return candidatos;
	}

	@Override
	public Candidato create(Candidato candidato) {
		Candidato candidatos = null;
		final String SQL = "INSERT candidatos(codigoCandidato,nombreCandidato,apellidosCandidato) values(?,?,?)";
		jdbctemplate.update(SQL, candidatos.getNombre(), candidatos.getApellidos(), candidatos.getCodigo());
		return candidatos;
	}

	@Override
	public void delete(int id) {
		final String SQL = "DELETE FROM candidatos WHERE codigoCandidato= ?";
		jdbctemplate.update(SQL, new Object[] { id });
	}

}
