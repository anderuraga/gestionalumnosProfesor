package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.CandidatoDAOImp;
import com.ipartek.formacion.dao.interfaces.CandidatoDAO;
import com.ipartek.formacion.dao.persistence.Candidato;
import com.ipartek.formacion.service.interfaces.CandidatoService;

@Service
public class CandidatosServiceImp implements CandidatoService {
	@Autowired
	CandidatoDAO candDAO;

	@Override
	public List<Candidato> getAll() {
		List<Candidato> candidatos = null;
		candidatos = candDAO.getAll();
		return candidatos;
	}

//	@Override
//	public void setCandDAO(CandidatoDAOImp candDAO) {
//		this.candDAO = candDAO;
//	}

	@Override
	public Candidato getById(int id) {
		return candDAO.getById(id);
	}

	@Override
	public Candidato update(Candidato candidato) {
		return candDAO.update(candidato);
	}

	@Override
	public Candidato create(Candidato candidato) {
		return candDAO.create(candidato);

	}

	@Override
	public void delete(int id) {
		candDAO.delete(id);
	}

	@Override
	public void setCandidatoDAO(CandidatoDAOImp candDAO) {
		// TODO Auto-generated method stub
		
	}
}
