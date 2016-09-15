package com.ipartek.formacion.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true) 
public class LoggerAspect {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Around("execution(* com.ipartek.formacion.controlador.*.*(..))")
	public Object logAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		Object valor = null;
		log.info("Metodo de "+ proceedingJoinPoint.getTarget().getClass().getSimpleName());
		try {
			valor = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		log.info("Despues metodo controller. Return= "
				+ valor);
		return valor;
	}
}
