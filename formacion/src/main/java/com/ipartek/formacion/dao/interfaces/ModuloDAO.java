package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistence.Modulo;

public interface ModuloDAO {

	public List<Modulo> getAll();
	public Modulo getById(int id);
	public void delete(int id);
	public Modulo update(Modulo m);
	public Modulo create(Modulo m);
	
}
