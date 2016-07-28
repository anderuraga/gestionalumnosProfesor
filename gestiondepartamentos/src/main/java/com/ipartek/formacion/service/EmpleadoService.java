package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Departamento;
import com.ipartek.formacion.pojo.Empleado;

public interface EmpleadoService {

	 /**
	   * 
	   * @param departamento
	   *          Departamento
	   * @return departamento
	   */
	  public Empleado CreateEmpleado(Empleado empleado);

	  /**
	   * 
	   * @return lista de departamentos
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

	