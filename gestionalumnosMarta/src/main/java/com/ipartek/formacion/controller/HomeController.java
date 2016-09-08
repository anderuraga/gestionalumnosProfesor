package com.ipartek.formacion.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.dao.persistencia.Alumno;
import com.ipartek.formacion.service.interfaces.AlumnoService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	
	@Autowired
	AlumnoService as;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		
		ModelAndView mav = null;
		mav = new ModelAndView("home");
		
		logger.info("Carga la pagina web");
		//cargamos la lista de alumnos
		List<Alumno> alumnos = as.getAll();
		//nos devuelve la lista de alumnos a la web que le decimos
		//mav.addObject("listado-alumnos", alumnos);
		
		return mav;
	}
	
}
