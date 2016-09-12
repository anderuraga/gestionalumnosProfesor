package com.ipartek.formacion.aspect;

//crear servicio q este parado
import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ControlTiempoService {
	
	public void realizarProcesoCorto(){
		try {
			Thread.currentThread().sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void realizarProcesoLargo(){
		try {
			Thread.currentThread().sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void provocarFallo(){
		throw new RuntimeErrorException(null, "Excepcion provocada");
	}
	public void proceso(long tiempo){
		try {
			Thread.currentThread().sleep(tiempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
