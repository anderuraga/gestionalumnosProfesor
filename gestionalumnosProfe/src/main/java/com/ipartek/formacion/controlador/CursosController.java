package com.ipartek.formacion.controlador;

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

import com.ipartek.formacion.dao.persistence.Curso;
import com.ipartek.formacion.service.interfaces.CursosService;

@Controller
@RequestMapping(value = "/cursos")
public class CursosController extends MultiActionController {
	@Autowired
	private CursosService cService = null;
	private ModelAndView mav = null;
	@Autowired
	@Qualifier("cursoValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		mav = new ModelAndView("/cursos/listado");
		mav.addObject("listaCursos", cService.getAll());
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView getById(@PathVariable("id") int id) {
		mav = new ModelAndView("/cursos/curso");
		mav.addObject("curso", cService.getById(id));
		return mav;
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.DELETE }, value = "/{id}")
	public String delete(@PathVariable("id") int id) {
		cService.delete(id);
		return "redirect:/cursos";
	}

	@RequestMapping(value = "/addCurso")
	public String addCurso(Model model) {
		model.addAttribute("curso", new Curso());
		return "/cursos/curso";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCurso(@ModelAttribute("curso") @Validated Curso curso,
			BindingResult bindingResult, Model model) {
		String destino = "";
		if (bindingResult.hasErrors()) {
			destino ="/cursos/curso";
			logger.info("Curso tiene errores");
		} else {
			destino ="redirect:/cursos";
			if (curso.getCodigo() > 0) {
				cService.update(curso);
			} else {
				cService.create(curso);
			}
		}
		return destino;
	}
}
