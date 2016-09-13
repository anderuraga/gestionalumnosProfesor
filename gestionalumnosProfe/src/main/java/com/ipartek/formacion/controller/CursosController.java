package com.ipartek.formacion.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ipartek.formacion.dao.persistence.Alumno;
import com.ipartek.formacion.dao.persistence.Curso;
import com.ipartek.formacion.service.interfaces.CursoService;

@Controller
@RequestMapping(value = "/cursos")
public class CursosController extends MultiActionController {
	
	// @Resource(name = "CursoServiceImp")
	@Autowired
	private CursoService as = null;
	private ModelAndView mav = null;
	@Autowired
	@Qualifier("cursoValidator")
	private Validator validator;
	@InitBinder
	private void initBinder(WebDataBinder binder){
		binder.setValidator(validator);
	}
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		mav = new ModelAndView("/cursos/listado");
		List<Curso> cursos = as.getAll();

		mav.addObject("listado_cursos", cursos);
		return mav;
	}
	@RequestMapping(value="/addCurso")
	public String addAlumno(Model model) {
		model.addAttribute("curso", new Curso());
		return "cursos/curso";
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id") int id) {
		mav = new ModelAndView("/cursos/curso");
		Curso curso = as.getById(id);
		mav.addObject("curso", curso);

		return mav;
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.POST,
			RequestMethod.DELETE })
	public ModelAndView delete(@PathVariable("id") int id) {
		mav = new ModelAndView("/cursos/listado");
		as.delete(id);
		return mav;
	}

	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String saveAlumno(@ModelAttribute("curso")  @Validated Curso curso,BindingResult bindingResult,Model model){
		if(bindingResult.hasErrors()){
			logger.info("El curso tiene errores");
			return "cursos/curso";
		}
		if(curso.getCodigo()>0){
			as.update(curso);
		}
		else{
	
		}
		return "redirect:/cursos";
	}

}

