package com.ipartek.formacion.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.dao.persistencia.Modulo;
import com.ipartek.formacion.service.ModuloServiceImp;

@Controller
@RequestMapping(value="cursos")
public class ModulosController {
	@Autowired
	private ModuloServiceImp ms;
	private ModelAndView mav=null;
	
	@RequestMapping("/")
	public ModelAndView getAll(){
		mav=new ModelAndView("/modulos/listado");
		List<Modulo>modulos=ms.getAll();
		mav.addObject("listado-modulos",modulos);
		return mav;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id") int id){
		mav=new ModelAndView("/modulos/listado");
		Modulo modulo=ms.getById(id);
		
		return mav;
	}
}
