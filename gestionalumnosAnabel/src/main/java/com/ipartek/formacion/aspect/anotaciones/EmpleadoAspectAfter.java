package com.ipartek.formacion.aspect.anotaciones;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class EmpleadoAspectAfter {

	/*
	 * Se ejecuta cada vez que un metodo reciba como argumento un nombre
	 */
	@After("args(nombre)")
	public void logStringArgument(String nombre){
		
		System.out.println("Se ejecuta despues del 'Advice',Se pasa como argumento String = "+nombre);
	}
	
	/*
	 * Se ejecuta despues de que salte la excepcion de empleado
	 */
	@AfterThrowing("within(com.ipartek.formacion.aspect.anotaciones.Empleado)")
	public void logExcepciones(Joinpoint joinpoint){
		System.out.println("Excepciones lanzadsa en Empleado Metodo="+joinpoint.toString());
	}
	
	@AfterReturning(pointcut="execution(* getNombre())", returning="returnString")
	public void getNombreReturningAdvice(String returnString){
		System.out.println("getNombreReturningAdvice ejecutado. Se devuelve String = " + returnString);
	}
}
