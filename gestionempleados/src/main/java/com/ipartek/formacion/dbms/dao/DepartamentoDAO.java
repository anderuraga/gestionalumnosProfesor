package com.ipartek.formacion.dbms.dao;

import java.util.List;

import com.ipartek.formacion.pojo.Departamento;

/**
 * Interfaz que define los metodos de consulta a Base de Datos de la clase <code>Departamento</code>.
 *
 *
 * @author Curso.
 *
 */
public interface DepartamentoDAO {
	
	/**
	   * Búsqueda de un departamento por el 	  
	   * @param codigoCurso
	   *          <code>int</code> el codigo del departamento.
	   * @return <code>Departamento</code> devuelve la instancia del departamento.
	   */
	
	public Departamento getById(int codigo);
	
	  /**
	   * Metodo que se encarga de actualizar los datos del departamento  
	   * @param departamento
	   * 	<code>Departamento</code> 
	   * @return <code>Departamento</code> devuelve la instancia del departamento.
	   */	

	public Departamento update(Departamento departamento);
	
	/**
	   * Metodo encargado de dar alta departamentos en la Base de Datos.
	   *
	   * @param departamento
	   *          <code>Departamento</code> En este objeto se encapsulan los datos del departamento,
	   *          
	   * @return <code>Departamento</code>.
	   */

	public Departamento create(Departamento departamento);


	  /**
	   * Metodo que se encarga de borrar un departamento  
	   * @param codigoCurso
	   *          <code>int</code> el codigo del departamento.
	   * 
	   */	

	public void delete(int codigo);
	
	 /**
	   * Metodo que se devuelve la lista completa de los datos del departamento  
	   *
	   * @return <code>List<Departamento></code> devuelve la 
	   * lista completa con todos los datos de cada departamento.
	   * 
	   */	

	public List<Departamento> getAll();

}
