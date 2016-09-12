package com.ipartek.formacion.aspect.anotaciones.anotacion;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.aspect.anotaciones.Empleado;

@Service
public class EmpleadoService {
	private Empleado emp = new Empleado();
	public Empleado getEmpleado(){
		return emp;
		
	}
	
}
