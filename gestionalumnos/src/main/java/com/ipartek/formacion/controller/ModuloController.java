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
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ipartek.formacion.dao.persistence.Curso;
import com.ipartek.formacion.dao.persistence.Modulo;
import com.ipartek.formacion.service.ModuloServiceImp;

@Controller
@RequestMapping(value = "/modulos")

public class ModuloController extends MultiActionController {
	@Autowired
	private ModuloServiceImp mod = null;
	private ModelAndView mav = null;

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
		mav.addObject("modulos", modulo);
		return mav;
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.POST, RequestMethod.DELETE })
	public ModelAndView delete(@PathVariable("id") int id) {
		mav = new ModelAndView("modulos/listado");
		mod.delete(id);
		mav.addObject("listado-modulos");
		return mav;
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
	public String saveAlumno(@ModelAttribute("modulo") Modulo modulo){//el objeto del model attribute se llama igual que el commandName del formulario, será lo que recibirá encapsulado
		if(modulo.getCodigo()>0){
			mod.update(modulo);
		}else{
			mod.create(modulo);
		}
		return "redirect:/cursos"; // ofuscacion de URL
	}


	private Modulo parseModulo(HttpServletRequest req) {
		Modulo modulo = null;
		int codigo = Integer.parseInt(req.getParameter("codigo"));
		modulo.setCodigo(codigo);
		String nombre = req.getParameter("nombre");
		modulo.setNombre(nombre);

		return modulo;
	}
}
