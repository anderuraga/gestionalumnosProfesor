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

import com.ipartek.formacion.dao.persistencia.Modulo;
import com.ipartek.formacion.service.ModuloServiceImp;

@Controller
@RequestMapping(value = "/modulos")
public class ModuloController extends MultiActionController {

	@Autowired
	private ModuloServiceImp moduloServiceImp;
	private ModelAndView mav;

	@RequestMapping(value = "/{id}", method = { RequestMethod.POST,
			RequestMethod.DELETE })
	public ModelAndView delete(@PathVariable("id") int id) {

		this.mav = new ModelAndView("modulos/listado");
		this.moduloServiceImp.delete(id);
		return this.mav;
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
	public String addModulos(Model model){
		model.addAttribute("modulo");
		return "/modulos/modulo";
	}
	
	public String saveModulo(@ModelAttribute("modulo") Modulo modulo){
		
		if(modulo.getCodigo() > 0){
			this.moduloServiceImp.update(modulo);
		}else{
			this.moduloServiceImp.create(modulo);
		}
		return "redirect:modulos";
	}
	/*
	private Modulo parseModulo(HttpServletRequest req) {

		Modulo modulo = new Modulo();
		modulo.setCodigo(Integer.parseInt(req.getParameter("codModulo")));
		modulo.setNombre(req.getParameter("nombre"));
		return modulo;
	}*/
}