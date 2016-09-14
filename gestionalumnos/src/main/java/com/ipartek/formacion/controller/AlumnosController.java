package com.ipartek.formacion.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ipartek.formacion.dao.persistencia.Alumno;
import com.ipartek.formacion.service.AlumnoServiceImp;

/**
 * 
 * @author Curso
 *
 */
/*
 * 
 */
@Controller
@RequestMapping(value = "/alumnos")
public class AlumnosController extends MultiActionController {

	private static final Logger logger = LoggerFactory.getLogger(AlumnosController.class);
	
  @Autowired
  private AlumnoServiceImp as = null;
  private ModelAndView mav = null;


  @Autowired
  @Qualifier("alumnoValidator")
  private Validator validator;
  
  @InitBinder
  private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);		
  }

  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView getAll() {

    mav = new ModelAndView("alumnos/listado");
    List<Alumno> alumnos = as.getAll();
    mav.addObject("listado-alumnos", alumnos);
    return mav;

  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ModelAndView getById(@PathVariable("id") int id) {

    mav = new ModelAndView("alumnos/alumno");
    Alumno alumno = as.getById(id);
    mav.addObject("alumno", alumno);
    return mav;

  }

  @RequestMapping(value = "delete/{id}", method = { RequestMethod.GET, RequestMethod.DELETE })
  public ModelAndView delete(@PathVariable("id") int id) {

    this.mav = new ModelAndView("alumnos/listado");
    as.delete(id);
    return this.mav;

  }

 
  @RequestMapping(value ="/addAlumno", method = RequestMethod.GET)
  public String addAlumno(Model model){
	  model.addAttribute("alumno", new Alumno());
	  return "alumnos/alumno"; 
  }
  
  @RequestMapping(value = "/saveAlumno", method = RequestMethod.POST)
  public String saveAlumno(@ModelAttribute("alumno") @Validated(Alumno.class) Alumno alumno,BindingResult bindingResult){
	  
	  String destino ="";
		
		if(bindingResult.hasErrors()){
			logger.info("El alumno tiene errores");
			destino = "alumnos/alumno"; 
			//como tiene errores, lo manda otra vez a la pagina de alumno nuevo.
		}else{
			logger.info("alumno correcto");
			destino = "redirect:alumnos";
			if(alumno.getCodigo()>0){
				as.update(alumno);
			}else{
				as.create(alumno);
			}
		}
		
		return destino; // ofuscacion de URL
  }

  private Alumno parseAlumno(HttpServletRequest req) {

    Alumno alumno = new Alumno();
    alumno.setCodigo(Integer.parseInt(req.getParameter("codigo")));
    alumno.setApellidos(req.getParameter("nombre"));
    alumno.setNombre(req.getParameter("apellidos"));
    alumno.setDni(req.getParameter("dni"));
    return alumno;

  }
  
  @RequestMapping(value = "/restclients",  method = RequestMethod.GET)
  public String sendToRestGetAll(){
	  return "alumnos/listadoRest";
  }
}
