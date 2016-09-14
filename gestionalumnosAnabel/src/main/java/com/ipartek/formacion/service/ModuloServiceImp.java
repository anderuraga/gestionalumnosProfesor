package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.ModuloDAOImp;
import com.ipartek.formacion.dao.interfaces.ModuloDAO;
import com.ipartek.formacion.dao.persistencia.Modulo;
import com.ipartek.formacion.service.interfaces.ModuloService;

@Service
public class ModuloServiceImp implements ModuloService {

	@Autowired
	private ModuloDAO moduloDAO;

	@Override
	public Modulo create(Modulo modulo) {
		this.moduloDAO.create(modulo);
		return modulo;
	}

	@Override
	public void delete(int id) {

		this.moduloDAO.delete(id);
	}

	@Override
	public Modulo update(Modulo modulo) {

		return this.moduloDAO.update(modulo);
	}

	@Override
	public Modulo getById(int id) {

		return this.moduloDAO.getById(id);
	}

	@Override
	public List<Modulo> getAll() {

		return this.moduloDAO.getAll();
	}

	@Autowired
	@Override
	public void setModuloDAO(ModuloDAOImp moduloDAO) {

		this.moduloDAO = moduloDAO;
	}

}
