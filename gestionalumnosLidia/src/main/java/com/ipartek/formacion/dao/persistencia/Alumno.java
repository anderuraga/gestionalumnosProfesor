package com.ipartek.formacion.dao.persistencia;

public class Alumno {
  private int codigo;
  private String nombre;
  private String apellidos;
  @Phone
  private String telefono;

  /**
 * 
 */
  public Alumno() {
    super();
    setCodigo(-1);
    setNombre("");
    setApellidos("");
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
  public String getApellidos() {
    return apellidos;
  }

  /**
   * 
   * @param apellido
   */
  public void setApellidos(String apellido) {
    this.apellidos = apellido;
  }

}
