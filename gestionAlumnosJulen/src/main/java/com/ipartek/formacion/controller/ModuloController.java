package com.ipartek.formacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ipartek.formacion.dao.persistence.Modulo;
import com.ipartek.formacion.service.ModuloServiceImp;

@Controller
@RequestMapping(value="/modulos")
public class ModuloController extends MultiActionController{
	
	@Autowired 
	private ModuloServiceImp msi = null;
	
	private ModelAndView mav = null;
	
	@RequestMapping(method = RequestMethod.GET)
	private ModelAndView getAll(){
		
		List<Modulo> modulos = null;
		mav = new ModelAndView("/modulos/listado");
		modulos = msi.getAll();
		
		mav.addObject("listaModulos", modulos);
		
		return mav;
		
	}

}
