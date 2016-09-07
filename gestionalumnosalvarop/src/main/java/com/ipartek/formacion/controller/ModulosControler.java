package com.ipartek.formacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ipartek.formacion.dao.persistencia.Alumno;
import com.ipartek.formacion.dao.persistencia.Modulo;
import com.ipartek.formacion.service.interfaces.ModuloService;
@Controller
@RequestMapping(value="/modulos")
public class ModulosControler extends MultiActionController{
	@Autowired
	private ModuloService ms;
	private ModelAndView mav;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getAll(){

		mav=new ModelAndView("modulos/listado");
		List<Modulo>modulos=ms.getAll();
		mav.addObject("modulos",modulos);
		return mav;
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id")int id){
		mav= new ModelAndView("modulos/modulo");
		Modulo modulo=ms.getByid(id);
		mav.addObject("modulo",modulo);
		return mav;
	}
	
	@RequestMapping(value="/addModulo",method=RequestMethod.GET)
	public String addModulo(Model model){
		model.addAttribute("modulo",new Alumno());
		return "modulos/modulo";
	}
	
	@RequestMapping(value="/{id}",method={RequestMethod.POST,RequestMethod.DELETE})
	public ModelAndView delete(@PathVariable("id")int id){
		mav= new ModelAndView("modulos/listado");
		ms.delete(id);
		return mav;
	}
	
	
}
