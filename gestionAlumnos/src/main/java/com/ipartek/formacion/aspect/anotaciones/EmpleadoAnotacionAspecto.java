package com.ipartek.formacion.aspect.anotaciones;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmpleadoAnotacionAspecto {
	@Before("@annotation(com.ipartek.formacion.aspect.anotaciones.anotacion.Logueable)")
	public void myAdvice(){
		System.out.println("Ejecutando myAdvice!!");
	}
}
