package com.ipartek.formacion.pojo;

import java.util.Date;

/**
 * Clase POJO que contiene los getter y los setter de los parametros que puede tener empleado.
 * 
 * @author Anabel
 *
 */
public class Empleado {

  private int codigo; // ESTE CODIGO LO TENGO QUE INICIALIZAR A -1???
  private Date fNacimiento;
  private Date fContratacion;
  private String nombreEmp;
  private String apellidos;
  private String DNI;
  private int SegSocial;
  private int CuentaCorriente;
  private String direccion;
  private String localidad;
  private int codigoPostal;
  private Departamento tipoDepartamento;

  /**
   * Constructor de la clase POJO empleado.
   */
  public Empleado() {

    setApellidos("");
    setCodigoPostal(0);
    setCuentaCorriente(0);
    setDireccion("");
    setDNI("");
    setLocalidad("");
    setNombre("");
    setSegSocial(0);
    setTipoDepartamento(new Departamento());
    setfContratacion(new Date());
    setfNacimiento(new Date());
  }

  /**
   * Getter que devuelve el codigo de empleado.
   * 
   * @return codigo <code>int</code>
   */
  public int getCodigo() {
    return codigo;
  }

  /**
   * Setter que introduce el codigo de empleado.
   * 
   * @param codigo
   *          <code>int</code>
   */
  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  /**
   * Getter que devuelve la fecha de nacimiento del empleado.
   * 
   * @return fNacimiento <code>java.util.Date</code>
   */
  public Date getfNacimiento() {
    return fNacimiento;
  }

  /**
   * Setter que introduce la fecha de nacimiento del empleado.
   * 
   * @param fNacimiento
   *          <code>java.util.Date</code>
   */
  public void setfNacimiento(Date fNacimiento) {
    this.fNacimiento = fNacimiento;
  }

  /**
   * Getter que devuelve la fecha de contratacion del empleado.
   * 
   * @return fContratacion <code>java.util.Date</code>
   */
  public Date getfContratacion() {
    return fContratacion;
  }

  /**
   * Setter que introduce la fecha de contratacion del empleado.
   * 
   * @param fContratacion
   *          <code>java.util.Date</code>
   */
  public void setfContratacion(Date fContratacion) {
    this.fContratacion = fContratacion;
  }

  /**
   * Getter que devuelve el nombre del empleado.
   * 
   * @return nombre <code>String</code>
   */
  public String getNombre() {
    return nombreEmp;
  }

  /**
   * Setter que introduce el nombre del empleado.
   * 
   * @param nombre
   *          <code>String</code>
   */
  public void setNombre(String nombre) {
    this.nombreEmp = nombre;
  }

  /**
   * Getter que devuelve los apellidos del empleado.
   * 
   * @return apellidos <code>String</code>
   */
  public String getApellidos() {
    return apellidos;
  }

  /**
   * Setter que introduce los apellidos del empleado.
   * 
   * @param apellidos
   *          <code>String</code>
   */
  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  /**
   * Getter que devuelve el dni del empleado.
   * 
   * @return DNI <code>String</code>
   */
  public String getDNI() {
    return DNI;
  }

  /**
   * Setter que devuelve el dni del empleado.
   * 
   * @param dNI
   *          <code>String</code>
   */
  public void setDNI(String dNI) {
    DNI = dNI;
  }

  /**
   * Getter que devuelve el numero de la seguridad social del empleado.
   * 
   * @return SegSocial <code>int</code>
   */
  public int getSegSocial() {
    return SegSocial;
  }

  /**
   * Setter que introduce el numero de la seguridad social del empleado.
   * 
   * @param segSocial
   *          <code>int</code>
   */
  public void setSegSocial(int segSocial) {
    SegSocial = segSocial;
  }

  /**
   * Getter que devuelve el numero de la cuenta corriente del empleado.
   * 
   * @return CuentaCorriente <code>int</code>
   */
  public int getCuentaCorriente() {
    return CuentaCorriente;
  }

  /**
   * Setter que introduce el numero de la cuenta corriente del empleado.
   * 
   * @param cuentaCorriente
   *          <code>int</code>
   */
  public void setCuentaCorriente(int cuentaCorriente) {
    CuentaCorriente = cuentaCorriente;
  }

  /**
   * Getter que devuelve la direccion del empleado.
   * 
   * @return direccion <code>String</code>
   */
  public String getDireccion() {
    return direccion;
  }

  /**
   * Setter que introduce la direccion del empleado.
   * 
   * @param direccion
   *          <code>String</code>
   */
  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  /**
   * Getter que devuelve la localidad del empleado.
   * 
   * @return localidad <code>String</code>
   */
  public String getLocalidad() {
    return localidad;
  }

  /**
   * Setter que introduce la localidad del empleado.
   * 
   * @param localidad
   *          <code>String</code>
   */
  public void setLocalidad(String localidad) {
    this.localidad = localidad;
  }

  /**
   * Getter que devuelve el Codigo Postal del empleado.
   * 
   * @return codigoPostal <code>int</code>
   */
  public int getCodigoPostal() {
    return codigoPostal;
  }

  /**
   * Setter que introduce el Codigo Postal del empleado.
   * 
   * @param codigoPostal
   *          <code>int</code>
   */
  public void setCodigoPostal(int codigoPostal) {
    this.codigoPostal = codigoPostal;
  }

  /**
   * Getter que devuelve el entero que corresponde a un tipo de departamento de la empresa, los
   * distintos departamentos estan definidos en la BB.DD.
   * 
   * @return tipoDepartamento <code>int</code>
   */
  public Departamento getTipoDepartamento() {
    return tipoDepartamento;
  }

  /**
   * Setter que introduce el entero que corresponde aun tipo de departamento de la empresa, los
   * distintos departamentos estan definidos en la BB.DD.
   * 
   * @param tipoDepartamento
   *          <code>int</code>
   */
  public void setTipoDepartamento(Departamento tipoDepartamento) {
    this.tipoDepartamento = tipoDepartamento;
  }

}
