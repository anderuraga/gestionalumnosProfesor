package com.ipartek.formacion.empleado.ProyectoGestionEmpleado.dbms.dao;

import java.util.List;

import com.ipartek.formacion.empleado.ProyectoGestionEmpleado.pojo.Departamento;

public interface DepartamentoDAO {
	
	public Departamento createDepartamentoDAO(Departamento dpto);
	
	public Departamento getByIdDAO(int id);
	
	public void deleteDAO(int id);
	
	public List<Departamento> getAllDAO();
	
	public Departamento updateDAO(Departamento dpto);

}
