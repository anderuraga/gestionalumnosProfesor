package com.ipartek.formacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
 * En las operaciones de CRUD Create- POST Read - GET Update - POST Delete - POST
 */
@Controller
// mapeamos, cada vez que en nuestra url tengamos /alumnos entra en esta clase.
@RequestMapping(value = "/alumnos")
public class AlumnosController extends MultiActionController {

  // Al poner autowired, sabes que necesita inyectar un objeto.
  @Autowired
  private AlumnoServiceImp as = null;
  private ModelAndView mav = null;

  // mapeamos, cada vez dentro de alumnos nuestra peticion sea por get nos mostrara todos los
  // alumnos.
  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView getAll() {

    this.mav = new ModelAndView("alumnos/listado");
    List<Alumno> alumnos = as.getAll();
    this.mav.addObject("listado-alumnos", alumnos);
    return this.mav;

  }

  /*
   * Para decirle a un metodo, que va a recibir un parametro, hay que ponerlo entre llaves en el
   * value del RequestMapping y para indicar que este parametro en concreto es el que recibe el
   * metodo hay que poner la anotacion PathVariable
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ModelAndView getById(@PathVariable("id") int id) {

    this.mav = new ModelAndView("alumnos/alumno");
    Alumno alumno = as.getById(id);
    this.mav.addObject("alumno", alumno);
    return this.mav;

  }

}
