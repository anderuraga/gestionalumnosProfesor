package com.ipartek.formacion.aspect.anotaciones;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

public class EmpleadoAspectPointcut {

	@Before("getNamePointcut()")
	public void loggingAdvice(){
		System.out.println("Ejecutando loggingAdvice en getNombreEmpleado()");
	}
	
	@Before("getNamePointcut()")
	public void secondAdvice(){
		System.out.println("Ejecutando secondAdvice on getName()");
		
	}
	
	@Pointcut("execution(public String getNombreEmpleado())")
	public void getNamePointcut(){}
	
	@Before("allMethodsPointcut()")
	public void allServiceMethodsAdvice(){
		System.out.println("Antes de ejecutar metodo de Service");
	}
	
	@Pointcut("within(com.ipartek.formacion.aspect.anotaciones.*)")
	public void allMethodsPointcut(){}
}
