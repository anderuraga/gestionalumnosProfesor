package com.ipartek.formacion.aspect.anotaciones;

import com.ipartek.formacion.aspect.anotaciones.anotacion.Logueable;


public class Empleado {
	private String nombre;

	public String getNombre() {
		return nombre;
		
		

	}
	
	public Empleado() {
		super();
		this.setNombre("Triqui");	}

	@Logueable
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void throwException(){
	throw new RuntimeException("Error hecho a proposito");
	}
}
