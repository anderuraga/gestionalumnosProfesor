package com.ipartek.formacion.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
@RequestMapping(value = "/alumnos")
public class AlumnoController {

	private static final Logger logger = LoggerFactory.getLogger(AlumnoController.class);
	@Autowired
	private AlumnoServiceImp asImp = null;
	private ModelAndView mav = null;
	
	@Autowired
	@Qualifier("alumnoValidator")
	private Validator validator;
	
	@InitBinder
	private void InitBinder(WebDataBinder binder){
		binder.setValidator(validator);
	}

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
	@RequestMapping(value = "deleteAlumno/{id}")
	public String delete(@PathVariable("id") int id) {	
		asImp.delete(id);	
		return "redirect:/alumnos";
	}

	@RequestMapping(value="/save")
	public String saveAlumno(@ModelAttribute("alumno") @Validated(Alumno.class) Alumno alumno, BindingResult bindingResult){
		//el objeto del model attribute se llama igual que el commandName del formulario, será lo que recibirá encapsulado
		//@Validated se usa para obligar a validar los datos a guardar
		String destino ="";
		
		if(bindingResult.hasErrors()){
			logger.info("El alumno tiene errores");
			destino = "alumnos/alumno"; 
			//como tiene errores, lo manda otra vez a la pagina de alumno nuevo.
		}else{
			destino = "redirect:/alumnos";
			if(alumno.getCodigo()>0){
				asImp.update(alumno);
			}else{
				asImp.create(alumno);
			}
		}
		
		return destino; // ofuscacion de URL
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
	
	@RequestMapping(value="/restclients", method=RequestMethod.GET)
	public String sendToRestGetAll(){
		return "/alumnos/listado_rest";
	}

}
