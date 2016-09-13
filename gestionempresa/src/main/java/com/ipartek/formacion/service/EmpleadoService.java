/**
 * 
 */
package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Empleado;

/**
 * @author Curso
 *
 */
public interface EmpleadoService {

	public Empleado getById(int codigo);
	public Empleado updateEmpleado(Empleado emp);
	public void deleteEmpleado(int codigo);
	public Empleado createEmpleado(Empleado emp);
	public List<Empleado> getAll();
	public Empleado trasladarEmpleado(Empleado emp, int codigo);
}
