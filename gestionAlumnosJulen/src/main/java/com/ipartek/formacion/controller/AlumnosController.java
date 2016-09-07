package com.ipartek.formacion.controller;

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
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ipartek.formacion.dao.persistence.Alumno;
import com.ipartek.formacion.service.AlumnoServiceImp;
/**
 * 
 * @author Curso
 *
 */
@Controller
@RequestMapping(value="/alumnos")
public class AlumnosController extends MultiActionController {
	
	@Autowired
	private AlumnoServiceImp asi = null;
	private ModelAndView mav = null;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll(){
				
		mav = new ModelAndView("/alumnos/listado");
		List<Alumno> alumnos = asi.getAll();
		
		mav.addObject("listadoAlumnos", alumnos);
		
		return mav;
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id") int id){
		
		mav = new ModelAndView("/alumnos/alumnos");
		
		Alumno alumno = asi.getById(id);
		
		mav.addObject("alumno", alumno);
		
		return mav;
		
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.POST)
	public ModelAndView delete(@PathVariable("id") int id){
		
		mav = new ModelAndView("/alumnos/listado");
		
		asi.delete(id);
		
		return mav;
		
	}
	
	@RequestMapping("/save")
	public String saveAlumno(@ModelAttribute("alumno") Alumno alumno){
		
		if(alumno.getCodigo()>0)
		{
			asi.update(alumno);
		}
		else
		{
			asi.create(alumno);
		}
		
		return "redirect:/alumnos";
	}
	
	/*
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest req, HttpServletResponse res){
		
		mav = new ModelAndView("/alumnos/listado");

		Alumno alumno = parseAlumno(req);
		
		asi.update(alumno);
		
		return mav;
	}
	
	public ModelAndView create(HttpServletRequest req, HttpServletResponse res){
		
		
		return mav;
	}*/
	
	@RequestMapping("/addAlumno")
	public String addAlumno(Model model){
		model.addAttribute("alumno", new Alumno());
		return "alumnos/alumnos";
	}
	
	private Alumno parseAlumno(HttpServletRequest req){
		Alumno alumno = new Alumno();
		
		int codigo = Integer.parseInt(req.getParameter("codigo"));
		alumno.setCodigo(codigo);
		alumno.setNombre(req.getParameter("nombre"));
		alumno.setApellidos(req.getParameter("apellidos"));
		
		return alumno;
	}
	
}
