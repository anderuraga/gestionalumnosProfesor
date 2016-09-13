package com.ipartek.formacion.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmpleadoAnotacionAspect {

	@Before("@annotation(com.ipartek.formacion.aspect.Loggable)")
	public void myAdvice(){
		System.out.println("Ejecutando myAdvice!!");
	}
}