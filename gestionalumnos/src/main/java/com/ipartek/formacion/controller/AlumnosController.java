package com.ipartek.formacion.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Validator;
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

  @Autowired
  private AlumnoServiceImp as = null;
  private ModelAndView mav = null;
  private Logger logger;

  @Autowired
  @Qualifier("alumnoValidator")
  private Validator validator;
  
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

  @RequestMapping(value = "/{id}", method = { RequestMethod.POST, RequestMethod.DELETE })
  public ModelAndView delete(@PathVariable("id") int id) {

    this.mav = new ModelAndView("alumnos/listado");
    as.delete(id);
    return this.mav;

  }

 
  @RequestMapping(value ="/addAlumnos", method = RequestMethod.GET)
  public String addAlumno(Model model){
	  model.addAttribute("alumno", new Alumno());
	  return "alumnos/alumno"; 
  }
  
  @RequestMapping(value = "/saveAlumno", method = RequestMethod.POST)
  public String saveAlumno(@ModelAttribute("alumno") Alumno alumno){
	  
	  if(alumno.getCodigo() > 0){
		  as.update(alumno);
	  }else{
		  as.create(alumno);
	  }
	  return "redirect:/alumnos";
  }

  private Alumno parseAlumno(HttpServletRequest req) {

    Alumno alumno = new Alumno();
    alumno.setCodigo(Integer.parseInt(req.getParameter("codigo")));
    alumno.setApellidos(req.getParameter("nombre"));
    alumno.setNombre(req.getParameter("apellidos"));
    return alumno;

  }
}
