package com.ipartek.formacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ipartek.formacion.dao.persistence.Curso;
import com.ipartek.formacion.service.CursoServiceImp;

@Controller
@RequestMapping(value="/cursos")
public class CursosController extends MultiActionController{
	
	@Autowired
	private CursoServiceImp csi = null;
	
	private ModelAndView mav = null;
	
	@RequestMapping(method = RequestMethod.GET)
	private ModelAndView getAll(){
		
		mav = new ModelAndView("/cursos/listado");
		List<Curso> cursos = csi.getAll();
		
		mav.addObject("listaCursos", cursos);
		
		return mav;
		
	}
}
