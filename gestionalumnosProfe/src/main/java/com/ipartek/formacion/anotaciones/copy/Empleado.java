package com.ipartek.formacion.anotaciones.copy;



import com.ipartek.formacion.anotaciones.anotacion.Logueable;

public class Empleado {
	private String nombre;

	public String getNombre() {
		return nombre;
	}
	@Logueable
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void throwException() {
		throw new RuntimeException("Error hecho a proposito");
		
	}
}
