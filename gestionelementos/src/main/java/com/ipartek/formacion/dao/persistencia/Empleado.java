package com.ipartek.formacion.dao.persistencia;

import com.ipartek.formacion.aspect.Logueable;

public class Empleado {

	private String name;
	
	public String getName() {
		return name;
	}

	@Logueable
	public void setName(String nm) {
		this.name=nm;
	}
	
	public void throwException(){
		throw new RuntimeException("Excepcion para que casque");
	}
	
}