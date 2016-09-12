package com.ipartek.formacion.aspect;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

@Service
public class ControlTiempoService {
	
	public void realizarProcesoCorto(){
		Thread.currentThread();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	public void realizarProcesoLargo(){
		Thread.currentThread();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	public void provocarFallo(){
		throw new RuntimeErrorException(null,"Excepcion provocada");
	}
	
	public void proceso(long tiempo){
		Thread.currentThread();
		try {
			Thread.sleep(tiempo);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

}
