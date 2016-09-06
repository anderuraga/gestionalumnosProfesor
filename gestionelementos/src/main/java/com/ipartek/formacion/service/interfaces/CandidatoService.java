package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.CandidatoDAOImp;
import com.ipartek.formacion.dao.persistence.Candidato;

/**
 * @author Erasmo
 */
public interface CandidatoService {
	public List<Candidato> getAll();

	public Candidato getById(int id);

	public Candidato create(Candidato candidato);

	public Candidato update(Candidato candidato);

	public void delete(int id);

	void setCandDAO(CandidatoDAOImp candDAO);
}
