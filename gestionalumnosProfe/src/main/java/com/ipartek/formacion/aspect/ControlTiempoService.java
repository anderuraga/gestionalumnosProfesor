package com.ipartek.formacion.aspect;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

@Service
public class ControlTiempoService {
	public void realizarProcesoCorto() {
		try {
			Thread.currentThread();
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void realizarProcesoLargo(long tiempo) {
		Thread.currentThread();
		try {
			Thread.sleep(tiempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void provocarFallo() {
		throw new RuntimeErrorException(null, "Excepcion provocada");
	}
}
