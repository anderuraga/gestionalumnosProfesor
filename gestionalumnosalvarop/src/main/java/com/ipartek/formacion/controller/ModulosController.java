package com.ipartek.formacion.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class ModulosController extends MultiActionController{
	private static final Logger logger = LoggerFactory.getLogger(ModulosController.class);
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
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView update(HttpServletRequest req, HttpServletResponse res){
		mav=new ModelAndView("modulos/listado");
		Modulo modulo=parseModulo(req);
		mav.addObject("modulo",modulo);
		return mav;
	}
	
	private Modulo parseModulo(HttpServletRequest req){
		Modulo modulo=new Modulo();
		int codigo = Integer.parseInt(req.getParameter("codigo"));
		String nombre=req.getParameter("nombre-modulo");
		modulo.setCodigo(codigo);
		modulo.setNombre(nombre);
		
		

		return modulo;
	}
	
	
}
