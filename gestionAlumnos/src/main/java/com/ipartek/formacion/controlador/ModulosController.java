package com.ipartek.formacion.controlador;

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
		mav=new ModelAndView("/modulos/modulo");
		Modulo modulo=ms.getById(id);
		mav.addObject("modulo",modulo);
		return mav;
	}
	
	@RequestMapping(value="/{id}", method={RequestMethod.POST, RequestMethod.DELETE})
	public ModelAndView delete(@PathVariable("id")int id){
		mav=new ModelAndView("/modulos/listado");
		ms.delete(id);
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView update(HttpServletRequest req, HttpServletResponse res){
		mav=new ModelAndView("/modulos/listado"); 
		Modulo modulo=parseModulo(req);
		ms.update(modulo);
		return mav;
	}

	private Modulo parseModulo(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}
}
