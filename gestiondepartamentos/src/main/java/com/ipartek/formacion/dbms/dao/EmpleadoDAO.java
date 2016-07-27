package com.ipartek.formacion.dbms.dao;

import java.util.List;

import com.ipartek.formacion.pojo.Empleado;

/**
 * 
 * @author Curso
 *
 */
public interface EmpleadoDAO {

	 /**
	   * 
	   * @param departamento
	   *          Departamento
	   * @return departamento
	   */
	  public Empleado CreateEmpleado(Empleado empleado);

	  /**
	   * 
	   * @return lista de departamento
	   */
	  public List<Empleado> getAll();
	  
	  /**
	   * 
	   * @param departamento
	   *          Departamento
	   * @return departamento
	   */
	  public Empleado UpdateEmpleado(Empleado empleado);
	  
	  /**
	   * 
	   * @param departamento
	   *          int
	   */
	  public void DeleteEmpleado(int empleado);

	  
	  /**
	   * 
	   * @param codigo
	   *          int
	   * @return departamento
	   */
	  public Empleado getById(int empleado);
}