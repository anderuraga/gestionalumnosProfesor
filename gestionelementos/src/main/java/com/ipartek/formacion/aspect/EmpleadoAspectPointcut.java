package com.ipartek.formacion.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class EmpleadoAspectPointcut {

	@Before("getNamePointcut()")
	public void loggingAdvice(){
		System.out.println("EAspectPC: Before: Ejecutando loggingAdvice en getName()");
	}
	
	@Before("getNamePointcut()")
	public void secondAdvice(){
		System.out.println("EAspectPC: Before: Ejecutando secondAdvice on getName()");
	}
	
	@Pointcut("execution(public String getName())")
	public void getNamePointcut(){}
	
	@Before("allMethodsPointcut()")
	public void allServiceMethodsAdvice(){
		System.out.println("EAspectPC: Before: Before executing service method");
	}
	
	//Pointcut to execute on all the methods of classes in a package
	@Pointcut("within(com.ipartek.formacion.service.*)")
	public void allMethodsPointcut(){}
	
}