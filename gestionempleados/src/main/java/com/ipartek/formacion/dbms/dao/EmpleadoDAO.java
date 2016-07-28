package com.ipartek.formacion.dbms.dao;

import java.util.List;

import com.ipartek.formacion.pojo.Empleado;

/**
 * 
 * Interfaz que define los metodos de consulta a Base de Datos de la clase <code>Empleado</code>.
 * @author Curso
 *
 */
public interface EmpleadoDAO {
	
	
	/**
	   * Búsqueda de un empleado por el 	  
	   * @param codigoCurso
	   *          <code>int</code> el codigo del empleado.
	   * @return <code>Empleado</code> devuelve la instancia del Empleado.
	   */
	public Empleado getById(int codigo);

	 /**
	   * Metodo que se encarga de actualizar los datos del Empleado  
	   * @param empleado
	   * 	<code>Empleado</code> 
	   * @return <code>Empleado</code> devuelve la instancia del empleado.
	   */	
	public Empleado update(Empleado empleado);

	/**
	   * Metodo encargado de dar alta empleados en la Base de Datos.
	   *
	   * @param empleado
	   *          <code>Empleado</code> En este objeto se encapsulan los datos del empleado,
	   *          
	   * @return <code>Empleado</code>.
	   */
	public Empleado create(Empleado empleado);
	
	 /**
	   * Metodo que se encarga de borrar un empleado  
	   * @param codigoCurso
	   *          <code>int</code> el codigo del empleado.
	   * 
	   */
	public void delete(int codigo);
	
	 /**
	   * Metodo que se devuelve la lista completa de los datos del empleado  
	   *
	   * @return <code>List<Empleado></code> devuelve la 
	   * lista completa con todos los datos de cada empleado.
	   * 
	   */	
	public List<Empleado> getAll();
}
