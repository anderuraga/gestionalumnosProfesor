package com.ipartek.formacion.aspect.anotaciones;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;


@Aspect
public class EmpleadoAspectAround {
	@Around("execution(* com.ipartek.formacion.aspect.anotaciones.Empleado.getNombre())")
	public Object empleadoAroundAdvice(ProceedingJoinPoint proceeding){
		Object valor = null;
		System.out.println("Antes de invocar el método getNombre()");
		
		try {
			valor = proceeding.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Después de invocar el método getNombre(). Return = " + valor);
		
		return valor;
	}

}
