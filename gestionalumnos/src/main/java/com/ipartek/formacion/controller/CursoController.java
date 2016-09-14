package com.ipartek.formacion.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.dao.persistencia.Alumno;
import com.ipartek.formacion.dao.persistencia.Curso;
import com.ipartek.formacion.service.CursoServiceImp;


@Controller
@RequestMapping(value = "/cursos")
public class CursoController {
	
	private static final Logger logger = LoggerFactory.getLogger(CursoController.class);


	@Autowired
	private CursoServiceImp cs = null;
	private ModelAndView mav = null;

	@Autowired
	@Qualifier("cursoValidator")
	private Validator validator;
	
	@InitBinder
	  private void initBinder(WebDataBinder binder) {
			binder.setValidator(validator);
	  }
	
	@RequestMapping(value = "/{id}", method = { RequestMethod.POST,
			RequestMethod.DELETE })
	public ModelAndView delete(@PathVariable("id") int id) {

		this.mav = new ModelAndView("cursos/listado");
		this.cs.delete(id);
		return this.mav;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id") int id) {

		this.mav = new ModelAndView("cursos/curso");
		Curso curso = this.cs.getById(id);
		this.mav.addObject("curso", curso);
		return this.mav;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {

		this.mav = new ModelAndView("cursos/listado");
		List<Curso> cursos = this.cs.getAll();
		this.mav.addObject("listado-cursos", cursos);
		return this.mav;
	}
	
	@RequestMapping(value = "/addCurso", method = RequestMethod.GET)
	public String addCursos(Model model){
		model.addAttribute("curso", new Curso());
		return "cursos/curso";
	}
	
	@RequestMapping(value = "/saveCurso", method = RequestMethod.POST)
	public String saveCurso(@ModelAttribute("curso")@Validated(Curso.class) Curso curso){
		
		if(curso.getCodigo() > 0){
			this.cs.update(curso);
		}else{
			this.cs.create(curso);
		}
		return "redirect:cursos";
	}
	/*
	private Curso parseCurso(HttpServletRequest req) {

		Curso curso = new Curso();
		curso.setCodigo(Integer.parseInt(req.getParameter("codCurso")));
		curso.setNombre(req.getParameter("nombre"));
		return curso;

	}*/
}
