package com.ipartek.formacion.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.dao.persistencia.Curso;
import com.ipartek.formacion.service.CursoServiceImp;

@Controller
@RequestMapping(value = "/cursos")
public class CursoController {

  private ModelAndView mav;
  private CursoServiceImp cursoService;

  @RequestMapping(value = "/{id}", method = { RequestMethod.POST, RequestMethod.DELETE })
  public ModelAndView delete(@PathVariable("id") int id) {

    this.mav = new ModelAndView("/cursos/listado");
    this.cursoService.delete(id);
    return this.mav;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ModelAndView getById(@PathVariable("id") int id) {

    this.mav = new ModelAndView("/cursos/curso");
    Curso curso = this.cursoService.getById(id);
    this.mav.addObject("curso", curso);
    return this.mav;
  }

  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView getAll() {

    this.mav = new ModelAndView("cursos/listado");
    List<Curso> cursos = this.cursoService.getAll();
    this.mav.addObject("listado-cursos", cursos);
    return this.mav;
  }

  @RequestMapping(method = RequestMethod.POST)
  public ModelAndView update(HttpServletRequest req, HttpServletResponse res) {

    this.mav = new ModelAndView("/cursos/listado");
    Curso curso = parseCurso(req);
    this.cursoService.update(curso);
    this.mav.addObject("curso", curso);
    return this.mav;

  }

  private Curso parseCurso(HttpServletRequest req) {

    Curso curso = null;
    curso.setCodigo(Integer.parseInt(req.getParameter("codCurso")));
    curso.setNombre(req.getParameter("nombre"));
    return curso;

  }
}
