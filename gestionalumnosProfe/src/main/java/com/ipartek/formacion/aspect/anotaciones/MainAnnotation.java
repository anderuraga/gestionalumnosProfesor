package com.ipartek.formacion.aspect.anotaciones;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAnnotation {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx= new ClassPathXmlApplicationContext("classpath:/spring");
		EmpleadoService empService = new EmpleadoService();
		empService.getEmpleado().setNombre("Urko");
		
	}

}
