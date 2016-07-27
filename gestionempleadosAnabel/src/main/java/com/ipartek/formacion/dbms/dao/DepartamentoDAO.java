package com.ipartek.formacion.dbms.dao;

import java.util.List;

import com.ipartek.formacion.pojo.Departamento;

/**
 * Interfaz que define los metodos de conexion con la BB.DD. para la realizacion de las consultas
 * referentes a Departamento. Estas pueden ser:
 * <ul>
 * <li>Crear un registro de departamento en la BB.DD.</li>
 * <li>Borrar un registro de departamento de la BB.DD.</li>
 * <li>Modificar un registro de departamento de la BB.DD.</li>
 * <li>Obtener un registro de departamento de la BB.DD.</li>
 * <li>Obtener un listado con todos los registros de los diferentes departamentos de la BB.DD.</li>
 * </ul>
 * 
 * @author Anabel
 *
 */
public interface DepartamentoDAO {

  /**
   * Metodo que crea un registro de departamento en la BB.DD.
   * 
   * @param departamento
   *          <code>Departamento</code> objeto de tipo departamento que contiene todos los datos que
   *          se quieren crear en la BB.DD.
   * @return departamento <code>Departamento</code> objeto de tipo departamento con los datos que se
   *         han creado en la BB.DD.
   */
  public Departamento create(Departamento departamento);

  /**
   * Metodo que eliminar un registro de departamento en la BB.DD
   * 
   * @param codigo
   *          <code>int</code> codigo del registro de departamento que se quiere eliminar de la
   *          BB.DD.
   */
  public void delete(int codigo);

  /**
   * Metodo que se encarga de modificar un registro de departamento de la BB.DD.
   * 
   * @param departamento
   *          <code>Departamento</code> objeto de tipo departamento con los datos que se quieren
   *          actualizar en la BB.DD.
   * @return departamento <code>Departamento</code> objeto de tipo departamento con los datos que se
   *         han actualizado en la BB.DD.
   */
  public Departamento update(Departamento departamento);

  /**
   * Metodo que se encarga de obtener un registro de departamento de la BB.DD.
   * 
   * @param codigo
   *          <code>int</code> codigo del departamento del cual queremos obtener la informacion
   * @return empleado <code>Empleado</code> objeto de tipo empleado que obtenemos de la BB.DD.
   */
  public Departamento getById(int codigo);

  /**
   * Metodo encargado de obtener un listado con todos los registros de los diferentes departamentos
   * de la BB.DD.
   * 
   * @return empleados <code>List<Empleado></code> listado con todos los registros de los diferentes
   *         departamentos que se ha obtenido de la BB.DD.
   */
  public List<Departamento> getAll();
}
