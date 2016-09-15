package com.ipartek.formacion.dao.persistence;

import javax.validation.constraints.Size;

public class Curso {
  private int codigo;
  @Size(min=3)
  private String nombre;

  /**
 * 
 */
  public Curso() {
    super();
    setCodigo(0);
    setNombre("");
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

}
