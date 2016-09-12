package com.ipartek.formacion.aspect.anotaciones;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmpleadoAspectJoinPoint {
	
	@Before("execution(public void setNombre())")
	public void setNombreAdvice(){
		
	}
}
