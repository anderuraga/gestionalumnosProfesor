package com.ipartek.formacion.aspect;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ipartek.formacion.aspect.anotaciones.anotacion.EmpleadoService;

public class MainAnotacion {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring.xml");
		
		EmpleadoService empService = ctx.getBean(EmpleadoService.class);
		System.out.println(empService.getEmpleado().getNombre());
		empService.getEmpleado().setNombre("Urko");
		empService.getEmpleado().throwException();
		
		ctx.close();
	}
}
