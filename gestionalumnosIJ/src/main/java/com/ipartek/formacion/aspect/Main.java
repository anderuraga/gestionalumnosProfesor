package com.ipartek.formacion.aspect;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:/spring.xml");
		ControlTiempoService ctService = ctx.getBean(ControlTiempoService.class);
		for (int i = 0; i < 10; i++) {
			ctService.realizarProcesoCorto();
		}
		ctService.realizarProcesoLargo();
		ctService.provocarFallo();
		ctx.close();
	}

}
