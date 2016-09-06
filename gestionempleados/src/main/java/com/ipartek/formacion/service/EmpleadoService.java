package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.dbms.dao.exceptions.EmpleadoDAOImpException;
import com.ipartek.formacion.pojo.Empleado;

/**
 * Interface de Empleado, con operaciones CRUD
 */

public interface EmpleadoService {
	
	public Empleado insert(Empleado empleado) throws EmpleadoDAOImpException;
	
	public Empleado getById(int codigo);
	
	public void delete(int codigo);
	
	public List<Empleado> getAll();
	
	public Empleado update(Empleado empleado);
	
}
