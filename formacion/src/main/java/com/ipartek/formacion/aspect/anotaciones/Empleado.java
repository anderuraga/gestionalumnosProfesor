package com.ipartek.formacion.aspect.anotaciones;

import com.ipartek.formacion.aspect.anotaciones.anotacion.Logueable;

public class Empleado {

	private String nombreEmpleado;

	
	public Empleado() {
		super();
		this.setNombreEmpleado("");
	}
	public String getNombreEmpleado() {
		return nombreEmpleado;
	}
	@Logueable
	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}
	
	public void throwException(){
		throw new RuntimeException("Error hecho a proposito");
	}
	
	
}
