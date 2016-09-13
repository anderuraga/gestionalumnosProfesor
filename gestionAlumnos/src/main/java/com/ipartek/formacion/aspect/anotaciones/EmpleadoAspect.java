package com.ipartek.formacion.aspect.anotaciones;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmpleadoAspect {
	@Before("execution(public String getName())")
	public void getNameAdvice(){
		System.out.println("Ejecutando Advice en getName()");
	}
	
	@Before("execution(* com.ipartek.formacion.service.*.get*())")
	public void getAllAdvice(){
		System.out.println("Metodo en Service llamado: getter");
	}
	
	
}
