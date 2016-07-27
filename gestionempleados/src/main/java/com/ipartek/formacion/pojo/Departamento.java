package com.ipartek.formacion.pojo;

import java.util.List;

public class Departamento {
	public static final int CODIGO_DEPARTAMENTO = -1;
	
	private int codigo;
	private String nombre;
	private String descripcion;
	private List<Empleado> empleados;
	/**
	 * 
	 */
	public Departamento() {
		super();
		this.setCodigo(CODIGO_DEPARTAMENTO);
		this.setNombre("");
		this.setDescripcion("");
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
	public List<Empleado> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	
	
	

}
