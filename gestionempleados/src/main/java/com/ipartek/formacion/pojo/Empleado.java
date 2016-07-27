package com.ipartek.formacion.pojo;

import java.util.Date;

/**
 * Clase <code>Empleado</code>.
 * 
 * @author Curso
 *
 */
public class Empleado {
  public final static int CODIGO_EMPLEADO = -1;
  private int codigo;
  private Date fNacimiento;
  private Date fContratacion;
  private String nombre;
  private String apellidos;
  private String nSeguridadSocial;
  private String nCuentaBancaria;
  private String direccion;
  private String localidad;
  private String codigoPostal;
  private String dni;
  private Departamento departamento;

  /**
   * 
   */
  public Empleado() {
    super();
    setCodigo(CODIGO_EMPLEADO);
    setfNacimiento(new Date());
    setfContratacion(new Date());
    setNombre("");
    setApellidos("");
    setnSeguridadSocial("");
    setnCuentaBancaria("");
    setDireccion("");
    setLocalidad("");
    setCodigoPostal("");
    setDni("");
    setDepartamento(new Departamento());

  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public Date getfNacimiento() {
    return fNacimiento;
  }

  public void setfNacimiento(Date fNacimiento) {
    this.fNacimiento = fNacimiento;
  }

  public Date getfContratacion() {
    return fContratacion;
  }

  public void setfContratacion(Date fContratacion) {
    this.fContratacion = fContratacion;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public String getnSeguridadSocial() {
    return nSeguridadSocial;
  }

  public void setnSeguridadSocial(String nSeguridadSocial) {
    this.nSeguridadSocial = nSeguridadSocial;
  }

  public String getnCuentaBancaria() {
    return nCuentaBancaria;
  }

  public void setnCuentaBancaria(String nCuentaBancaria) {
    this.nCuentaBancaria = nCuentaBancaria;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getLocalidad() {
    return localidad;
  }

  public void setLocalidad(String localidad) {
    this.localidad = localidad;
  }

  public String getCodigoPostal() {
    return codigoPostal;
  }

  public void setCodigoPostal(String codigoPostal) {
    this.codigoPostal = codigoPostal;
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public Departamento getDepartamento() {
    return departamento;
  }

  public void setDepartamento(Departamento departamento) {
    this.departamento = departamento;
  }

}
