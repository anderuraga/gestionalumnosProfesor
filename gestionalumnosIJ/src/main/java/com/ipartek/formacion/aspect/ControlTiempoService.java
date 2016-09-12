package com.ipartek.formacion.aspect;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

/**
 * 
 * @author Curso
 * 
 */
@Service
public class ControlTiempoService {
	public void realizarProcesoCorto() {
		Thread.currentThread();
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void realizarProcesoLargo() {
		Thread.currentThread();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void provocarFallo(){
		throw new RuntimeErrorException(null,"Excepción provocada");
	}
	public void proceso(long tiempo){
		Thread.currentThread();
		try {
			Thread.sleep(tiempo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
