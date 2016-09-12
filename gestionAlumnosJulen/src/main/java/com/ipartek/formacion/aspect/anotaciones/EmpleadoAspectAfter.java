package com.ipartek.formacion.aspect.anotaciones;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class EmpleadoAspectAfter {
	@After("args(nombre)")
	public void logStringArgumentos(String nombre){
		System.out.println("Se ejecuta despues del advice. Se pasa como argumento String =" +nombre);
	}

	@AfterThrowing("within(com.ipartek.formacion.aspect.anotaciones.Empleado)")
	public void logExceptions(Joinpoint joinpoint){
		System.out.println("Excepciones lanzadas en empleado metodo=" + joinpoint.toString());
	}
	
	@AfterReturning(pointcut="execution(* getNombre()", returning="returnString")
	public void getNombreReturningAdvice(String returString){
		System.out.println("getNombreReturningAdvice ejecutado");
	}
}
