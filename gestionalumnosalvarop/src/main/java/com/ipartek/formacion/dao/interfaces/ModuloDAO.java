package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.ModuloDAOImp;
import com.ipartek.formacion.dao.persistencia.Modulo;


public interface ModuloDAO {

	
	public List<Modulo>getAll();
	public Modulo getByid(int id);
	public Modulo create(Modulo modulo);
	public void delete(int id);
	public Modulo update(Modulo modulo);
	public void setModuloDAO(ModuloDAOImp modulDAO);
}
