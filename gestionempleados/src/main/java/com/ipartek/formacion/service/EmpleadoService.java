package com.ipartek.formacion.service;

import java.util.List;


import com.ipartek.formacion.pojo.Empleado;

public interface EmpleadoService {
public Empleado create(Empleado empleado);
	
	public Empleado getById(int codigo);
	
	public void delete(int codigo);
	
	public List<Empleado> getAll();
	
	public Empleado update(Empleado empleado);
	
	public void darDeAlta(Empleado empleado);
	
	public void darDeBaja(Empleado empleado);
}
