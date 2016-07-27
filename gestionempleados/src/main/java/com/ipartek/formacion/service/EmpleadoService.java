package com.ipartek.formacion.service;


import java.util.List;

/**
 * Este interfaz define los métodos de acceso a Base de Datos para los empleados:
 * 
 * <ul>
 * 	<li>dar de alta empleados</li>
 * 	<li>modificar empleados</li>
 * 	<li>dar de baja empleados <code>CursoAlumno</code> </li>
 *  <li>obtener una vista en detalle de un empleado</li>
 *  <li>obtener el listado de los empleados</li>
 * </ul>
 * 
 */

import com.ipartek.formacion.pojo.Empleado;

public interface EmpleadoService {

	
	public Empleado createEmpleado(Empleado empleado);
	
	public Empleado updateEmpleado(Empleado empleado);
	
	public void deleteEmpleado (int codigo);
	
	public Empleado getById(int codigo);
	
	public List<Empleado> getAll();
}
