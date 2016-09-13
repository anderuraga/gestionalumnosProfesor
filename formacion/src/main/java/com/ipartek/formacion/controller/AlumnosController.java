package com.ipartek.formacion.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.dao.persistence.Alumno;
import com.ipartek.formacion.service.AlumnoServiceImp;

@Controller
@RequestMapping(value="/alumnos")
public class AlumnosController {
	
	private static final Logger logger = LoggerFactory.getLogger(AlumnosController.class);
	
	@Autowired
	private AlumnoServiceImp as = null;
	private ModelAndView mav = null;
	
	@Autowired
	@Qualifier("alumnoValidator")
	private Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder){
		binder.setValidator(validator);
	}
	
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
	
	@RequestMapping(value="/delete/{id}", method = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.GET})
	public ModelAndView delete(@PathVariable("id") int id){
		mav = new ModelAndView("/alumnos/listado");
		as.delete(id);
		return mav;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveAlumno(@ModelAttribute("alumno") @Validated Alumno alumno, BindingResult bindingResult, Model model){
		
		String destino = "";
		logger.trace(alumno.getApellidos());
		if(bindingResult.hasErrors()){
			logger.info("El alumno tiene errores.");
			logger.info(bindingResult.toString());
			destino = "alumnos/alumno";
		} else{
			destino = "redirect:/alumnos";
			
			if(alumno.getCodigo()>0){
				as.update(alumno);
			} else{
				as.create(alumno);
			}
		}
		
		return destino;
	}
}
