package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.ModuloDAOImp;
import com.ipartek.formacion.dao.interfaces.ModuloDAO;
import com.ipartek.formacion.dao.persistence.Alumno;
import com.ipartek.formacion.dao.persistence.Modulo;
import com.ipartek.formacion.service.interfaces.ModuloService;

@Service
public class ModuloServiceImp implements ModuloService {

	@Autowired
	ModuloDAO modulDAO;
	
	@Override
	public List<Modulo> getAll() {
		List<Modulo> modulos = null;
		modulos = modulDAO.getAll();
		return modulos;
	}

	@Override
	public void setModulDAO(ModuloDAOImp modulDAO) {
		this.modulDAO = modulDAO;
	}

	@Override
	public Modulo getById(int id) {
		Modulo modulo = modulDAO.getById(id);
		return modulo;
	}

	@Override
	public Modulo update(Modulo modulo) {
		Modulo modul = modulDAO.update(modulo);
		return modul;
	}

	@Override
	public void delete(int id) {
		modulDAO.delete(id);
	}
	
	@Override
	public Modulo create(Modulo modulo) {
		return modulDAO.create(modulo);
	}
}
