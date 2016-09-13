package com.ipartek.formacion.controller;

import java.util.List;







import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
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
	private Logger logger;

	@Autowired
	@Qualifier("cursoValidator")
	private Validator validator;
	
	@org.springframework.web.bind.annotation.InitBinder
	private void InitBinder(WebDataBinder binder){
		binder.setValidator(validator);
}
	@RequestMapping(value = "delete/{id}", method = { RequestMethod.GET,
			RequestMethod.DELETE })
	public String delete(@PathVariable("id") int id) {

		this.cursoService.delete(id);
		return "redirect:/cursos";
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
	public String addCursos(Model model) {
		model.addAttribute("curso", new Curso());
		return "cursos/curso";
	}

	@RequestMapping(value = "/saveCurso", method = RequestMethod.POST)
	public String saveCurso(@ModelAttribute("curso") @Validated Curso curso,
			BindingResult bindingResult) {

		String destino = "";

		if (bindingResult.hasErrors()) {
			logger.info("El curso tiene errores");
			destino = "/cursos/curso";
		} else {
			destino = "redirect:/cursos";
			if (curso.getCodigo() > 0) {
				this.cursoService.update(curso);
			} else {
				this.cursoService.create(curso);
			}
		}
		return destino;
	}
	/*
	 * private Curso parseCurso(HttpServletRequest req) {
	 * 
	 * Curso curso = new Curso();
	 * curso.setCodigo(Integer.parseInt(req.getParameter("codCurso")));
	 * curso.setNombre(req.getParameter("nombre")); return curso;
	 * 
	 * }
	 */
}
