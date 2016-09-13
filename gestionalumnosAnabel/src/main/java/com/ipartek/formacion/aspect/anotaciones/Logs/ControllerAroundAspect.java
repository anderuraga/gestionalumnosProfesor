package com.ipartek.formacion.aspect.anotaciones.Logs;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ControllerAroundAspect {

	private Logger logger;
	
	@Around("execution(* com.ipartek.formacion.controller.*.*())")
	public Object controllerAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		
		System.out.println("Antes de invocar a los controladores");
		logger.info("Hemos accedido a los controladores");
		Object value = null;
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
			logger.warn("Ha habido problemas en la ejecucion de los controladores");
		}
		System.out.println("Despues de invocar a los controladores");
		logger.info("Se ha completado la ejecucion del controlador");
		return value;
	}
}
