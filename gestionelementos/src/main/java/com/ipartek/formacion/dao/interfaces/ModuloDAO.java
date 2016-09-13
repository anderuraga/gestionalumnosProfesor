package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import javax.sql.DataSource;

import com.ipartek.formacion.dao.persistencia.Modulo;

/**
 * @author Erasmo
 */
public interface ModuloDAO extends DAOSetter {
	public List<Modulo> getAll();

	public Modulo getById(int id);

	public Modulo create(Modulo modulo);

	public Modulo update(Modulo modulo);

	public void delete(int d);

	void setDataSource(DataSource dataSource);
}
