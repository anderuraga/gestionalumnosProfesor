package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.ModuloDAOImp;
import com.ipartek.formacion.dao.interfaces.AlumnoDAO;
import com.ipartek.formacion.dao.interfaces.ModuloDAO;
import com.ipartek.formacion.dao.persistencia.Alumno;
import com.ipartek.formacion.dao.persistencia.Modulo;
import com.ipartek.formacion.service.interfaces.ModuloService;
@Service
public class ModuloServiceImp implements ModuloService {
	
	@Autowired
	ModuloDAO moduloDAO;
	
	@Override
	public List<Modulo> getAll() {
		List<Modulo>modulos=null;
		modulos=moduloDAO.getAll();
		return modulos;
	}

	@Override
	public void setModuloDAO(ModuloDAOImp modulDAO) {
		this.moduloDAO=modulDAO;
		
	}

	@Override
	public Modulo getByid(int id) {
		Modulo modulo=null;
		modulo=moduloDAO.getByid(id);
		return modulo;
	}

	@Override
	public Modulo update(Modulo modulo) {
		Modulo mod=moduloDAO.update(modulo);
		return mod;
	}

	@Override
	public void delete(int id) {
		moduloDAO.delete(id);
		
	}

	@Override
	public Modulo create(Modulo modulo) {
		return moduloDAO.create(modulo);
	}

}
