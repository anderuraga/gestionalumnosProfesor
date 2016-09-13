package com.ipartek.formacion.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmpleadoAnotacionAspect {

	@Before("@annotation(com.ipartek.formacion.aspect.Logueable)")
	public void myAdvice(){
		System.out.println("EAnotacion: Before: Ejecutando myAdvice!!");
	}
}