package com.ipartek.formacion.dbms.dao;

import java.util.List;

import com.ipartek.formacion.pojo.Departamento;

public interface DepartamentoDAO {
  /**
   * @param departamento
   *          <code>Departamento</code>
   */
  public Departamento create(Departamento departamento);

  /**
   * Obtiene la lista completa de departamentos.
   * 
   * @return lista de empleados
   */
  public List<Departamento> getAll();

  /**
   * Obtiene el departamento que tenga el codDepartamento solicitado.
   * 
   * @param codDepartamento
   *          <code>int</code>
   * @return <code>Empleado</code>
   */
  public Departamento getById(int codDepartamento);

  /**
   * Actualiza los datos de departamento.
   * 
   * @param emp
   *          <code>Departamento</code>
   * @return <code>Departamento</code>
   */
  public Departamento update(Departamento departamento);

  /**
   * Elimina el departamento con codigo = <code>codDepartamento</code>.
   * 
   * @param codDepartamento
   *          <code>int</code>
   */
  public void delete(int codDepartamento);
}
