package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Departamento;

public interface DepartamentoService {

	
	public Departamento createDepartamento(Departamento departamento);
	
	public Departamento updateDepartamento(Departamento departamento);
	
	public void deleteDepartamento (int codigo);
	
	public Departamento getById(int codigo);
	
	public List<Departamento> getAll();
}
