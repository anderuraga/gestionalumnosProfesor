package com.ipartek.formacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.service.AlumnosServiceImp;

@Controller
@RequestMapping(value = "/alumnos")
public class AlumnosController {

  @Autowired
  // al poner autowired, sabes que necesita inyectar un objeto.
  AlumnosServiceImp as = null;

}
