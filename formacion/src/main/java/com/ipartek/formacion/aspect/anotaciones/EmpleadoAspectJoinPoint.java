package com.ipartek.formacion.aspect.anotaciones;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmpleadoAspectJoinPoint {

	@Before("execution(public void com.ipartek.formacion.aspect.anotaciones..set*(*))")
	public void loggingAdvice(JoinPoint joinPoint){
		System.out.println("Antes de funcionar loggingAdvice en metodo="+joinPoint.toString());
		
		System.out.println("Argumentos Pasados=" + Arrays.toString(joinPoint.getArgs()));
		
		
	}
	
	@Before("args(name)")
	public void logStringArguments(String name){
		System.out.println("String pasada="+name);
	}
}
