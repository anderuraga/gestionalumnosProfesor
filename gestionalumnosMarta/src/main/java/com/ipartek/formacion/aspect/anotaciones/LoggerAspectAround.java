package com.ipartek.formacion.aspect.anotaciones;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggerAspectAround {
	Logger log = LoggerFactory.getLogger(this.getClass());
	@Around("execution(* com.ipartek.formacion.controller.*.*())")
	public Object loggerAroundAdvice(ProceedingJoinPoint proceeding){
		Object valor = null;
		log.info("Antes de invocar el controller"); 
		System.out.println("Antes de invocar controller");
		try {
			valor = proceeding.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		log.info("Despues de invocar el controller");
		System.out.println("Despues de invocar controller.  Return="+valor);
		return valor;
	}
}


