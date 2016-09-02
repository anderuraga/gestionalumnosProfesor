package com.ipartek.formacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ipartek.formacion.dao.persistencia.Alumno;
import com.ipartek.formacion.service.AlumnosServiceImp;

@Controller
// mapeamos, cada vez que en nuestra url tengamos /alumnos entra en esta clase.
@RequestMapping(value = "/alumnos")
public class AlumnosController extends MultiActionController {

  // al poner autowired, sabes que necesita inyectar un objeto.
  @Autowired
  private AlumnosServiceImp as = null;

  // mapeamos, cada vez dentro de alumnos nuestra peticion sea por get nos mostrara todos los
  // alumnos.
  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView getAll() {

    ModelAndView mav = null;
    mav = new ModelAndView("alumnos/listado");
    List<Alumno> alumnos = as.getAll();
    mav.addObject("listado-alumnos", alumnos);
    return mav;

  }

}
