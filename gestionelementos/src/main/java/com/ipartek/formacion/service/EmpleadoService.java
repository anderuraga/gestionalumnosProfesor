package com.ipartek.formacion.service;

import com.ipartek.formacion.dao.persistencia.Empleado;

public class EmpleadoService {

	private Empleado empleado;
	
	public Empleado getEmpleado(){
		return this.empleado;
	}
	
	public void setEmpleado(Empleado e){
		this.empleado=e;
	}
}