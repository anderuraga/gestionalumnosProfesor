package com.ipartek.formacion.controlador;

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

import com.ipartek.formacion.dao.persistencia.Modulo;
import com.ipartek.formacion.service.ModuloServiceImp;

@Controller
@RequestMapping(value="/modulos")
public class ModulosController {
	@Autowired
	private ModuloServiceImp ms;
	private ModelAndView mav=null;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getAll(){
		mav=new ModelAndView("/modulos/listado");
		List<Modulo>modulos=ms.getAll();
		mav.addObject("listado_modulos",modulos);
		return mav;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id") int id){
		mav=new ModelAndView("/modulos/modulo");
		Modulo modulo=ms.getById(id);
		mav.addObject("modulo",modulo);
		return mav;
	}
	
	@RequestMapping(value="/addModulo", method=RequestMethod.GET)
	public String addModulo(Model model){
		model.addAttribute("modulo", new Modulo());
		return "modulos/modulo";
	}
	
	@RequestMapping(value="/{id}", method={RequestMethod.POST, RequestMethod.DELETE})
	public ModelAndView delete(@PathVariable("id")int id){
		mav=new ModelAndView("/modulos/listado");
		ms.delete(id);
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String saveModulo(@ModelAttribute("modulo") Modulo modulo){
		if(modulo.getCodigo()>0){
			ms.update(modulo);
		}else{
			ms.create(modulo);
		}
		
		return "redirect:/modulos";
	}

	private Modulo parseModulo(HttpServletRequest req) {
		Modulo modulo=new Modulo();
		int codigo=Integer.parseInt(req.getParameter("codigo"));
		String nombre=req.getParameter("nombre_modulo");
		modulo.setCodigo(codigo);
		modulo.setNombre(nombre);
		return modulo;
	}
}
