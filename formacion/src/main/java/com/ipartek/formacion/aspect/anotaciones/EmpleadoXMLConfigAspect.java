package com.ipartek.formacion.aspect.anotaciones;

import org.aspectj.lang.ProceedingJoinPoint;

public class EmpleadoXMLConfigAspect {

	public Object empleadoAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		System.out.println("EmpleadoXMLConfigAspect: Antes de invocar el metodo getNombreEmpleado()");
		Object value=null;
		try {
			value=proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("EmpleadoXMLConfigAspect:Despues de invocar el getNameEmpleado(), retorna el value="+value);
		return value;
	}
	
	
}
