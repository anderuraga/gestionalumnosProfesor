package com.ipartek.formacion.anotaciones;

import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {
	private Empleado emp = new Empleado();
	public Empleado getEmpleado(){
		return new Empleado();
	}
}
