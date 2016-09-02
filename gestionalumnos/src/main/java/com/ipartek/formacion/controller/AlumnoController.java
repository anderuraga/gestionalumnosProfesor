package com.ipartek.formacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ipartek.formacion.dao.persistence.Alumno;
import com.ipartek.formacion.service.AlumnoServiceImp;

@Controller
@RequestMapping(value = "/alumnos")
public class AlumnoController extends MultiActionController {

	@Autowired
	private AlumnoServiceImp asImp = null;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		ModelAndView mav = null;
		mav = new ModelAndView("alumnos/listado");
		List<Alumno> alumnos = asImp.getAll();
		if (alumnos == null) {
			System.out.println("Alumno en controller nulo");
		}
		mav.addObject("listado-alumnos", alumnos);
		return mav;
	}

}