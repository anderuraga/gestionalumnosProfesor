package com.ipartek.formacion.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ipartek.formacion.dao.persistence.Alumno;
import com.ipartek.formacion.dao.persistence.Curso;
import com.ipartek.formacion.dao.persistence.Modulo;
import com.ipartek.formacion.service.interfaces.CursoService;
import com.ipartek.formacion.service.interfaces.ModuloService;

@Controller
@RequestMapping(value = "/modulos")
public class ModuloController extends MultiActionController {

	@Autowired
	private ModuloService mose = null;
	private ModelAndView mav = null;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		mav = new ModelAndView("modulos/listadoModulos");
		List<Modulo> modulos = mose.getAll();

		mav.addObject("listado-modulos", modulos);
		return mav;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id") int id) {
		mav = new ModelAndView("modulos/modulo");
		Modulo modulo = mose.getById(id);
		mav.addObject("modulo", modulo);
		return mav;
	}
	@RequestMapping(value = "/{id}", method = { RequestMethod.POST, RequestMethod.DELETE })
	public ModelAndView Delete(@PathVariable("id") int id) {
		mav = new ModelAndView("modulos/listado");
		mose.delete(id);
		return mav;
	}
}
