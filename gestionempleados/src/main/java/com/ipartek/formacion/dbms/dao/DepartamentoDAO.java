package com.ipartek.formacion.dbms.dao;

import java.util.List;

import com.ipartek.formacion.pojo.Departamento;

public interface DepartamentoDAO {
	
	public Departamento getById(int codigo);

	public Departamento update(Departamento departamento);

	public Departamento create(Departamento departamento);

	public void delete(int codigo);

	public List<Departamento> getAll();

}
