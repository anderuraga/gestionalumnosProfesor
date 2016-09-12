package com.ipartek.formacion.aspect;

import javax.management.RuntimeErrorException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;
import org.springframework.util.StopWatch.TaskInfo;

public class ControlTiempo {
	public Object control(ProceedingJoinPoint pJoinPoint) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		boolean isException = false;
		try {
			return pJoinPoint.proceed();
		} catch (RuntimeErrorException ex) {
			isException = true;
			throw ex;
		}finally{
			stopWatch.stop();
			TaskInfo infoTareas = stopWatch.getLastTaskInfo();
			String mensaje = infoTareas.getTaskName();
			mensaje += ": " + infoTareas.getTimeMillis() + " ms " + (isException ? "Excepcion Lanzada" : "");
			System.out.println(mensaje);
		}

	}
}
