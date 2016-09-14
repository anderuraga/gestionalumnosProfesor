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

import com.ipartek.formacion.dao.persistencia.Alumno;
import com.ipartek.formacion.dao.persistencia.Modulo;
import com.ipartek.formacion.service.ModuloServiceImp;

@Controller
@RequestMapping(value = "/modulos")
public class ModuloController extends MultiActionController {

	private static final Logger logger = LoggerFactory.getLogger(ModuloController.class);

	
	@Autowired
	private ModuloServiceImp ms = null;
	private ModelAndView mav = null;
	
	@Autowired
	@Qualifier("moduloValidator")
	private Validator validator;
	
	@InitBinder
	  private void initBinder(WebDataBinder binder) {
			binder.setValidator(validator);
	  }

	@RequestMapping(value = "/{id}", method = { RequestMethod.POST, RequestMethod.DELETE })
	public ModelAndView delete(@PathVariable("id") int id) {

		this.mav = new ModelAndView("modulos/listado");
		this.ms.delete(id);
		return this.mav;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id") int id) {

		this.mav = new ModelAndView("modulos/modulo");
		Modulo modulo = this.ms.getById(id);
		this.mav.addObject("modulo", modulo);
		return this.mav;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {

		this.mav = new ModelAndView("modulos/listado");
		List<Modulo> modulos = this.ms.getAll();
		this.mav.addObject("listado-modulos", modulos);
		return this.mav;
	}

	@RequestMapping(value = "/addModulo", method = RequestMethod.GET)
	public String addModulos(Model model){
		model.addAttribute("modulo");
		return "/modulos/modulo";
	}
	
	
	@RequestMapping(value = "/saveModulo", method = RequestMethod.POST)
	public String saveModulo(@ModelAttribute("modulo")  @Validated(Modulo.class) Modulo modulo, BindingResult bindingResult){
		
String destino ="";
		
		if(bindingResult.hasErrors()){
			logger.info("El modulo tiene errores");
			destino = "modulos/modulo"; 
			//como tiene errores, lo manda otra vez a la pagina de alumno nuevo.
		}else{
			destino = "redirect:/modulos";
			if(modulo.getCodigo()>0){
				ms.update(modulo);
			}else{
				ms.create(modulo);
			}
		}
		
		return destino; // ofuscacion de URL
	}
	/*
	private Modulo parseModulo(HttpServletRequest req) {

		Modulo modulo = new Modulo();
		modulo.setCodigo(Integer.parseInt(req.getParameter("codModulo")));
		modulo.setNombre(req.getParameter("nombre"));
		return modulo;
	}*/
}
