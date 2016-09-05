package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import javax.sql.DataSource;

import com.ipartek.formacion.dao.persistence.Modulo;

public interface ModuloDAO extends DAOSetter {
	List<Modulo> getAll();
	Modulo getById(int id);
	Modulo create(Modulo modulo);
	Modulo update(Modulo modulo);
	void delete(int d);
	void setDataSource(DataSource dataSource);
}
