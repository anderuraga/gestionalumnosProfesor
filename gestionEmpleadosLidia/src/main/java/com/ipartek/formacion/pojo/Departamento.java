package com.ipartek.formacion.pojo;

import java.util.ArrayList;
import java.util.List;

public class Departamento {

	private int codigoDep;
	private String nombre;
	private String descripcion;
	private List<Empleado>empleados;
	
	public Departamento() {
		super();
		this.codigoDep = codigoDep;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.empleados=new ArrayList<Empleado>();
	}

	public int getCodigoDep() {
		return codigoDep;
	}

	public void setCodigoDep(int codigoDep) {
		this.codigoDep = codigoDep;
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
