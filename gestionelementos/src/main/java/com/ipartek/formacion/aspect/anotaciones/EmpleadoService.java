package com.ipartek.formacion.aspect.anotaciones;

import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {
	public Empleado getEmpleado() {
		return new Empleado();
	}

}
