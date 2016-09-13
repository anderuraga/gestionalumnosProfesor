package com.ipartek.formacion.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.dao.persistencia.Curso;
import com.ipartek.formacion.service.CursoServiceImp;


@Controller
@RequestMapping(value = "/cursos")
public class CursoController {

	@Autowired
	private CursoServiceImp cursoService;
	private ModelAndView mav;

	@RequestMapping(value = "/{id}", method = { RequestMethod.POST,
			RequestMethod.DELETE })
	public ModelAndView delete(@PathVariable("id") int id) {

		this.mav = new ModelAndView("cursos/listado");
		this.cursoService.delete(id);
		return this.mav;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id") int id) {

		this.mav = new ModelAndView("cursos/curso");
		Curso curso = this.cursoService.getById(id);
		this.mav.addObject("curso", curso);
		return this.mav;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {

		this.mav = new ModelAndView("cursos/listado");
		List<Curso> cursos = this.cursoService.getAll();
		this.mav.addObject("listado-cursos", cursos);
		return this.mav;
	}
	
	@RequestMapping(value = "/addCursos", method = RequestMethod.GET)
	public String addCursos(Model model){
		model.addAttribute("curso", new Curso());
		return "cursos/curso";
	}
	
	@RequestMapping(value = "/saveCurso", method = RequestMethod.POST)
	public String saveCurso(@ModelAttribute("curso")Curso curso){
		
		if(curso.getCodigo() > 0){
			this.cursoService.update(curso);
		}else{
			this.cursoService.create(curso);
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
