package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Departamento;

public interface DepartamentoService {

	 /**
	   * 
	   * @param departamento
	   *          Departamento
	   * @return departamento
	   */
	  public Departamento CreateDepartamento(Departamento departamento);

	  /**
	   * 
	   * @return lista de departamentos
	   */
	  public List<Departamento> getAll();
	  
	  /**
	   * 
	   * @param departamento
	   *          Departamento
	   * @return departamento
	   */
	  public Departamento UpdateDepartamento(Departamento departamento);
	  
	  /**
	   * 
	   * @param departamento
	   *          int
	   */
	  public void DeleteDepartamento(int departamento);

	  
	  /**
	   * 
	   * @param codigo
	   *          int
	   * @return departamento
	   */
	  public Departamento getById(int departamento);

}

	