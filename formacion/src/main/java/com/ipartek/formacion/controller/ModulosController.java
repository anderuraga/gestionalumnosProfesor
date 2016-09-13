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

import com.ipartek.formacion.dao.persistence.Modulo;
import com.ipartek.formacion.service.ModulosServiceImp;

@Controller
@RequestMapping(value="/modulos")

public class ModulosController extends MultiActionController{

	@Autowired
	private ModulosServiceImp ms=null;
	private ModelAndView mav=null;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getAll(){
		mav=new ModelAndView("modulos/listado");
		List<Modulo>modulos=ms.getAll();
		mav.addObject("listado-modulos",modulos);
		return mav;
		
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id")int id){
		mav=new ModelAndView("/modulos/modulo");
		Modulo m=ms.getById(id);
		mav.addObject("modulo",m);
		return mav;
		
	}
	
//	@RequestMapping(method=RequestMethod.POST)
//	public ModelAndView update(HttpServletRequest req, HttpServletResponse res){
//		Modulo m=parseModulo(req);
//		ms.update(m);
//		return mav;
//	}
	
//	@RequestMapping(method=RequestMethod.POST)
//	public ModelAndView create(HttpServletRequest req, HttpServletResponse res){
//		Modulo m=parseModulo(req);
//		ms.create(m);
//		return mav;
//	}
	
	
	@RequestMapping(value="/{id}", method={RequestMethod.POST,RequestMethod.DELETE})
	public ModelAndView delete(@PathVariable("id")int id){
		
		mav=new ModelAndView("/modulos/listado");
		ms.delete(id);
		return mav;
	}
	
	@RequestMapping("/addModulo")
	public String addModulo(Model model){
		model.addAttribute("modulo",new Modulo());
		return "modulos/modulo";
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveModulo(@ModelAttribute ("modulo") Modulo modulo){
		if (modulo.getCodModulo()>0) {
			ms.update(modulo);
		}else {
			ms.create(modulo);
		}
		return "redirect:/modulos";
	}
	

	private Modulo parseModulo(HttpServletRequest req) {
		Modulo m=new Modulo();
		m.setCodModulo(Integer.parseInt(req.getParameter("codModulo")));
		m.setNombreModulo(req.getParameter("nombreModulo"));
		m.setuFormativa(req.getParameter("uFormativa"));
		m.setDuracion(Integer.parseInt(req.getParameter("durModulo")));
		return m;
	}
	
	
}
