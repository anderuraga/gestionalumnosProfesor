package com.ipartek.formacion.aspect;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ipartek.formacion.aspect.anotaciones.Empleado;
import com.ipartek.formacion.aspect.anotaciones.EmpleadoService;


public class MainAnotaciones {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring.xml");
		EmpleadoService empleadoService = ctx.getBean(EmpleadoService.class);
		System.out.println(empleadoService.getEmpleado().getNombre());
		empleadoService.getEmpleado().setNombre("Anabel");
		empleadoService.getEmpleado().throwException();
		ctx.close();
	}

}
