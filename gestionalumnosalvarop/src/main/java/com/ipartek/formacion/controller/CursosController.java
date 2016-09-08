package com.ipartek.formacion.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ipartek.formacion.dao.persistencia.Curso;
import com.ipartek.formacion.service.CursoServiceImp;
@Controller
@RequestMapping(value="/cursos")
public class CursosController extends MultiActionController {
	private static final Logger logger = LoggerFactory.getLogger(CursosController.class);
@Autowired
private CursoServiceImp cs;

private ModelAndView mav;

@RequestMapping(method=RequestMethod.GET)
public ModelAndView getAll(){

	mav=new ModelAndView("/cursos/listado");
	List<Curso>cursos=cs.getAll();
	mav.addObject("cursos",cursos);
	return mav;
}

@RequestMapping(value="/{id}",method=RequestMethod.GET)
public ModelAndView getById(@PathVariable("id")int id){
	mav= new ModelAndView("/cursos/curso");
	Curso curso=cs.getById(id);
	mav.addObject("curso",curso);
	return mav;
}

@RequestMapping(value="/{id}",method={RequestMethod.POST,RequestMethod.DELETE})
public ModelAndView delete(@PathVariable("id")int id){
	mav= new ModelAndView("/cursos/listado");
	cs.delete(id);
	return mav;
}

@RequestMapping(method=RequestMethod.POST)
public ModelAndView update(HttpServletRequest req,HttpServletResponse res){
	mav=new ModelAndView("/cursos/listado");
	Curso curso=parseCurso(req);
	return mav;
	
}

private Curso parseCurso(HttpServletRequest req) {
	Curso curso=new Curso();
	int codigo=Integer.parseInt(req.getParameter("codigo"));
	String nombre=req.getParameter("nombre-curso");
	curso.setCodigo(codigo);
	curso.setNombre(nombre);
	
	return curso;
}










}
