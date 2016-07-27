package com.ipartek.formacion.pojo;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
	public static final int CODIGO = -1;
protected int codigo;
protected String nombre;
protected String descripcion;
protected List<Empleado>empleados;
/**
 * 
 */
public Departamento() {
	super();
	setCodigo(CODIGO);
	setNombre("");
	setDescripcion("");
	empleados=new ArrayList<Empleado>();
	;
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
}
