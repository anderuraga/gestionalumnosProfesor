//package com.ipartek.formacion.aspect.anotaciones.log;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StopWatch;
//
//@Aspect
//@Component
//public class Logger {
//	Logger Log = (Logger) LoggerFactory.getLogger(Logger.class);
//	
//	@Around("execution(* com.ipartek.formacion.controller.*.*())")
//	
//	public Object logTimeMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//
//		StopWatch stopWatch = new StopWatch();
//		stopWatch.start();
//
//		Object retVal = joinPoint.proceed();
//
//		stopWatch.stop();
//
//		StringBuffer logMessage = new StringBuffer();
//		logMessage.append(joinPoint.getTarget().getClass().getName());
//		logMessage.append(".");
//		logMessage.append(joinPoint.getSignature().getName());
//		logMessage.append("(");
//		// append args
//		Object[] args = joinPoint.getArgs();
//		for (int i = 0; i < args.length; i++) {
//			logMessage.append(args[i]).append(",");
//		}
//		if (args.length > 0) {
//			logMessage.deleteCharAt(logMessage.length() - 1);
//		}
//
//		logMessage.append(")");
//		logMessage.append(" execution time: ");
//		logMessage.append(stopWatch.getTotalTimeMillis());
//		logMessage.append(" ms");
////		Log.info(logMessage.toString());
//		return retVal;
//}
//	
//	
//	
//
//}
