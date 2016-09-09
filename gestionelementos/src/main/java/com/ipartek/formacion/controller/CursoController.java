package com.ipartek.formacion.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ipartek.formacion.dao.persistence.Curso;
import com.ipartek.formacion.service.interfaces.CursoService;

@Controller
@RequestMapping(value = "/cursos")
public class CursoController{
	private static final Logger logger = LoggerFactory
			.getLogger(CursoController.class);
	@Autowired
	private CursoService cuse = null;
	private ModelAndView mav = null;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		mav = new ModelAndView("cursos/listadoCursos");
		List<Curso> cursos = cuse.getAll();
		logger.info("numero de cursos " + cursos.size());
		mav.addObject("listado-cursos", cursos);

		return mav;
	}

	/* ########################### GET BY ID ############################### */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id") int id) {
		mav = new ModelAndView("cursos/curso");
		Curso curso = cuse.getById(id);
		mav.addObject("curso", curso);
		return mav;
	}

	/* ########################### DELETE ################################## */

	@RequestMapping(value = "/{id}", method = { RequestMethod.POST,
			RequestMethod.DELETE })
	public ModelAndView Delete(@PathVariable("id") int id) {
		mav = new ModelAndView("cursos/listado");
		cuse.delete(id);
		return mav;
	}

	/* ########################### SAVE ##################################### */

	@RequestMapping(value = "/saveCurso", method = RequestMethod.POST)
	public String saveCurso(@ModelAttribute("curso") Curso curso) {
		if (curso.getCodigo() > 0) {
			cuse.update(curso);
		} else {
			cuse.create(curso);
		}
		return "redirect:/cursos";

	}

	/* ########################### UPDATE ############################### */
/*
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest req, HttpServletResponse res) {
		Curso curso = update(req);
		cuse.update(curso);
		return mav;

	}
*/
	/* ########################### CREATE ####################################### */

	@RequestMapping(value = "/newCurso", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("curso", new Curso());
		return "cursos/curso";
	}


}