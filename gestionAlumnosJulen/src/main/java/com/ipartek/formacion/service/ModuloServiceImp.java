package com.ipartek.formacion.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.controller.ModuloController;
import com.ipartek.formacion.dao.interfaces.ModuloDAO;
import com.ipartek.formacion.dao.persistence.Modulo;
import com.ipartek.formacion.service.interfaces.ModuloService;
@Service
public class ModuloServiceImp implements ModuloService{

	private static final Logger logger = LoggerFactory.getLogger(ModuloServiceImp.class);

	
	@Autowired
	ModuloDAO moduloDAO;
	
	public void setModuloDAO(ModuloDAO moduloDAO) {
		this.moduloDAO = moduloDAO;
	}

	@Override
	public List<Modulo> getAll() {

		List<Modulo> modulos = null;
		
		modulos = moduloDAO.getAll();
		return modulos;
	}

	@Override
	public Modulo getById(int id) {
		// TODO Auto-generated method stub
		return moduloDAO.getById(id);
	}

	@Override
	public Modulo update(Modulo modulo) {
		// TODO Auto-generated method stub
		return moduloDAO.update(modulo);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		moduloDAO.delete(id);
	}

	@Override
	public Modulo create(Modulo modulo) {
		// TODO Auto-generated method stub
		return moduloDAO.create(modulo);
	}

}
