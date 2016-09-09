package com.ipartek.formacion.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ipartek.formacion.dao.persistence.Alumno;
import com.ipartek.formacion.dao.persistence.Modulo;
import com.ipartek.formacion.service.ModuloServiceImp;
import com.ipartek.formacion.service.interfaces.ModuloService;

@Controller
@RequestMapping(value="/modulos")
public class ModuloController extends MultiActionController{
	private static final Logger logger = LoggerFactory.getLogger(ModuloController.class);
	@Autowired 
	private ModuloService msi = null;
	
	private ModelAndView mav = null;
	
	@RequestMapping(method = RequestMethod.GET)
	private ModelAndView getAll(){
		
		List<Modulo> modulos = null;
		mav = new ModelAndView("/modulos/listado");
		modulos = msi.getAll();
		
		mav.addObject("listaModulos", modulos);
		
		return mav;
		
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id") int id){
		
		mav = new ModelAndView("/modulos/modulos");
		
		Modulo modulo = msi.getById(id);
		logger.trace(modulo.getNombre());
		mav.addObject("modulo", modulo);
		
		return mav;
		
	}
	
	@RequestMapping("/save")
	public String saveModulo(@ModelAttribute("modulo") Modulo modulo){
		
		if(modulo.getCodigo()>0)
		{
			msi.update(modulo);
		}
		else
		{
			msi.create(modulo);
		}
		
		return "redirect:/modulos";
	}

	@RequestMapping("/addModulo")
	public String addModulo(Model model){
		model.addAttribute("modulo", new Modulo());
		return "modulos/modulos";
	}
}
