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
	ModuloDAO moduDAO;

	@Override
	public List<Modulo> getAll() {
		List<Modulo> modulos = null;
		modulos = moduDAO.getAll();
		return modulos;
	}

	@Override
	public void setModuDAO(ModuloDAOImp moduDAO) {
		this.moduDAO = moduDAO;
	}

	@Override
	public Modulo getById(int id) {
		return moduDAO.getById(id);
	}

	@Override
	public Modulo update(Modulo modulo) {
		return moduDAO.update(modulo);
		}

	@Override
	public Modulo create(Modulo modulo) {
		return moduDAO.create(modulo);
		}

	@Override
	public void delete(int id) {
		moduDAO.delete(id);
	}

}