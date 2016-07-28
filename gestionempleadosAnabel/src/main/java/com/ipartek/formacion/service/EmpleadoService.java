package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Empleado;

/**
 * Interfaz encargada de definir los metodos que definen la logica de la aplicacion, con respecto a
 * los empleados. Estas funcionalidades van a ser:
 * <ul>
 * <li>Crear un nuevo registro de empleado</li>
 * <li>Borrar un registro existente de empleado</li>
 * <li>Modificar un registro existente de un empleado</li>
 * <li>Obtener los datos de un empleado</li>
 * <li>Obtener un listado con todos los datos de los distintos empleados</li>
 * </ul>
 * 
 * @author Anabel
 *
 */
public interface EmpleadoService {

  /**
   * Metodo encargado de proporcionarle los datos a la capa Modelo para crear un registro de
   * empleado.
   * 
   * @param empleado
   *          <code>Empleado</code> objeto de tipo empleado con los datos para su registro.
   * @return empleado <code>Empleado</code> objeto de tipo empleado con los datos que se han
   *         registrado.
   */
  public Empleado create(Empleado empleado);

  /**
   * Metodo encargado de proporcionar la id a la campa modelo para borrar un registro.
   * 
   * @param codigo
   *          <code>int</code> codigo del empleado que se quiere borrar.
   */
  public void delete(int codigo);

  /**
   * Meotod encargado de proporcionar los datos que se quieren modificar de un registro de empleado.
   * 
   * @param empleado
   *          <code>Empleado</code> objeto de tipo empleado con los datos que se quieren modificar.
   * @return empleado <code>Empleado</code> objeto de tipo empleado con los datos que se han
   *         modificado.
   */
  public Empleado update(Empleado empleado);

  /**
   * Metodo encargado de obtener un empleado en concreto.
   * 
   * @param codigo
   *          <code>int</code> codigo del empleado que del cual se quieren obtener sus datos.
   * @return empleado <code>Empleado</code> objeto del tipo empleado con los datos que se quieren
   *         obtener.
   */
  public Empleado getById(int codigo);

  /**
   * Metodo encargado de obtener el listado de empleados.
   * 
   * @return empleados <code>List<Empleado></code> objeto de tipo lista empleado, con todos los
   *         datos de los empleados.
   */
  public List<Empleado> getAll();
}
