package com.ipartek.formacion.aspect.anotaciones;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAnotacion {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		EmpleadoService empService=ctx.getBean(EmpleadoService.class);
		empService.getEmpleado().setNombreEmpleado("York");
		System.out.println(empService.getEmpleado().getNombreEmpleado());
		
		empService.getEmpleado().throwException();
		ctx.close();
	}

}
