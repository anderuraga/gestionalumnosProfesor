package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Departamento;



public interface DepartamentoService {

public Departamento create(Departamento departamento);
	
	public Departamento getById(int codigo);
	
	public void delete(int codigo);
	
	public List<Departamento> getAll();
	
	public Departamento update(Departamento departamento);
	
	public void darDeAlta(Departamento departamento);
	
	public void darDeBaja(Departamento departamento);
	
	
}
