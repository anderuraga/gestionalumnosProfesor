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
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id") int id){
		
		mav = new ModelAndView("/cursos/cursos");
		
		Curso curso = csi.getById(id);
		
		mav.addObject("curso", curso);
		
		return mav;
		
	}
	
	private Curso parseCurso(HttpServletRequest req){
		Curso curso = new Curso();
		
		int codigo = Integer.parseInt(req.getParameter("codigo"));
		curso.setCodigo(codigo);
		curso.setNombre(req.getParameter("nombre"));
	
		
		
		return curso;
	}
}
