package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistence.Modulo;

public interface ModuloDAO extends DAOSetter {

	public List<Modulo> getAll();

	public Modulo create(Modulo modulo);

	public Modulo getByID(int id);

	public Modulo update(Modulo modulo);

	public void delete(int id);

}
