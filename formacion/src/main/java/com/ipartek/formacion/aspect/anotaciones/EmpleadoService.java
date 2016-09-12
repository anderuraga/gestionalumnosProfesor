package com.ipartek.formacion.aspect.anotaciones;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.aspect.anotaciones.anotacion.Empleado;

@Service
public class EmpleadoService {
	
	private Empleado emp = new Empleado();
	
	public Empleado getEmpleado(){
		
		return new Empleado();
	}
}
