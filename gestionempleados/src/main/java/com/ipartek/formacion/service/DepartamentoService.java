package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Departamento;

public interface DepartamentoService {
	
	public Departamento createDepartamento(Departamento departamento);
	
	public Departamento getById(int codigo);
	
	public void delete(int codigo);
	
	public List<Departamento> getAll();
	
	public Departamento update(Departamento departamento);

}
