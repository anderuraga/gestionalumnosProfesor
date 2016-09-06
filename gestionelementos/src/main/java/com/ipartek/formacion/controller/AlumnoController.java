package com.ipartek.formacion.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
public class AlumnoController extends MultiActionController {

	@Autowired
	private AlumnoService alse = null;
	private ModelAndView mav = null;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		mav = new ModelAndView("alumnos/listadoAlumnos");
		List<Alumno> alumnos = alse.getAll();

		mav.addObject("listado-alumnos", alumnos);
		return mav;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	// ### @PathVariable("id") int id ### Esto es directamente el parseo
	public ModelAndView getById(@PathVariable("id") int id) {
		mav = new ModelAndView("alumnos/alumno");
		Alumno alumno = alse.getById(id);
		mav.addObject("alumno", alumno);
		return mav;
	}

	// ### RequestMethod.DELETE ### esta para cuando en un futuro se implemente
	// el metodo DELETE directamente y no haga falta usar un POST para borrar.
	@RequestMapping(value = "/{id}", method = { RequestMethod.POST, RequestMethod.DELETE })
	public ModelAndView Delete(@PathVariable("id") int id) {
		mav = new ModelAndView("alumnos/listado");
		alse.delete(id);
		return mav;
	}

	// @RequestMapping(method = RequestMethod.POST)
	// public ModelAndView Update(HttpServletRequest req, HttpServletResponse
	// res) {
	// Alumno alumno = parseAlumno(req);
	// as.update(alumno);
	// return mav;
	// }
	//
	// @RequestMapping(method = RequestMethod.POST)
	// public ModelAndView Create(HttpServletRequest req, HttpServletResponse
	// res) {
	// Alumno alumno = parseAlumno(req);
	// as.create(alumno);
	// return mav;
	// }

	// ### Esto es java clasico ###
	private Alumno parseAlumno(HttpServletRequest req) {
		Alumno alumno = new Alumno();

		int codigo = Integer.parseInt(req.getParameter("codAlumno"));
		String nombre = req.getParameter("nombre-alumno");
		String apellidos = req.getParameter("apellidos-alumno");

		alumno.setCodigo(codigo);
		alumno.setNombre(nombre);
		alumno.setApellidos(apellidos);

		return alumno;

	}

}