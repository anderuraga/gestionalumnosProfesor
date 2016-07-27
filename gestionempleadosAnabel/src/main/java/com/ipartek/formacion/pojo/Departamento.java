package com.ipartek.formacion.pojo;

import java.util.List;

/**
 * Clase POJO que define los getter y los setter de Departamento
 * 
 * @author Anabel
 *
 */
public class Departamento {

  private int codigo;
  private String nombre;
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
    return nombre;
  }

  /**
   * Setter que introduce el nombre del departamento.
   * 
   * @param nombre
   *          <code>String</code>
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
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

}
