package com.ipartek.formacion.main;

import java.util.Random;

import javax.xml.bind.ParseConversionEvent;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.style.ToStringCreator;

import com.ipartek.formacion.service.EmpleadoService;

public class SpringMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");
		EmpleadoService empleadoService = ctx.getBean("empleadoService",
				EmpleadoService.class);
		System.out.println("-----");
		System.out.println(empleadoService.getEmpleado().getName());
		System.out.println("-----");
		empleadoService.getEmpleado().setName(String.valueOf(Math.round(Math.random()*100)));
		System.out.println("-----");
		System.out.println(empleadoService.getEmpleado().getName());
		System.out.println("-----");
//		empleadoService.getEmpleado().throwException();
		ctx.close();
	}

}