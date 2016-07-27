package com.ipartek.formacion.dbms.dao;

import java.util.List;

import com.ipartek.formacion.pojo.Departamento;

public interface DepartamentoDAO {

	public Departamento create(Departamento departamento);
	
	public Departamento update(Departamento departamento);
	
	public void delete(int codigo);
	
	public Departamento getById(int codigo);
	
	public List<Departamento> getAll();
}
