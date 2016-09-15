package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.dbms.dao.exceptions.EmpleadoDAOImpException;
import com.ipartek.formacion.pojo.Empleado;

/**
 * 
 * @author Curso
 *
 */
public interface EmpleadoService {
  /**
   * 
   * @param empleado
   *          <code>Empleado</code>
   * @return <code>Empleado</code>
   * @throws EmpleadoDAOImpException
   */
  public Empleado create(Empleado empleado) throws EmpleadoDAOImpException;

  /**
   * 
   * @return Lista <code>Empleado</code>
   */
  public List<Empleado> getAll();

  /**
   * 
   * @param codEmp
   *          <code>int</code>
   * @return <code>Empleado</code>
   */
  public Empleado getById(int codEmp);
}
