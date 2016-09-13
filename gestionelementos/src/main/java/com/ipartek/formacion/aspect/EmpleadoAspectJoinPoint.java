package com.ipartek.formacion.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmpleadoAspectJoinPoint {

	
	@Before("execution(public void com.ipartek.formacion.persistencia..set*(*))")
	public void loggingAdvice(JoinPoint joinPoint){
		System.out.println("Antes de funcionar loggingAdvice en metodo="+joinPoint.toString());
		
		System.out.println("Argumentos Pasados=" + Arrays.toString(joinPoint.getArgs()));

	}
	
	//Advice arguments, will be applied to bean methods with single String argument
	@Before("args(name)")
	public void logStringArguments(String name){
		System.out.println("String argument passed="+name);
	}
}