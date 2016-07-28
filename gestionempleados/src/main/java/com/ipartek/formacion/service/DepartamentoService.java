package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Departamento;

/**
 * Interfaz que gestiona el comportamiento de la lista de la clase Departamento, en la que se crea, se borra, se actualiza
 * y se busca.
 * 
 * @author Curso
 *
 */

public interface DepartamentoService {
	
	/**
	 * 
	 * Método que crea un departamento 
	 * <code>Departamento</code>
	 * @param departamento
	 * @return <code>Departamento</code>
	 */
	
	public Departamento createDepartamento(Departamento departamento);
	
	/**
	 *  Método que busca un departamento
	 * @param codigo
	 * @return <code>Departamento</code>
	 */
	
	public Departamento getById(int codigo);
	
	/**
	 *  Método que borra un departamento
	 * @param codigo
	 */
	
	public void delete(int codigo);
	
	/**
	 * Método que devuelve una lista con todos los registros 
	 * 	 
	 * * @return <code>List<Departamento></code>
	 */
	
	public List<Departamento> getAll();
	
	/**
	 * Método que actualiza todo un departamento 
	 * <code>Departamento</code>
	 * @param departamento
	 * @return <code>Departamento</code>
	 */
	
	public Departamento update(Departamento departamento);

}
