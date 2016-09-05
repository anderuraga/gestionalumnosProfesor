package com.ipartek.formacion.dao.persistence;

public class Alumno {
  private int codigo;
  private String nombre;
  private String apellido;

  /**
 * 
 */
  public Alumno() {
    super();
    setCodigo(-1);
    setNombre("");
    setApellido("");
  }

  /**
   * 
   * @return
   */
  public int getCodigo() {
    return codigo;
  }

  /**
   * 
   * @param codigo
   */
  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  /**
   * 
   * @return
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * 
   * @param nombre
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * 
   * @return
   */
  public String getApellido() {
    return apellido;
  }

  /**
   * 
   * @param apellido
   */
  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

}
