package com.ipartek.formacion.aspect.anotaciones;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAnotacion {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:/spring.xml");

		EmpleadoService empService = ctx.getBean(EmpleadoService.class);
		System.out.println(empService.getEmpleado().getNombre());
		empService.getEmpleado().setNombre("Triqui");
		// empService.getEmpleado
		ctx.close();
	}
}
