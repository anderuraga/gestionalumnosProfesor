package com.ipartek.formacion.pojo;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
	public static final int COD_DPTO = -1;
	private int codDept;
	private String nombre;
	private String descripcion;
	private List<Empleado> empleados;

	/**
	 * Constructor del Departamento.
	 */
	public Departamento() {
		super();
		setCodDept(COD_DPTO);
		setNombre("");
		setDescripcion("");
		empleados = new ArrayList<Empleado>();
	}

	public int getCodDept() {
		return codDept;
	}

	public void setCodDept(int codDept) {
		this.codDept = codDept;
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
