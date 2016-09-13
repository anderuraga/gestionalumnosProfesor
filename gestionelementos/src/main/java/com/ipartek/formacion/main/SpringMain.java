package com.ipartek.formacion.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ipartek.formacion.service.EmpleadoService;

public class SpringMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		EmpleadoService employeeService = ctx.getBean("empleadoService", EmpleadoService.class);
		
		System.out.println(employeeService.getEmpleado().getName());
		
		employeeService.getEmpleado().setName("Urko Villanueva");
		
		employeeService.getEmpleado().throwException();
		
		ctx.close();
	}

}