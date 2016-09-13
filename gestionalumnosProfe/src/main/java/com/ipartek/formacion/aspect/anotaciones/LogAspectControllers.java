package com.ipartek.formacion.aspect.anotaciones;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LogAspectControllers {
	Logger log = LoggerFactory.getLogger(this.getClass());
		
		
		@Pointcut("within(com.ipartek.formacion.controllers..*)")
		private void logForAnyControllers() {
		}
		@Before("")
		public void logBefore(JoinPoint joinPoint){
			
		}
}

