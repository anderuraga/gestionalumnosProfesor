package com.ipartek.formacion.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.dao.EmpleadoDAO;
import com.ipartek.formacion.dbms.dao.EmpleadoDAOImp;
import com.ipartek.formacion.pojo.Empleado;

/**
 * * Clase encargada de definir los metodos que definen la logica de la aplicacion, con respecto a
 * los empleados. Estas funcionalidades van a ser:
 * <ul>
 * <li>Crear un nuevo registro de empleado</li>
 * <li>Borrar un registro existente de empleado</li>
 * <li>Modificar un registro existente de un empleado</li>
 * <li>Obtener los datos de un empleado</li>
 * <li>Obtener un listado con todos los datos de los distintos empleados</li>
 * </ul>
 * 
 * @author Curso
 *
 */
public class EmpleadoServiceImp implements EmpleadoService {

  private static final Logger LOG = Logger.getLogger(EmpleadoServiceImp.class);
  private static EmpleadoServiceImp INSTANCE = null;
  private EmpleadoDAO empleadoDAO;

  public EmpleadoServiceImp() {
    this.empleadoDAO = EmpleadoDAOImp.getInstance();
  }

  public static EmpleadoServiceImp getInstance() {
    if (INSTANCE == null) {
      createInstance();
    }
    return INSTANCE;
  }

  private static synchronized void createInstance() {

    if (INSTANCE == null) {
      INSTANCE = new EmpleadoServiceImp();
    }

  }

  /**
   * Metodo encargado de proporcionarle los datos a la capa Modelo para crear un registro de
   * empleado.
   * 
   * @param empleado
   *          <code>Empleado</code> objeto de tipo empleado con los datos que quieren registrarse.
   * @return emp <code>Empleado</code> objeto de tipo empleado con los datos que se han registrado.
   */
  @Override
  public Empleado create(Empleado empleado) {

    Empleado emp;
    emp = this.empleadoDAO.create(empleado);
    return emp;
  }

  /**
   * Metodo encargado de borrar un registro de empleado. Proporcionandole a la capa modelo el codigo
   * del empleado que se quiere eliminar.
   * 
   * @param codigo
   *          <code>int</code> codigo del empleado que quiere eliminarse
   */
  @Override
  public void delete(int codigo) {
    this.empleadoDAO.delete(codigo);

  }

  /**
   * Metodo encargado de modificar un empleado. Proporcionandole a la capa modelo los datos que
   * quieren ser modifficados.
   * 
   * @param empleado
   *          <code>Empleado</code> objeto de tipo empleado con los datos que van a ser modificados.
   * @return emp <code>Empleado</code> objeto de tipo empleado con los datos que se han modificado.
   */
  @Override
  public Empleado update(Empleado empleado) {
    Empleado emp;
    emp = this.empleadoDAO.update(empleado);
    return emp;
  }

  /**
   * Metodo encargado de obtener un empleado en funcion del codigo.
   * 
   * @param codigo
   *          <code>int</code> codigo del empleado del cual se quiere obtener la informacion.
   * @return emp <code>Empleado</code> objeto de tipo empleado con los datos del empleado
   *         correspondiente.
   */
  @Override
  public Empleado getById(int codigo) {

    Empleado emp;
    emp = this.empleadoDAO.getById(codigo);
    return emp;
  }

  /**
   * Metodo encargado de devolver una lista con todos los empleados de los cuales existe registro.
   * 
   * @return empleados <code>List<Empleado></code> lista de objetos de tipo empleado con todos los
   *         datos de los distintos empleados que hay en el registro.
   */
  @Override
  public List<Empleado> getAll() {
    List<Empleado> empleados;
    empleados = this.empleadoDAO.getAll();
    return empleados;
  }

}
