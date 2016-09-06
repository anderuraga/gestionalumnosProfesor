package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.ModuloDAOImp;
import com.ipartek.formacion.dao.persistence.Modulo;

public interface ModuloService {
	
	public List<Modulo> getAll();
	
	public void setModulDAO(ModuloDAOImp modulDAO);
	
	public Modulo getById(int id);
	
	public Modulo update(Modulo modulo);
	
	public void delete(int id);
}
