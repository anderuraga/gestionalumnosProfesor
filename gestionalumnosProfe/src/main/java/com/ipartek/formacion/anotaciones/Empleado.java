package com.ipartek.formacion.anotaciones;



import com.ipartek.formacion.anotaciones.anotacion.Logueable;

public class Empleado {
	private String nombre;

	public Empleado() {
		super();
		setNombre("");
	}
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
