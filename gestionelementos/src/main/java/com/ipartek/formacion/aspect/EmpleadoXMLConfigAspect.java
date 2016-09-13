package com.ipartek.formacion.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class EmpleadoXMLConfigAspect {

	public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		System.out.println("EmployeeXMLConfigAspect:: Antes de invocar el metodo getName() ");
		Object value = null;
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("EmployeeXMLConfigAspect:: Después de invocar getName() metodo. Return valor="+value);
		return value;
	}
}