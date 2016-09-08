package com.ipartek.formacion.dao.persistencia;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

public class Alumno {
	@NotNull
private int codigo;
@NotNull
private String nombre;
@NotNull
private String apellidos;
@Past @NotNull @DateTimeFormat(pattern="dd/MM/yyyy")
private Date fNacimiento;

private int telefono;

@Min(value = 0)
public int getCodigo() {
	return codigo;
}
public Date getfNacimiento() {
	return fNacimiento;
}
public void setfNacimiento(Date fNacimiento) {
	this.fNacimiento = fNacimiento;
}
public void setCodigo(int codigo) {
	this.codigo = codigo;
}
/**
 * 
 */
public Alumno() {
	super();
	setCodigo(-1);
	setNombre("");
	setApellidos("");
	
	
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
}
