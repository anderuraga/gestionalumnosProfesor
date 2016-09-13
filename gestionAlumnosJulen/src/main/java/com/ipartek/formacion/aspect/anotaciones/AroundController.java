package com.ipartek.formacion.aspect.anotaciones;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class AroundController {
	
	private static final Logger logger = LoggerFactory.getLogger(AroundController.class);

	@Around("execution(* com.ipartek.formacion.controller.*.*())")
	public Object controllerAround(ProceedingJoinPoint proceeding){
		Object valor = null;
		logger.debug("AroundController logger antes de invocar metodos");
		try {
			valor = proceeding.proceed();
			logger.debug("valor nombre clase"+valor.getClass().getName());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("AroundController logger despues de los metodos");
		return valor;
	}
}


