package com.ipartek.formacion.aspect.anotaciones.anotacion;

public class Empleado {
	private String nombre;
	
	public Empleado() {
		super();
		this.nombre = "";
	}

	public String getNombre() {
		return nombre;
	}
	
	@Logueable
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void throwException(){
		throw new RuntimeException("Error hecho aproposito");
	}
}
