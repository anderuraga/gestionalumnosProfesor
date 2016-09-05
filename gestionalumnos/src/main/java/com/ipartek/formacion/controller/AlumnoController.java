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
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ipartek.formacion.dao.persistencia.Alumno;
import com.ipartek.formacion.service.AlumnoServiceImp;

@Controller
@RequestMapping(value="/alumnos")
public class AlumnoController extends MultiActionController{
	
	@Autowired
	private AlumnoServiceImp as = null;
	private ModelAndView mav = null;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll(){
		ModelAndView mav = new ModelAndView("/alumnos/listadoAlumnos");
		List<Alumno> alumnos = as.getAll();
		
		mav.addObject("listado-alumnos", alumnos);
		
		return mav;
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id") int id){
		mav = new ModelAndView("/alumnos/alumno");
		
		Alumno alumno = as.getById(id);
		mav.addObject("alumno",alumno);
		return mav;
	}
	
	@RequestMapping(value="/{id}",method = {RequestMethod.POST,RequestMethod.DELETE})
	public ModelAndView delete(@PathVariable("id") int id){
		ModelAndView mav = new ModelAndView("/alumnos/listadoAlumnos");
		
		as.delete(id);
		return mav;
	}
	
	
	public ModelAndView create(HttpServletRequest req, HttpServletResponse res){
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest req, HttpServletResponse res){
		ModelAndView mav = new ModelAndView("/alumnos/listadoAlumnos");
		Alumno alumno = parseAlumno(req);
		as.update(alumno);		
		
		return mav;
	}
	
	private Alumno parseAlumno(HttpServletRequest req){
		Alumno alumno= new Alumno();
		int codigo = Integer.parseInt(req.getParameter("codigo"));
		alumno.setCodigo(codigo);
		alumno.setNombre(req.getParameter("nombre"));
		alumno.setApellidos(req.getParameter("apellidos"));
		return alumno;
		
	}
}
