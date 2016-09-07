package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipartek.formacion.dao.ModuloDAOImp;
import com.ipartek.formacion.dao.interfaces.ModuloDAO;
import com.ipartek.formacion.dao.persistencia.Alumno;
import com.ipartek.formacion.dao.persistencia.Modulo;
import com.ipartek.formacion.service.interfaces.ModuloService;

public class ModuloServiceImp implements ModuloService{

	@Autowired 
	ModuloDAO modDAO;
	
	@Override
	public List<Modulo> getAll() {
		List<Modulo> modulos = null;
		modulos = modDAO.getAll();
		return modulos;
	}

	@Override
	public Modulo getById(int id) {
		Modulo modulo = null;
		modulo = modDAO.getById(id);
		
		return modulo;
	}

	@Override
	public void delete(int id) {
		modDAO.delete(id);
		
	}

	@Override
	public Modulo create(Modulo modulo) {
		modDAO.create(modulo);
		
		return modulo;
	}


	@Override
	public void setModDAO(ModuloDAOImp modDAO) {
		this.modDAO = modDAO;
		
	}

	@Override
	public Modulo update(Modulo modulo) {
		Modulo mod = modDAO.update(modulo);
		
		return mod;
	}

}
