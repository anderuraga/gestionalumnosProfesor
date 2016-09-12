package com.ipartek.formacion.aspect;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

@Service
public class ControlTiempoService {
	
	public void realizarProcesoCorto(){
		try {
			Thread.currentThread();
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void realizarProcesoLargo(){
		try {
			Thread.currentThread();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void provocarFallo(){
		throw new RuntimeErrorException(null, "Excepcion provocada.");
	}
	
	public void proceso(long tiempo){
		try {
			Thread.currentThread();
			Thread.sleep(tiempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
