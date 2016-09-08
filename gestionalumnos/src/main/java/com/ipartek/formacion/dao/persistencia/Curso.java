package com.ipartek.formacion.dao.persistencia;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Curso {

  private int codigo;
  private String nombre;

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }
  @Size(min=3, max=30)
  @Pattern(regexp = "[A-Z]{1}", message = " ")
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

}
