package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Empleado;

/**
 * Interfaz que gestiona el comportamiento de la lista de la clase Empleado, en la que se crea, se borra, se actualiza
 * y se busca.
 * 
 * @author Curso
 *
 */
public interface EmpleadoService {
	
	/**
	 * 
	 * Método que crea un empleado 
	 * <code>Empleado</code>
	 * @param empleado
	 * @return <code>Empleado</code>
	 */
	
	public Empleado createEmpleado(Empleado empleado);
	
	/**
	 *  Método que busca un empleado
	 * @param codigo
	 * @return <code>Empleado</code>
	 */
	
	public Empleado getById(int codigo);
	
	/**
	 *  Método que borra un Empleado
	 * @param codigo
	 */
	
	public void delete(int codigo);
	
	/**
	 * Método que devuelve una lista con todos los registros 
	 * 	 
	 * * @return <code>List<Empleado></code>
	 */
	
	public List<Empleado> getAll();
	
	/**
	 * Método que actualiza los datos de un Empleado 
	 * <code>Empleado</code>
	 * @param empleado
	 * @return <code>Empleado</code>
	 */
	
	public Empleado update(Empleado empleado);

}
