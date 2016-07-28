package com.ipartek.formacion.empleado.ProyectoGestionEmpleado.service;

import java.util.List;

import com.ipartek.formacion.empleado.ProyectoGestionEmpleado.pojo.Departamento;

public interface DepartamentoService {

	
	public Departamento createDepartamento(Departamento dpto);
	
	public Departamento getById(int id);
	
	public void delete(int id);
	
	public List<Departamento> getAll();
	
	public Departamento update(Departamento dpto);
}
