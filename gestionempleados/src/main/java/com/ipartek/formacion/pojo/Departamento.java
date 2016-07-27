package com.ipartek.formacion.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase <code>Departamento</code>.
 * 
 * @author Curso
 *
 */
public class Departamento {
  public final static int CODIGO_DEPARTAMENTO = -1;
  private int codigo;
  private String nombre;
  private String descripcion;
  private List<Empleado> empleados;

  /**
   * 
   */
  public Departamento() {
    super();
    setCodigo(CODIGO_DEPARTAMENTO);
    setNombre("");
    setDescripcion("");
    setEmpleados(new ArrayList<Empleado>());
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public List<Empleado> getEmpleados() {
    return empleados;
  }

  public void setEmpleados(List<Empleado> empleados) {
    this.empleados = empleados;
  }

}
