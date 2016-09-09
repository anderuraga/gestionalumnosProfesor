package com.ipartek.formacion.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ipartek.formacion.dao.persistencia.Modulo;
import com.ipartek.formacion.service.interfaces.ModuloService;

@Controller
@RequestMapping(value = "/modulos")
public class ModuloController extends MultiActionController {
  @Autowired
  private ModuloService mService = null;
  private ModelAndView mav = null;

  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView getAll() {
    mav = new ModelAndView("/modulos/listado");
    List<Modulo> modulos = mService.getAll();
    mav.addObject("listaModulos", modulos);
    return mav;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ModelAndView getById(@PathVariable("id") int id) {
    mav = new ModelAndView("/modulos/modulo");
    mav.addObject("modulo", mService.getById(id));
    return mav;
  }

  @RequestMapping(method = { RequestMethod.POST, RequestMethod.DELETE }, value = "/{id}")
  public ModelAndView delete(@PathVariable("id") int id) {
    mav = new ModelAndView("/modulos/listado");
    mService.delete(id);
    mav.addObject("listaModulos", mService.getAll());
    return mav;
  }
}
