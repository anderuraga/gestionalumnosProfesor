package com.ipartek.formacion.aspect.anotaciones;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmpleadoAspectJointPoint {
	@Before("execution(public String setNombre())") //indicamos que se va a ejecutar antes del setNombre()
	public void setNombreAdvice(){
		System.out.println("Se ejecuta en el setNombre()");
	}
	
	@Before("execution(* com.ipartek.formacion.aspect.anotaciones.*.set*())") //se va a ejecutar antes de todos los setters del paquete anotaciones
	public void setAllParametersAdvice(){
		System.out.println("Se ejecuta en todos los setters()");
	}
}
