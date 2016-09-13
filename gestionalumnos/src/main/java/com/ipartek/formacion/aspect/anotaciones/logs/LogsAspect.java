package com.ipartek.formacion.aspect.anotaciones.logs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LogsAspect {

	private static final Log log = LogFactory.getLog(LogsAspect.class);

	@Around("execution(* com.ipartek.formacion.controller.*.*()")
	public Object logsForController(ProceedingJoinPoint proceedingJoinPoint){
		System.out.println("Antes de invocar cualquier metodo dentro de controller");
		Object value = null;
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		log.info("Invocacion de metodo: " + proceedingJoinPoint.getSignature());
		System.out.println("Despues de invocar cualquier metodo de controller. Return valor="+value);
		return value;
	}
}
