package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.ModuloDAOImp;
import com.ipartek.formacion.dao.interfaces.ModuloDAO;
import com.ipartek.formacion.dao.persistence.Modulo;
import com.ipartek.formacion.service.interfaces.ModuloService;

@Service
public class ModuloServiceImp implements ModuloService {

	@Autowired
	ModuloDAO modDAO;

	@Override
	public List<Modulo> getAll() {
		List<Modulo> modulos = null;
		modulos = modDAO.getAll();
		return modulos;
	}

	@Override
	public Modulo getByID(int id) {
		Modulo modulo = modDAO.getByID(id);
		return modulo;
	}

	@Override
	public Modulo update(Modulo modulo) {
		Modulo mod = modDAO.update(modulo);
		return mod;
	}

	@Override
	public void delete(int id) {
		modDAO.delete(id);

	}

	@Override
	public void setModDAO(ModuloDAOImp modDAO) {
		this.modDAO = modDAO;

	}

	@Override
	public Modulo create(Modulo modulo) {
		
		return modDAO.create(modulo);
	}

}
