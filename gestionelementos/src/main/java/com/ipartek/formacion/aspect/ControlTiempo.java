package com.ipartek.formacion.aspect;

import javax.management.RuntimeErrorException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;
import org.springframework.util.StopWatch.TaskInfo;

public class ControlTiempo {
//en este caso, en vez de usar anotaciones, funcionar� por XML
	public Object control(ProceedingJoinPoint pJoinPoint) throws Throwable{ 
		//es object, ya que al ser muy abstracto, no sabemos a que objeto se lo aplicaremos. Asi sirve para todos los metodos
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		boolean isException = false;
		try{
			return pJoinPoint.proceed();
		}catch(RuntimeErrorException e){
			isException = true;
			throw e;
		}finally{
			stopWatch.stop();
			TaskInfo infoTareas = stopWatch.getLastTaskInfo();
			String mensaje = infoTareas.getTaskName();
			mensaje += ": "+infoTareas.getTimeMillis()+" ms"+ (isException? "Excepci�n lanzada: " : "");
			System.out.println(mensaje);
		}
		
		
		
	}
}