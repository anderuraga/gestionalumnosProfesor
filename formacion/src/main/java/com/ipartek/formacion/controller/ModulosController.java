package com.ipartek.formacion.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ipartek.formacion.dao.persistence.Alumno;
import com.ipartek.formacion.dao.persistence.Modulo;
import com.ipartek.formacion.service.ModuloServiceImp;

@Controller
@RequestMapping(value="/modulos")
public class ModulosController extends MultiActionController {
	@Autowired
	private ModuloServiceImp ms = null;
	private ModelAndView mav = null;
	
	@Autowired
	@Qualifier("moduloValidator")
	private Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder){
		binder.setValidator(validator);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll(){
		mav = new ModelAndView("/modulos/listado");
		List<Modulo> modulos = ms.getAll();
		mav.addObject("listado-modulos", modulos);
		return mav;
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id") int id){
		mav = new ModelAndView("/modulos/modulo");
		Modulo modulo = ms.getById(id);
		mav.addObject("modulo", modulo);
		return mav;
	}
	
	@RequestMapping(value="/addModulo", method=RequestMethod.GET)
	public String addModulo(Model model){
		model.addAttribute("modulo", new Modulo());
		return "modulos/modulo";
	}
	
	@RequestMapping(value="/{id}",method = {RequestMethod.DELETE})
	public ModelAndView delete(@PathVariable("id") int id){
		mav = new ModelAndView("/modulos/listado");
		ms.delete(id);
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest req, HttpServletResponse res){
		mav = new ModelAndView("/modulos/listado");
		Modulo modulo = parseModulo(req);
		return mav;
	}
	
	private Modulo parseModulo(HttpServletRequest req) {
		Modulo modulo = null;
		
		int codigo = Integer.parseInt(req.getParameter("codigo"));
		modulo.setCodigo(codigo);
		
		String nombre = req.getParameter("nombre-modulo");
		modulo.setNombre(nombre);
		
		String uFormativa = req.getParameter("uFormativa-modulo");
		modulo.setuFormativa(uFormativa);
		
		int duracion = Integer.parseInt(req.getParameter("duracion-modulo"));
		modulo.setDuracion(duracion);
		
		return modulo;
	}

	public ModelAndView create(HttpServletRequest req, HttpServletResponse res){
		return mav;
	}
}
