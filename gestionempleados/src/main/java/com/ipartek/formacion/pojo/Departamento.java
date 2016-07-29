package com.ipartek.formacion.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * •	Código
•	Nombre
•	descripción

 * @author Curso
 *
 */

public class Departamento {

	public static final int CODIGO_DEPARTAMENTO = -1;
	
	protected int codigo;
	private String nombre;
	private String descripcion;
	private List<Empleado>empleados;
	
	
	public Departamento() {
		super();
		setCodigo(codigo);
		setNombre("");
		setDescripcion("");
		empleados = new ArrayList<Empleado>();
		
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}


	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
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
