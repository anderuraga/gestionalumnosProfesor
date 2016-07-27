package com.ipartek.formacion.empleado.ProyectoGestionEmpleado.pojo;

import java.util.List;

public class Departamento {

	private static final int CODIGO_DEPARTAMENTO = -1;
	
	private int codigo;
	private String descripcion;
	private String nombre;
	private List<Empleado> empleados;
	
	public Departamento() {
		super();
		setCodigo(CODIGO_DEPARTAMENTO);
		setDescripcion("");
		setNombre("");
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	
}
