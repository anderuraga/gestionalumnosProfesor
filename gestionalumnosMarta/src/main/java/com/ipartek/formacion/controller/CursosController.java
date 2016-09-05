package com.ipartek.formacion.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.dao.persistencia.Alumno;
import com.ipartek.formacion.dao.persistencia.Curso;
import com.ipartek.formacion.service.interfaces.CursoService;

@Controller
@RequestMapping(value="/cursos") //indicamos que esta CLASE va a gestionar las peticiones que lleven cursos en la url
public class CursosController {

	@Autowired
	private CursoService as = null;
	private ModelAndView mav = null;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll(){
		mav = new ModelAndView("/cursos/listado"); //indicamos la vista
		List<Curso> cursos = as.getAll();
		
		mav.addObject("listado-cursos",cursos); //metemos el objeto en la respuesta
		
		return mav;
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView getById(@PathVariable("id") int id){ //indicamos el tipo de parametro que recibe
		mav = new ModelAndView("/cursos/curso"); //indicamos la vista
		Curso curso = as.getById(id);
		
		mav.addObject("curso",curso); //metemos el objeto en la respuesta
		
		return mav;
	}
	
	@RequestMapping(method = {RequestMethod.POST,RequestMethod.DELETE}, value= "/{id}")
	public ModelAndView delete(@PathVariable("id") int id){ //indicamos el tipo de parametro que recibe
		mav = new ModelAndView("/cursos/listado"); //indicamos la vista
		as.delete(id);
		
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest req,HttpServletResponse res){
		mav = new ModelAndView("/cursos/listado");
		Curso curso = parseCurso(req);
		as.update(curso);
		
		return mav;
	}
	
	public ModelAndView create(HttpServletRequest req,HttpServletResponse res){
		
		return mav;
	}
	
	


	private Curso parseCurso(HttpServletRequest req) {
		Curso curso = new Curso();
		
		curso.setCodigo(Integer.parseInt(req.getParameter("codigo")));
		curso.setNombre(req.getParameter("nombre-curso"));
		
		return curso;
	}
	
}
