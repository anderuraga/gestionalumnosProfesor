package com.ipartek.formacion.aspect.anotaciones;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;


@Aspect
public class EmpleadoAspectAfter {
	
	@After("args(name)")
	public void logStringArguments(String name){
		System.out.println("Funcionando después del Advice. Argumento String pasado="+name);
	}
	
	@AfterThrowing("within(com.ipartek.formacion.persistencia.Empleado)")
	public void logExceptions(JoinPoint joinPoint){
		System.out.println("Excepcion lanzada en Empleado Metodo="+joinPoint.toString());
	}
	
	@AfterReturning(pointcut="execution(* getName())", returning="returnString")
	public void getNameReturningAdvice(String returnString){
		System.out.println("getNameReturningAdvice ejecutado. Returned String="+returnString);
	}
	
}
