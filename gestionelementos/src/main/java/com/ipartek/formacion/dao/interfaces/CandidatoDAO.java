package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import javax.sql.DataSource;

import com.ipartek.formacion.dao.persistencia.Candidato;

/**
 * @author Erasmo
 */
public interface CandidatoDAO extends DAOSetter {
	public List<Candidato> getAll();

	public Candidato getById(int id);

	public Candidato create(Candidato candidato);

	public Candidato update(Candidato candidato);

	public void delete(int d);

	void setDataSource(DataSource dataSource);
}
