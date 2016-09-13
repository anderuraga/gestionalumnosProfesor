package com.ipartek.formacion.aspect.anotaciones;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.After;



@Aspect
public class EmpleadoAspectAfter {

	@After("args(nombreEmpleado)")
	public void logStringArgumentos(String nombre){
		System.out.println("Se ejecuta despues del 'Advice?. Se apsa como argumento String=nombreEmpleado");
		
	}
	@AfterThrowing("within(com.ipartek.formacion.aspect.anotaciones.Empleado)")
	public void logExcepciones(JoinPoint joinpoint){
		System.out.println("Excepciones lanzadas en Empleado Metodo="+joinpoint.toString());
	}
	@AfterReturning(pointcut="execution(* getNombre())",returning="returnString")
	public void getNombreReturningAdvice(String returnString){
		System.out.println("getNombreReturningAdvice ejecutado. Se devuelve String= "+returnString);
	}
	
}
