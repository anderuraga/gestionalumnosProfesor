package com.ipartek.formacion.aspect.anotaciones;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmpleadoAspect {
	@Before("execution(public String getNombre())") //indicamos que se va a ejecutar antes del getNombre()
	public void getNombreAdvice(){
		System.out.println("Se ejecuta en el getNombre()");
	}
	
	@Before("execution(* com.ipartek.formacion.aspect.anotaciones.*.get*())") //se va a ejecutar antes de todos los getters del paquete anotaciones
	public void getAllParametersAdvice(){
		System.out.println("Se ejecuta en todos los getters()");
	}
}
