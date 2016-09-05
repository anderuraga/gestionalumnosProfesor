package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.ModuloDAOImp;
import com.ipartek.formacion.dao.persistence.Modulo;

public interface ModuloService {

	List<Modulo> getAll();

	Modulo getById(int id);

	Modulo create(Modulo modulo);

	Modulo update(Modulo modulo);

	void delete(int d);

	void setModuDAO(ModuloDAOImp ModuDAO);
}
