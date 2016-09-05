package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipartek.formacion.dao.ModuloDAOImp;
import com.ipartek.formacion.dao.interfaces.ModuloDAO;
import com.ipartek.formacion.dao.persistencia.Modulo;
import com.ipartek.formacion.service.interfaces.ModuloService;

public class ModuloServiceImp implements ModuloService{

	@Autowired 
	ModuloDAO modDAO;
	
	@Override
	public List<Modulo> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Modulo getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Modulo create(Modulo modulo) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setModDAO(ModuloDAOImp modDAO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Modulo update(Modulo modulo) {
		// TODO Auto-generated method stub
		return null;
	}

}
