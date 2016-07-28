package com.ipartek.formacion.empleado.ProyectoGestionEmpleado.service;

import java.util.List;

import com.ipartek.formacion.empleado.ProyectoGestionEmpleado.pojo.Empleado;

public interface EmpleadoService {

	public Empleado createEmpleado(Empleado emple);
	
	public Empleado getById(int id);
	
	public void delete(int id);
	
	public List<Empleado> getAll();
	
	public Empleado update(Empleado emple);
	
}
