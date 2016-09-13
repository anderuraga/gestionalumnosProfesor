package com.ipartek.formacion.aspect.anotaciones;

import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {
	private Empleado empleado;
	
	public Empleado getEmpleado(){
		return this.empleado;
	}
	
	public void setEmpleado(Empleado e){
		this.empleado=e;
	}
}
