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
@RequestMapping(value = "/alumnos")
public class AlumnoController extends MultiActionController {

	@Autowired
	private AlumnoServiceImp asImp = null;
	private ModelAndView mav = null;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {

		mav = new ModelAndView("alumnos/listado");
		List<Alumno> alumnos = asImp.getAll();
		mav.addObject("listado-alumnos", alumnos);
		return mav;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getByID(@PathVariable("id") int id) {
		mav = new ModelAndView("alumnos/alumno");
		Alumno alumno = asImp.getByID(id);
		mav.addObject("alumno", alumno);
		return mav;
	}

	@RequestMapping(value="/addAlumno", method=RequestMethod.GET)
	public String addAlumno(Model model){
		model.addAttribute("alumno", new Alumno());
		return "alumnos/alumno";
	}
	@RequestMapping(value = "/{id}", method = { RequestMethod.POST, RequestMethod.DELETE })
	public ModelAndView delete(@PathVariable("id") int id) {
		mav = new ModelAndView("alumnos/listado");
		asImp.delete(id);
		mav.addObject("listado-alumnos");
		return mav;
	}

	@RequestMapping(value="/save")
	public String saveAlumno(@ModelAttribute("alumno") Alumno alumno){//el objeto del model attribute se llama igual que el commandName del formulario, ser� lo que recibir� encapsulado
		if(alumno.getCodigo()>0){
			asImp.update(alumno);
		}else{
			asImp.create(alumno);
		}
		return "redirect:/alumnos"; // ofuscacion de URL
	}

	private Alumno parseAlumno(HttpServletRequest req) {
		Alumno alumno = null;
		int codigo = Integer.parseInt(req.getParameter("codigo"));
		alumno.setCodigo(codigo);
		String nombre = req.getParameter("nombre");
		alumno.setNombre(nombre);
		String apellidos = req.getParameter("apellidos");
		alumno.setApellidos(apellidos);

		return alumno;
	}

}
