package com.ipartek.formacion.dbms.dao;

import java.util.List;

import com.ipartek.formacion.pojo.Empleado;

public interface EmpleadoDAO {
	public Empleado getById(int codEmple);

	public Empleado updateEmple(Empleado emple);

	public Empleado createEmple(Empleado emple);

	public void deleteEmple(int codEmple);

	public List<Empleado> getAll();
}
