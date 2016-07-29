package com.ipartek.formacion.dbms.DAO;

import java.util.List;

import com.ipartek.formacion.pojo.Empleado;

public interface EmpleadoDAO {

	public Empleado update(Empleado empleado);

	public Empleado insert(Empleado empleado);

	public Empleado getByID(int codigo);

	public void delete(int codigo);

	public List<Empleado> getAll();
}
