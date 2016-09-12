package com.ipartek.formacion.aspect.anotaciones;

import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {
	
	private Empleado emp = new Empleado();
	public Empleado getEmpleado(){
		this.emp = new Empleado();
		return emp;
	}
	

}
