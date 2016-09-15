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

import com.ipartek.formacion.dao.persistence.Curso;
import com.ipartek.formacion.dao.persistence.Modulo;
import com.ipartek.formacion.service.ModuloServiceImp;

@Controller
@RequestMapping(value = "/modulos")
public class ModuloController  {
	
	private static final Logger logger = LoggerFactory.getLogger(ModuloController.class);
	@Autowired
	private ModuloServiceImp mod = null;
	private ModelAndView mav = null;
	
	@Autowired
	@Qualifier("moduloValidator")
	private Validator validator;
	
	@InitBinder
	private void InitBinder(WebDataBinder binder){
		binder.setValidator(validator);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {

		mav = new ModelAndView("modulos/listado");
		List<Modulo> modulos = mod.getAll();
		mav.addObject("listado-modulos", modulos);
		return mav;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getByID(@PathVariable("id") int id) {
		mav = new ModelAndView("modulos/modulo");
		Modulo modulo = mod.getByID(id);
		mav.addObject("modulo", modulo);
		return mav;
	}

	@RequestMapping(value = "deleteModulo/{id}")
	public String delete(@PathVariable("id") int id) {
		mod.delete(id);
		return "redirect:/modulos";
	}
	
	@RequestMapping(value="/addModulo", method=RequestMethod.GET)
	public String addModulo(Model model){
		model.addAttribute("modulo", new Modulo());
		return "modulos/modulo";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest req, HttpServletResponse res) {
		mav = new ModelAndView("modulos/listado");
		Modulo modulo = parseModulo(req);
		mod.update(modulo);
		mav.addObject("listado-modulos", modulo);
		return mav;
	}

	@RequestMapping(value="/save")
	public String saveAlumno(@ModelAttribute("modulo") @Validated(Modulo.class) Modulo modulo, BindingResult bindingResult){//el objeto del model attribute se llama igual que el commandName del formulario, será lo que recibirá encapsulado
		//el objeto del model attribute se llama igual que el commandName del formulario, será lo que recibirá encapsulado
		//@Validated se usa para obligar a validar los datos a guardar usando ModuloValidator, 
		//se puede usar el validador de java @Min cambiando el @Validated por @Valid
		
		String destino ="";
		if(bindingResult.hasErrors()){
			logger.info("El modulo tiene errores");
			destino = "modulos/modulo"; 
			//como tiene errores, lo manda otra vez a la pagina de modulo nuevo.
		}else{
			destino = "redirect:/modulos"; // ofuscacion de URL
			if(modulo.getCodigo()>0){
				mod.update(modulo);
			}else{
					mod.create(modulo);
			}
		}
		
		return destino; 
	}


	private Modulo parseModulo(HttpServletRequest req) {
		Modulo modulo = null;
		int codigo = Integer.parseInt(req.getParameter("codigo"));
		modulo.setCodigo(codigo);
		String nombre = req.getParameter("nombre");
		modulo.setNombre(nombre);

		return modulo;
	}
	
	@RequestMapping(value="/restclients", method=RequestMethod.GET)
	public String sendToRestGetAll(){
		return "/modulos/listado_rest";
	}
}
