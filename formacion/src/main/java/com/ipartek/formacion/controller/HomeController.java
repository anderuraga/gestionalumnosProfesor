package com.ipartek.formacion.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	AlumnoService as;
	@Autowired
	CursoService cs;
	@Autowired
	ModuloService ms;
	
	@RequestMapping(value = {"/","home"}, method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mav = null;
		mav = new ModelAndView("home");
		
		logger.info("Carga la pagina web");
		
		List<Alumno> alumnos = as.getAll();
		mav.addObject("listado-alumnos", alumnos);
		
		List<Curso> cursos = cs.getAll();
		mav.addObject("listado-cursos", cursos);
		
		List<Modulo> modulos = ms.getAll();
		mav.addObject("listado-modulos", modulos);
		
		return mav;
	}
	
}
