package com.ipartek.formacion.aspect.anotaciones;

import com.ipartek.formacion.aspect.anotaciones.anotacion.Logueable;

public class Empleado {
	
	private String nombre;

	public Empleado() {
		setNombre("anabel");
	}

	public String getNombre() {
		return this.nombre;
	}

	@Logueable
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void throwException(){
		/*
		 * RuntimeException --> Excepcion en tiempo de ejecucion.
		 */
		throw new RuntimeException("Error hecho a proposito"); 
	}

}
