/**
 * 
 */
package com.ipartek.formacion.aspect;

import javax.management.RuntimeErrorException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;
import org.springframework.util.StopWatch.TaskInfo;

/**
 * @author Curso
 *
 */
public class ControlTiempos {
//gestiona joinpoint
	public Object control (ProceedingJoinPoint pJoinPoint) throws Throwable{
		StopWatch sWatch=new StopWatch();
		sWatch.start();
		boolean isException=false;
		
		
		try {
			return pJoinPoint.proceed();
		} catch (RuntimeErrorException e) {
			isException=true;
			throw e;
		}finally{
			sWatch.stop();
			TaskInfo infoTareas=sWatch.getLastTaskInfo();
			String mensaje=infoTareas.getTaskName();
			mensaje+=": "+infoTareas.getTimeMillis()+"ms "+(isException? " Exception Lanzada":"");
			
			System.out.println(mensaje);
		}
		
	}
	
		
}
