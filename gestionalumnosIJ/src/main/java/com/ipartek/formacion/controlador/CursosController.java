package com.ipartek.formacion.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ipartek.formacion.dao.persistence.Curso;
import com.ipartek.formacion.service.interfaces.CursosService;

@Controller
@RequestMapping(value = "/cursos")
public class CursosController extends MultiActionController {
  @Autowired
  private CursosService cService = null;
  private ModelAndView mav = null;

  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView getAll() {
    mav = new ModelAndView("/cursos/listado");
    List<Curso> cursos = cService.getAll();
    mav.addObject("listaCursos", cursos);
    return mav;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ModelAndView getById(@PathVariable("id") int id) {
    mav = new ModelAndView("/cursos/curso");
    mav.addObject("curso", cService.getById(id));
    return mav;
  }

  @RequestMapping(method = { RequestMethod.POST, RequestMethod.DELETE }, value = "/{id}")
  public ModelAndView delete(@PathVariable("id") int id) {
    mav = new ModelAndView("/cursos/listado");
    cService.delete(id);
    mav.addObject("listaCursos", cService.getAll());
    return mav;
  }
}
