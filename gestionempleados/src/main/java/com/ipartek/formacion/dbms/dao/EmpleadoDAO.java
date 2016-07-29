package com.ipartek.formacion.dbms.dao;

import java.util.List;

import com.ipartek.formacion.dbms.dao.exceptions.EmpleadoDAOImpException;
import com.ipartek.formacion.pojo.Empleado;

public interface EmpleadoDAO {
	
	public Empleado getById(int codigo);
	
	public Empleado update(Empleado empleado);
	
	public Empleado insert(Empleado empleado) throws EmpleadoDAOImpException;
	
	public void delete(int codigo);
	
	public List<Empleado> getAll();
	
}
