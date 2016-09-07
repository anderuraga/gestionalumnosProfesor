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

@Controller
@RequestMapping(value="/alumnos")
public class AlumnosController extends MultiActionController {
	@Autowired
	private AlumnoServiceImp as = null;
	private ModelAndView mav = null;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll(){
		mav = new ModelAndView("/alumnos/listado");
		List<Alumno> alumnos = as.getAll();
		mav.addObject("listado-alumnos", alumnos);
		return mav;
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id") int id){
		mav = new ModelAndView("/alumnos/alumno");
		Alumno alumno = as.getById(id);
		mav.addObject("alumno", alumno);
		return mav;
	}
	
	@RequestMapping(value="/addAlumno", method=RequestMethod.GET)
	public String addAlumno(Model model){
		model.addAttribute("alumno", new Alumno());
		return "alumnos/alumno";
	}
	
	@RequestMapping(value="/{id}", method = {RequestMethod.POST, RequestMethod.DELETE})
	public ModelAndView delete(@PathVariable("id") int id){
		mav = new ModelAndView("/alumnos/listado");
		as.delete(id);
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest req, HttpServletResponse res){
		mav = new ModelAndView("/alumnos/listado");
		Alumno alumno = parseAlumno(req);
		return mav;
	}
	
	public ModelAndView create(HttpServletRequest req, HttpServletResponse res){
		
		return mav;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveAlumno(@ModelAttribute("alumno") Alumno alumno){
		if(alumno.getCodigo()>0){
			as.update(alumno);
		} else{
			as.create(alumno);
		}
		
		return ":redirect:/alumnos";
	}
	
	private Alumno parseAlumno(HttpServletRequest req){
		Alumno alumno = null;
		
		int codigo = Integer.parseInt(req.getParameter("codigo"));
		alumno.setCodigo(codigo);
		
		String nombre = req.getParameter("nombre-alumno");
		alumno.setNombre(nombre);
		
		String apellidos = req.getParameter("apellidos-alumno");
		alumno.setApellidos(apellidos);
		
		return alumno;
	}
}
