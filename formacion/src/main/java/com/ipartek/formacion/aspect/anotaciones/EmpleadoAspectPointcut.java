package com.ipartek.formacion.aspect.anotaciones;

import org.aspectj.lang.annotation.Before;

public class EmpleadoAspectPointcut {

	@Before("getNamePointcut()")
	public void loggingAdvice(){
		System.out.println("Ejecutando loggingAdvice en getNombreEmpleado()");
	}
	
	
	
}
