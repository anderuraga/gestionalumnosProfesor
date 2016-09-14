package com.ipartek.formacion.aspect.anotaciones;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmpleadoAspectJoinPoint {

	
	@Before("execution(public void com.ipartek.formacion.dao.persistencia..set*(*))")
	public void loggingAdvice(JoinPoint joinPoint){
		System.out.println("EAspectJP: Before: Antes de funcionar loggingAdvice en metodo="+joinPoint.toString());
		
		System.out.println("EAspectJP: Before: Argumentos Pasados=" + Arrays.toString(joinPoint.getArgs()));

	}
	
	//Advice arguments, will be applied to bean methods with single String argument
	@Before("args(name)")
	public void logStringArguments(String name){
		System.out.println("EAspectJP: Before: String argument passed="+name);
	}
}