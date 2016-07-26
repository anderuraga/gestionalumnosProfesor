package com.ipartek.formacion.pojo;

public enum DuracionHoras {
  H15(1, 15), H20(2, 20), H30(3, 30), H45(4, 45), H80(5, 80), H90(6, 90);
  private int codigo;
  private int duracion;

  DuracionHoras(int codigo, int duracion) {
    this.codigo = codigo;
    this.duracion = duracion;
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public int getDuracion() {
    return duracion;
  }

  public void setDuracion(int duracion) {
    this.duracion = duracion;
  }

}
