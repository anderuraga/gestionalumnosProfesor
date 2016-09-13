package com.ipartek.formacion.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class EmpleadoAfterAspect {

	@After("args(name)")
	public void logStringArguments(String name){
		System.out.println("EAfter: After: Funcionando después del Advice. Argumento String pasado="+name);
	}
	
	@AfterThrowing("within(com.ipartek.formacion.dao.persistencia.Empleado)")
	public void logExceptions(JoinPoint joinPoint){
		System.out.println("EAfter: After: Excepcion lanzada en Empleado Metodo="+joinPoint.toString());
	}
	
	@AfterReturning(pointcut="execution(* getName())", returning="returnString")
	public void getNameReturningAdvice(String returnString){
		System.out.println("EAfter: After: getNameReturningAdvice ejecutado. Returned String="+returnString);
	}
	
}