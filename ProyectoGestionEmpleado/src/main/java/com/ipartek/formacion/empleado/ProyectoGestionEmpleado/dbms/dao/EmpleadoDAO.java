package com.ipartek.formacion.empleado.ProyectoGestionEmpleado.dbms.dao;

import java.util.List;

import com.ipartek.formacion.empleado.ProyectoGestionEmpleado.pojo.Empleado;

public interface EmpleadoDAO {


	public Empleado createEmpleadoDAO(Empleado emple);
	
	public Empleado getByIdDAO(int id);
	
	public void deleteDAO(int id);
	
	public List<Empleado> getAllDAO();
	
	public Empleado updateDAO(Empleado emple);
}
