package com.ipartek.formacion.aspect.anotaciones;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmpleadoAspect {
	@Before("execution(public String getNombre())")
	public void getNombreAdvice() {
		System.out.println("Se ejecuta el getNombre()");
	}
	@Before("execution(* com.ipartek.formacion.aspect.anotaciones.*.get*())")

	public void getAllParametersAdvice(){
		System.out.println("Se ejecuta cualquier get()");

	}
}
