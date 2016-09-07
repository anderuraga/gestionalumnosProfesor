package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.dao.ModuloDAOImp;
import com.ipartek.formacion.dao.persistencia.Modulo;

public interface ModuloService {
	public List<Modulo>getAll();
	public void setModuloDAO(ModuloDAOImp moduloDAO);
	public Modulo getById(int id);
	public Modulo update(Modulo modulo);
	public void delete(int id);
	public Modulo create(Modulo modulo);
}
