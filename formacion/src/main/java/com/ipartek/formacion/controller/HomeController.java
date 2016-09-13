package com.ipartek.formacion.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.dao.persistence.Alumno;
import com.ipartek.formacion.dao.persistence.Curso;
import com.ipartek.formacion.dao.persistence.Modulo;
import com.ipartek.formacion.service.interfaces.AlumnoService;
import com.ipartek.formacion.service.interfaces.CursoService;
import com.ipartek.formacion.service.interfaces.ModuloService;

/**
 * Handles requests for the application home page.
 */
@Controller

public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	AlumnoService as;
	@Autowired
	CursoService cs;
	@Autowired
	ModuloService ms;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {
		ModelAndView mav = null;
		mav=new ModelAndView("home");
		logger.info("Welcome home! The client locale is {}.", locale);
		List<Alumno>alumnos=as.getAll();
		List<Curso>cursos=cs.getAll();
		List<Modulo>modulos=ms.getAll();
		
		
		mav.addObject("listado-alumnos",alumnos);
		mav.addObject("listado-cursos",cursos);
		mav.addObject("listado-modulos",modulos);
		
		return mav;
	}
	
}
