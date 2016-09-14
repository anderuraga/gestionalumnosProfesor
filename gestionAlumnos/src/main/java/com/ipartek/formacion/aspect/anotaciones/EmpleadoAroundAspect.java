package com.ipartek.formacion.aspect.anotaciones;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class EmpleadoAroundAspect {
	@Around("execution(* com.ipartek.formacion.persistencia.Empleado.getName())")
	public Object empleadoeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		System.out.println("Antes de invocar el metodo getName()");
		Object value = null;
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("Despues de invocar el metodo getName(). Return valor="+value);
		return value;
	}
}