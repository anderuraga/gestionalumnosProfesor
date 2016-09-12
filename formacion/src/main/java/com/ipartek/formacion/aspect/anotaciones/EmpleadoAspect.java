package com.ipartek.formacion.aspect.anotaciones;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmpleadoAspect {
	@Before("public String getNombre()")
	public void getNombreAdvice(){
		System.out.println("Se ejecuta en el getNombre()");
	}
	
	@Before("* com.ipartek.formacion.aspect.anotaciones.*.get*()")
	public void getAllParamentersAdvice(){
		System.out.println("Se ejecuta cualquier get");
	}
}
