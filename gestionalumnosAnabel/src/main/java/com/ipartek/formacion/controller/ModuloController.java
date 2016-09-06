package com.ipartek.formacion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ipartek.formacion.service.ModuloServiceImp;

@Controller
@RequestMapping(value = "/modulos")
public class ModuloController extends MultiActionController {

  private ModelAndView mav;
  private ModuloServiceImp moduloServiceImp;

  @RequestMapping(value = "/{id}", method = RequestMethod.POST)
  public ModelAndView delete(@PathVariable("id") int id) {

    this.mav = new ModelAndView("/cursos/listado");
    this.moduloServiceImp.delete(id);
    return this.mav;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ModelAndView getById(@PathVariable("id") int id) {

    return this.mav;
  }
}
