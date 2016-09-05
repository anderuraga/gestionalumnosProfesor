package com.ipartek.formacion.controlador;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ipartek.formacion.dao.persistence.Alumno;
import com.ipartek.formacion.service.interfaces.AlumnoService;

@Controller
@RequestMapping(value = "/alumnos")
public class AlumnosController extends MultiActionController {

  @Autowired
  private AlumnoService aService = null;
  private ModelAndView mav = null;

  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView getAll() {
    mav = new ModelAndView("/alumnos/listado");
    List<Alumno> alumnos = aService.getAll();
    mav.addObject("listaAlumnos", alumnos);
    return mav;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ModelAndView getById(@PathVariable("id") int id) {
    mav = new ModelAndView("/alumnos/alumno");
    mav.addObject("alumno", aService.getById(id));
    return mav;
  }

  @RequestMapping(method = { RequestMethod.POST, RequestMethod.DELETE }, value = "/{id}")
  public ModelAndView delete(@PathVariable("id") int id) {
    mav = new ModelAndView("/alumnos/listado");
    aService.delete(id);
    mav.addObject("listaAlumnos", aService.getAll());
    return mav;
  }

  // @RequestMapping(method = RequestMethod.POST)
  public ModelAndView create(HttpServletRequest req, HttpServletResponse res) {
    mav = new ModelAndView("/alumnos/listado");
    return mav;
  }

  @RequestMapping(method = RequestMethod.POST)
  public ModelAndView update(HttpServletRequest req, HttpServletResponse res) {
    mav = new ModelAndView("/alumnos/listado");
    aService.update(parseAlumno(req));
    mav.addObject("listaAlumnos", aService.getAll());
    return mav;
  }

  private Alumno parseAlumno(HttpServletRequest req) {
    Alumno alumno = new Alumno();
    logger.info(req.getParameter("codigo"));
    alumno.setCodigo(Integer.parseInt(req.getParameter("codigo")));
    alumno.setNombre(req.getParameter("nombre"));
    alumno.setApellido(req.getParameter("apellidos"));
    return alumno;
  }
}
