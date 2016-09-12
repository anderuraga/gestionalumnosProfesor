package com.ipartek.formacion.aspect;


import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;
//usaremos anotaciones en vez de usar el XML
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
	
	public void realizarProcesoLargo(){
		try {
			Thread.currentThread();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void provocarFallo(){
		throw new RuntimeErrorException(null, "Excepcion provocada");
	}
	
	public void proceso (long tiempo){
		try {
			Thread.currentThread();
			Thread.sleep(tiempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}