package com.ipartek.formacion.aspect.anotaciones;

import com.ipartek.formacion.aspect.anotaciones.anotacion.Logueable;


public class Empleado {

	private String name;
	
	public String getNombre() {
		return name;
	}

	@Logueable
	public void setNombre(String nm) {
		this.name=nm;
	}
	
	public void throwException(){
		throw new RuntimeException("Excepcion para que casque");
	}
	
}