package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.ModuloDAOImp;
import com.ipartek.formacion.dao.persistence.Modulo;
import com.ipartek.formacion.service.interfaces.ModuloService;

@Service
public class ModulosServiceImp implements ModuloService{

	@Autowired
	ModuloDAOImp mDAO;
	
	
	public void setMDAO(ModuloDAOImp mDAO) {
		this.mDAO = mDAO;
	}

	@Override
	public List<Modulo> getAll() {
		List<Modulo>modulos=mDAO.getAll();
		return modulos;
	}

	@Override
	public Modulo getById(int id) {
		Modulo modulo=mDAO.getById(id);
		return modulo;
	}

	@Override
	public Modulo update(Modulo m) {
		Modulo modulo=mDAO.update(m);
		return modulo;
	}

	@Override
	public void delete(int id) {
		mDAO.delete(id);
		
	}

	@Override
	public Modulo create(Modulo m) {
		Modulo modulo=mDAO.create(m);
		
		return modulo;
	}

}
