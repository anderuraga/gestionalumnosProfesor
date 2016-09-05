package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipartek.formacion.dao.ModuloDAOImp;
import com.ipartek.formacion.dao.interfaces.ModuloDAO;
import com.ipartek.formacion.dao.persistencia.Modulo;

public class ModuloServiceImp implements ModuloService{
	@Autowired
	ModuloDAO moduloDAO;
	@Override
	public List<Modulo> getAll() {
		List<Modulo>modulos=null;
		modulos=moduloDAO.getAll();
		return modulos;
	}

	@Override
	public void setModuloDAO(ModuloDAOImp moduloDAO) {
		this.moduloDAO=moduloDAO;
	}

	@Override
	public Modulo getById(int id) {
		Modulo modulo=moduloDAO.getById(id);
		return modulo;
	}

	@Override
	public Modulo update(Modulo modulo) {
		Modulo modu=moduloDAO.update(modulo);
		return modu;
	}

	@Override
	public void delete(int id) {
		moduloDAO.delete(id);
	}

}
