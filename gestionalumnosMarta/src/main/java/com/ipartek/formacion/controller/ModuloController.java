package com.ipartek.formacion.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping(value="/addAlumno" , method = RequestMethod.GET) //recibe como parámetro la acción,y busca una ruta cuyo requestmapping sea el del return
	public String addAlumno(Model model){
		model.addAttribute("modulo", new Modulo());
		
		return "modulos/modulo"; 
	}
	
	//método para update y create 
	@RequestMapping(value="modulos/save" , method = RequestMethod.POST)
	public String saveModulo(@ModelAttribute("modulo") Modulo modulo){ //recibe un objeto de tipo Alumno y devuelve la ruta donde lo queremos
		//en @ModelAttribute le ponemos el nombre del objeto que hemos puesto en el formulario en el comandName
		if(modulo.getCodigo()>0){
			as.update(modulo);
		}else{
			as.create(modulo);
		}
		return "redirect:/modulos"; 
	}
	
	@RequestMapping(method = {RequestMethod.POST,RequestMethod.DELETE}, value= "/{id}")
	public String delete(@PathVariable("id") int id){ //indicamos el tipo de parametro que recibe
		mav = new ModelAndView("/modulos/listado"); //indicamos la vista
		as.delete(id);
		
		return "redirect:/modulos";
	}
	

	
	private Modulo parseModulo(HttpServletRequest req) {
		Modulo modulo = new Modulo();
		
		modulo.setCodigo(Integer.parseInt(req.getParameter("codigo")));
		modulo.setNombre(req.getParameter("nombre-modulo"));
		
		return modulo;
	}
}
