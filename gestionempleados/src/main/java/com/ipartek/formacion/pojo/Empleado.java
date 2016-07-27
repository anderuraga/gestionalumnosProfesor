package com.ipartek.formacion.pojo;

import java.util.Date;

public class Empleado {
	
public static final int CODIGO = -1;
protected int codigo;
protected Date fNacimiento;
protected Date fContratacion;
protected String nombre;
protected String apellidos;
protected String segSocial;
protected String cc;
protected String direccion;
protected String localidad;
protected String cp;
protected String dni;
/**
 * 
 */
public Empleado() {
	super();
	setCodigo(CODIGO);
	setfNacimiento(new Date());
	setfContratacion(new Date());
	setNombre("");
	setApellidos("");
	setSegSocial("");
	setCc("");
	setDireccion("");
	setLocalidad("");
	setCp("");
	setDni("");
	
	
	
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
public void setfNacimiento(Date fechaN) {
	this.fNacimiento = fechaN;
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
public String getSegSocial() {
	return segSocial;
}
public void setSegSocial(String segSocial) {
	this.segSocial = segSocial;
}
public String getCc() {
	return cc;
}
public void setCc(String cc) {
	this.cc = cc;
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
public String getCp() {
	return cp;
}
public void setCp(String cp) {
	this.cp = cp;
}
public String getDni() {
	return dni;
}
public void setDni(String dni) {
	this.dni = dni;
}
}
