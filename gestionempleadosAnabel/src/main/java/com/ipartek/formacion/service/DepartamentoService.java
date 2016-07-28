package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Departamento;

/**
 * Interfaz encarga de definir los metodos funcionales que va a poder realizar el usuario en los
 * registros de departamento. Estos son:
 * <ul>
 * <li>Crear un nuevo registro de departamento</li>
 * <li>Borrar un registro existente de departamento</li>
 * <li>Modificar un registro existente de un departamento</li>
 * <li>Obtener los datos de un departamento</li>
 * <li>Obtener un listado con todos los datos de los distintos departamentos</li>
 * </ul>
 * 
 * @author Anabel
 *
 */
public interface DepartamentoService {

  /**
   * Metodo que se encarga de hacer la logica, para que se pueda realizar un registro en la BB.DD.
   * 
   * @param departamento
   *          <code>Departamento</code> objeto de tipo departamento que proviene de la capa
   *          controler, para realizar un registro de la BB.DD.
   * @return departamento <code>Departamento</code> objeto de tipo departamento que se ha insertado
   *         en la BB.DD.
   */
  public Departamento create(Departamento departamento);

  /**
   * Metodo encargado de realizar la logica, para que se pueda borrar un registro en la BB.DD. Va ha
   * realizar un acceso entre los datos proporcionados por el usuario y los datos de la BB.DD.
   * 
   * @param codigo
   *          <code>int</code> codigo del registro de departamento que quiere ser eliminado.
   */
  public void delete(int codigo);

  /**
   * Metodo encargado de realizar la logica, para que se pueda modificar un registro en la BB.DD.
   * 
   * @param departamento
   *          <code>Departamento</code> objeto de tipo departamento, que contiene los datos que se
   *          quieren modificar.
   * @return departamento <code>Departamento</code> objeto de tipo departamento, que contiene los
   *         datos que se han modificado.
   */
  public Departamento update(Departamento departamento);

  /**
   * Metodo encargado de realizar la logica, para poder obtener un registro de departamento.
   * 
   * @param codigo
   *          <code>int</code> codigo del departamento que se quiere obtener.
   * @return departamento <code>Departamento</code> objeto de tipo departamento con los datos que
   *         queriamos obtener.
   */
  public Departamento getById(int codigo);

  /**
   * Metodo encargado de realizar la logica, para poder obtener un listado con todos los
   * departamentos.
   * 
   * @return departamentos <code>List<Departamento></code> listado con todos los objetos de
   *         departamento.
   */
  public List<Departamento> getAll();
}
