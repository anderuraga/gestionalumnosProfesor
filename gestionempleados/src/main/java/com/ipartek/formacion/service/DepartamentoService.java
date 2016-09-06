package com.ipartek.formacion.service;

import java.util.List;

/**
 * Interface de Departamento, con operaciones CRUD
 */

import com.ipartek.formacion.pojo.Departamento;

public interface DepartamentoService {
	
	public Departamento insert(Departamento departamento);
	
	public Departamento getById(int codigo);
	
	public void delete(int codigo);
	
	public List<Departamento> getAll();
	
	public Departamento update(Departamento departamento);
	
}
