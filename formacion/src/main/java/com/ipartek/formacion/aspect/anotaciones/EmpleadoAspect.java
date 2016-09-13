package com.ipartek.formacion.aspect.anotaciones;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmpleadoAspect {

	@Before("execution(public String getNombreEmpleado())")
	public void getNombreAdvice(){
		System.out.println("Se ejecuta en el getNombre()");
	}
	
	@Before("execution(* com.ipartek.formacion.aspect.anotaciones.*.get*())")
	public void getAllParameters(){
		System.out.println("Se ejecuta en cualquier get");
	}
	
	
}
