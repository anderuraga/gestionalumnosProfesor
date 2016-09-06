package com.ipartek.formacion.controller;

import java.util.List;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.dao.persistence.Alumno;
import com.ipartek.formacion.dao.persistence.Candidato;
import com.ipartek.formacion.dao.persistence.Curso;
import com.ipartek.formacion.dao.persistence.Modulo;
import com.ipartek.formacion.service.interfaces.AlumnoService;
import com.ipartek.formacion.service.interfaces.CandidatoService;
import com.ipartek.formacion.service.interfaces.CursoService;
import com.ipartek.formacion.service.interfaces.ModuloService;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired AlumnoService alse;
	@Autowired CandidatoService cdse;
	@Autowired CursoService cuse;
	@Autowired ModuloService mose;
	
	
//	@Resource(name = "alumnoServiceImp")AlumnoService alse;
//	@Resource(name = "candidatoServiceImp")CandidatoService cdse;
//	@Resource(name = "cursoServiceImp")CursoService cuse;
//	@Resource(name = "moduloServiceImp")ModuloService mose;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mav = null;
		mav = new ModelAndView("home");

		List<Alumno> alumnos = alse.getAll();
		List<Candidato> candidatos = cdse.getAll();
		List<Curso> cursos = cuse.getAll();
		List<Modulo> modulos = mose.getAll();
		
		logger.info("Carga la página web");
		logger.info("numero de alumnos "+ alumnos.size());
		logger.info("numero de candidatos "+ candidatos.size());
		logger.info("numero de cursos "+ cursos.size());
		logger.info("numero de modulos "+ modulos.size());
		
		mav.addObject("listado-alumnos", alumnos);
		mav.addObject("listado-candidatos", candidatos);
		mav.addObject("listado-cursos", cursos);
		mav.addObject("listado-modulos", modulos);
		return mav;
	}
}