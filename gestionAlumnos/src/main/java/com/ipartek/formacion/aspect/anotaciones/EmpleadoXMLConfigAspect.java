package com.ipartek.formacion.aspect.anotaciones;

import org.aspectj.lang.ProceedingJoinPoint;

public class EmpleadoXMLConfigAspect {
	public Object empleadoAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		System.out.println("EmployeeXMLConfigAspect:: Antes de invocar el metodo getName() ");
		Object value = null;
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("EmployeeXMLConfigAspect:: Despu�s de invocar getName() metodo. Return valor="+value);
		return value;
	}
}
