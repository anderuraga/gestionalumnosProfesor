package com.ipartek.formacion.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ipartek.formacion.dao.persistencia.Modulo;
import com.ipartek.formacion.service.ModuloServiceImp;

@Controller
@RequestMapping(value = "/modulos")
public class ModuloController extends MultiActionController {

	@Autowired
	private ModuloServiceImp moduloServiceImp;
	private ModelAndView mav;
	
	@Autowired
	@Qualifier("moduloValidator")
	private Validator validator;
	
	@org.springframework.web.bind.annotation.InitBinder
	private void InitBinder(WebDataBinder binder){
		binder.setValidator(validator);
}

	@RequestMapping(value = "delete/{id}", method = { RequestMethod.GET,
			RequestMethod.DELETE })
	public String delete(@PathVariable("id") int id) {

		this.moduloServiceImp.delete(id);
		return "redirect:/modulos";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id") int id) {

		this.mav = new ModelAndView("modulos/modulo");
		Modulo modulo = this.moduloServiceImp.getById(id);
		this.mav.addObject("modulo", modulo);
		return this.mav;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {

		this.mav = new ModelAndView("modulos/listado");
		List<Modulo> modulos = this.moduloServiceImp.getAll();
		this.mav.addObject("listado-modulos", modulos);
		return this.mav;
	}

	@RequestMapping(value = "/addModulos", method = RequestMethod.GET)
	public String addModulos(Model model) {
		model.addAttribute("modulo",new Modulo());
		return "/modulos/modulo";
	}

	@RequestMapping(value = "/saveModulo", method = RequestMethod.POST)
	public String saveModulo(
			@ModelAttribute("modulo") @Validated(Modulo.class) Modulo modulo,
			BindingResult bindingResult) {

		String destino = "";
		if (bindingResult.hasErrors()) {
			destino = "modulos/modulo";
		} else {
			destino = "redirect:/modulos";
			if (modulo.getCodigo() > 0) {
				this.moduloServiceImp.update(modulo);
			} else {
				this.moduloServiceImp.create(modulo);
			}
		}
		return destino;
	}
	/*
	 * private Modulo parseModulo(HttpServletRequest req) {
	 * 
	 * Modulo modulo = new Modulo();
	 * modulo.setCodigo(Integer.parseInt(req.getParameter("codModulo")));
	 * modulo.setNombre(req.getParameter("nombre")); return modulo; }
	 */
}
