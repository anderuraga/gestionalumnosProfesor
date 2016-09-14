package com.ipartek.formacion.aspect;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.aspect.anotaciones.Empleado;

@Service
public class EmpleadoService {
	public Empleado getEmpleado() {
		return new Empleado();
	}

}
