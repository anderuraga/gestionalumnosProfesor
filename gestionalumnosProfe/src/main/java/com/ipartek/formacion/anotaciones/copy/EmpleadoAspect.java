package com.ipartek.formacion.anotaciones.copy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmpleadoAspect {
	@Before("execution(public String getNombre())")
	public void getNombreAdvice(){
		System.out.println("Se ejecuta en el getNombre()");
	}
	@Before("execution(* com.ipartek.formacion.aspect.anotaciones.*.get*())")
	public void getAllParamatersAdvice(){
		System.out.println("Se ejecuta cualquier get");
	}
}
