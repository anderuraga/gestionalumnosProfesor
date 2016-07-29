package com.ipartek.formacion.dbms.DAO;

import java.util.List;

import com.ipartek.formacion.pojo.Departamento;

public interface DepartamentoDAO {

	public Departamento update(Departamento departamento);

	public Departamento insert(Departamento departamento);

	public Departamento getByID(int codigo);

	public void delete(int codigo);

	public List<Departamento> getAll();

}
