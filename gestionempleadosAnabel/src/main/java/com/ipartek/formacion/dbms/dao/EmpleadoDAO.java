package com.ipartek.formacion.dbms.dao;

import java.util.List;

import com.ipartek.formacion.pojo.Empleado;

/**
 * Interfaz que define los metodos de las consultas a la BB.DD de la clase empleado. Se va a
 * encargar de:
 * <ul>
 * <li>Crear un registro de empleado en la BB.DD.</li>
 * <li>Borrar un registro de empleado de la BB.DD.</li>
 * <li>Modificar un registro de empleado de la BB.DD.</li>
 * <li>Obtener los datos de un empleado</li>
 * <li>Obtener un listado de datos de los empleados que se encuentran en la BB.DD.</li>
 * </ul>
 * 
 * @author Anabel
 *
 */
public interface EmpleadoDAO {

  /**
   * Metodo que se encarga de crear un registro de empleado en la BB.DD.
   * 
   * @param empleado
   *          <code>Empleado</code> objeto empleado que quiere guardarse en la BB.DD.
   * @return empl <code>Empleado</code> objeto empleado que se a guardado en la BB.DD.
   */
  public Empleado create(Empleado empleado);

  /**
   * Metodo que se encarga del borrado de un registro de un empleado en la BB.DD.
   * 
   * @param codigo
   *          <code>int</code> codigo del empleado que se quiere eliminar de la BB.DD.
   */
  public void delete(int codigo);

  /**
   * Metodo encargado de la modificacion de un registro de empleado.
   * 
   * @param empleado
   *          <code>Empleado</code> objeto empleado con los datos que se quieren moficar.
   * @return empl <code>Empleado</code> objeto empleado con los datos modificados.
   */
  public Empleado update(Empleado empleado);

  /**
   * Metodo encargado de obtener los datos de un empleado de la BB.DD.
   * 
   * @param codigo
   *          <code>int</code> codigo del empleado que queremos obtener
   * @return empleado <code>Empleado</code> objeto con los datos obtenidos de la BB.DD.
   */
  public Empleado getById(int codigo);

  /**
   * Metodo encargado de obtener todos los datos de todos los empleados de la BB.DD.
   * 
   * @return empleados <code>List<Empleado></code> listado con todos los empleados registrados en la
   *         BB.DD.
   */
  public List<Empleado> getAll();
}
