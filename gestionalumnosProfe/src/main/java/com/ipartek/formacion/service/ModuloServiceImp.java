package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.interfaces.ModuloDAO;
import com.ipartek.formacion.dao.persistence.Modulo;
import com.ipartek.formacion.service.interfaces.ModuloService;
@Service
public class ModuloServiceImp implements ModuloService {
	@Autowired
	ModuloDAO mDAO;
	@Override
	public List<Modulo> getAll() {
		List<Modulo> modulos=null;
		modulos=mDAO.getAll();
		return modulos;
	}

	@Override
	public Modulo getById(int id) {
		// TODO Auto-generated method stub
		return mDAO.getById(id);
	}

	@Override
	public Modulo update(Modulo modulo) {
	
		return mDAO.update(modulo);
	}

	@Override
	public void delete(int id) {
		mDAO.delete(id);

	}

	@Override
	public Modulo create(Modulo modulo) {
		
		return mDAO.create(modulo);
	}

}
