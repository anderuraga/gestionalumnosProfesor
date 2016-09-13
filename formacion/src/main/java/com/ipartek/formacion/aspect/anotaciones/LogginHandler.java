package com.ipartek.formacion.aspect.anotaciones;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginHandler {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Around("controller() && allMethod()")
	public void logBefore(JoinPoint joinPoint){
		log.info("Se ejecuta antes de las clases Controller.");
		
		log.debug("Entering in Method :  " + joinPoint.getSignature().getName());
		log.debug("Class Name :  " + joinPoint.getSignature().getDeclaringTypeName());
		log.debug("Arguments :  " + Arrays.toString(joinPoint.getArgs()));
		log.debug("Target class : " + joinPoint.getTarget().getClass().getName());
	}
}
