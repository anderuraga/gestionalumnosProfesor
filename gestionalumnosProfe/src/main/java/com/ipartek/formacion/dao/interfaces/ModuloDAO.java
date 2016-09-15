package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistence.Modulo;

public interface ModuloDAO extends DAOSetter{
	public List<Modulo> getAll();
	public Modulo getById(int id);

	public Modulo create(Modulo modulo);

	public void delete(int id);

	public Modulo update(Modulo modulo);
}
