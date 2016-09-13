package com.ipartek.formacion.aspect.anotaciones;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/*
 * Aspecto (en inglés Aspect) es una funcionalidad transversal (cross-cutting) que se va a implementar de forma modular 
 * y separada del resto del sistema. El ejemplo más común y simple de un aspecto es el logging (registro de sucesos) 
 * dentro del sistema, ya que necesariamente afecta a todas las partes del sistema que generan un suceso.
 */
@Aspect
public class EmpleadoAspect {
	
	
	
	/*
	 * Quiero que se ejecute antes de todos los getts que se encuentren dentro del paquete anotaciones. 
	 * Es lo que hacemos con el @Before
	 */
	@Before("execution(public String getNombre())")
	public void getNameAdvice(){
		System.out.println("Ejecutando Advice en getNombre()");
	}
	
	@Before("execution(* com.ipartek.formacion.service.*.get*())")
	public void getAllAdvice(){
		System.out.println("Metodo en Service llamado: getter");
	}
}
