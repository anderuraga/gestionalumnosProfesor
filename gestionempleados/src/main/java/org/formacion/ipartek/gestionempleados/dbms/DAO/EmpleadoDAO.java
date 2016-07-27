package org.formacion.ipartek.gestionempleados.dbms.DAO;

import org.formacion.ipartek.gestionempleados.pojo.Empleado;

public interface EmpleadoDAO {

	public Empleado update(Empleado empleado);

	public Empleado getByID(int codigo);
}
