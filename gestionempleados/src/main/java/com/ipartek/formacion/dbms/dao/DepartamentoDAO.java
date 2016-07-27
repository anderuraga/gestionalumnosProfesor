package com.ipartek.formacion.dbms.dao;

import java.util.List;

import com.ipartek.formacion.pojo.Departamento;

public interface DepartamentoDAO {
	public Departamento getById(int codDpto);

	public Departamento updateDpto(Departamento dpto);

	public Departamento createDpto(Departamento dpto);

	public void deleteDpto(int codDpto);

	public List<Departamento> getAll();
}
