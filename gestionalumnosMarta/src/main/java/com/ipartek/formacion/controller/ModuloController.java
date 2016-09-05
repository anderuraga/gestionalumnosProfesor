package com.ipartek.formacion.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.dao.persistencia.Modulo;
import com.ipartek.formacion.service.interfaces.ModuloService;

@Controller
@RequestMapping(value="/modulos") //indicamos que esta CLASE va a gestionar las peticiones que lleven modulos en la url
public class ModuloController {

	
	@Autowired
	private ModuloService as = null;
	private ModelAndView mav = null;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll(){
		mav = new ModelAndView("/modulos/listado"); //indicamos la vista
		List<Modulo> modulos = as.getAll();
		
		mav.addObject("listado-modulos",modulos); //metemos el objeto en la respuesta
		
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView getById(@PathVariable("id") int id){ //indicamos el tipo de parametro que recibe
		mav = new ModelAndView("/modulos/modulo"); //indicamos la vista
		Modulo modulo = as.getById(id);
		
		mav.addObject("modulo",modulo); //metemos el objeto en la respuesta
		
		return mav;
	}
	
	@RequestMapping(method = {RequestMethod.POST,RequestMethod.DELETE}, value= "/{id}")
	public ModelAndView delete(@PathVariable("id") int id){ //indicamos el tipo de parametro que recibe
		mav = new ModelAndView("/modulos/listado"); //indicamos la vista
		as.delete(id);
		
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest req,HttpServletResponse res){
		mav = new ModelAndView("/modulos/listado");
		Modulo modulo = parseModulo(req);
		as.update(modulo);
		
		return mav;
	}
	
	public ModelAndView create(HttpServletRequest req,HttpServletResponse res){
		
		return mav;
	}
	
	private Modulo parseModulo(HttpServletRequest req) {
		Modulo modulo = new Modulo();
		
		modulo.setCodigo(Integer.parseInt(req.getParameter("codigo")));
		modulo.setNombre(req.getParameter("nombre-modulo"));
		
		return modulo;
	}
}
