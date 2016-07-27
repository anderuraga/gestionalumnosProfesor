package com.ipartek.formacion.dbms.DAO;

import com.ipartek.formacion.pojo.Empleado;

public interface EmpleadoDAO {

	public Empleado update(Empleado empleado);

	public Empleado getByID(int codigo);
}
