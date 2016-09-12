package com.ipartek.formacion.aspect;

import javax.management.RuntimeErrorException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;
import org.springframework.util.StopWatch.TaskInfo;

public class ControlTiempos {

	public Object control(ProceedingJoinPoint pJoinPoint) throws Throwable{
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		boolean isException = false;
		
		try {
			return pJoinPoint.proceed(); //lanzamos el procedimiento
		} catch (RuntimeErrorException e) {
			isException = true;
			throw e;
		}finally{
			stopWatch.stop();
			TaskInfo infoTareas = stopWatch.getLastTaskInfo(); //guardo la información de la ultima tarea
			String mensaje = infoTareas.getTaskName(); //obtengo el nombre
			mensaje += ": " +infoTareas.getTimeMillis()+" ms"+ (isException? " Excepcion Lanzada" : ""); //obtengo el tiempo que la tarea ha estado en ejecución y la excepcion lanzada
		
			System.out.println(mensaje);
		}
	}
}
