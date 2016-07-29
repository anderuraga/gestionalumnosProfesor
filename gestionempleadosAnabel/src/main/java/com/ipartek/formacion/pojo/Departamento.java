package com.ipartek.formacion.pojo;

import java.util.List;

/**
 * Clase POJO que define los getter y los setter de Departamento
 * 
 * @author Anabel
 *
 */
public class Departamento {

  private final static int CODIGO_DEPARTAMENTO = -1;
  private int codigo;
  private String nombreDep;
  private String descripcion;
  private List<Empleado> empleados;

  /**
   * Getter que devuelve el codigo de departamento.
   * 
   * @return codigo <code>int</code>
   */
  public int getCodigo() {
    return codigo;
  }

  /**
   * Setter que introduce el codigo de departamento.
   * 
   * @param codigo
   *          <code>int</code>
   */
  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  /**
   * Getter que devuelve el nombre del departamento.
   * 
   * @return nombre <code>String</code>
   */
  public String getNombre() {
    return nombreDep;
  }

  /**
   * Setter que introduce el nombre del departamento.
   * 
   * @param nombre
   *          <code>String</code>
   */
  public void setNombre(String nombre) {
    this.nombreDep = nombre;
  }

  /**
   * Getter que devuelve la descripcion del departamento.
   * 
   * @return descripcion <code>String</code>
   */
  public String getDescripcion() {
    return descripcion;
  }

  /**
   * Setter que introduce la descripcion del departamento.
   * 
   * @param descripcion
   *          <code>String</code>
   */
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  /**
   * Getter que devuelve el listado de todos los empleados pertenecientes a un departamento.
   * 
   * @return empleados <code>List<Empleados></code> listado del tipo empleados.
   */
  public List<Empleado> getEmpleados() {
    return empleados;
  }

  /**
   * Setter que introduce el listado de los empleados pertenecientes a un departamento.
   * 
   * @param empleados
   *          <code>List<Empleado></code>
   */
  public void setEmpleados(List<Empleado> empleados) {
    this.empleados = empleados;
  }

}
