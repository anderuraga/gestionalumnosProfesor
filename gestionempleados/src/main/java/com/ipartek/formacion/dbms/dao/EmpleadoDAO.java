package com.ipartek.formacion.dbms.dao;

import java.util.List;

import com.ipartek.formacion.dbms.dao.exceptions.EmpleadoDAOImpException;
import com.ipartek.formacion.pojo.Empleado;

/**
 * 
 * @author Curso
 *
 */
public interface EmpleadoDAO {
  /**
   * @param emp
   *          <code>Empleadp</code>
   * @throws EmpleadoDAOImpException
   */
  public Empleado create(Empleado empleado) throws EmpleadoDAOImpException;

  /**
   * Obtiene la lista completa de empleados.
   * 
   * @return lista de empleados
   */
  public List<Empleado> getAll();

  /**
   * Obtiene el empleado que tenga el codEmpleado solicitado.
   * 
   * @param codEmpleado
   *          <code>int</code>
   * @return <code>Empleado</code>
   */
  public Empleado getById(int codEmpleado);

  /**
   * Actualiza los datos de empleado.
   * 
   * @param emp
   *          <code>Empleado</code>
   * @return <code>Empleado</code>
   */
  public Empleado update(Empleado empleado);

  /**
   * Elimina el empleado con codigo = <code>codEmpleado</code>.
   * 
   * @param codEmpleado
   *          <code>int</code>
   */
  public void delete(int codEmpleado);

}
