/**
 * 
 */
package com.ipartek.formacion.dbms.dao;

import java.util.List;

import com.ipartek.formacion.pojo.Empleado;

/**
 * @author Curso
 *
 */
public interface EmpleadoDAO {

	public Empleado getById(int codigo);
	public Empleado updateEmpleado(Empleado emp);
	public void deleteEmpleado(int codigo);
	public Empleado createEmpleado(Empleado emp);
	public List<Empleado> getAll();
	
	
}
