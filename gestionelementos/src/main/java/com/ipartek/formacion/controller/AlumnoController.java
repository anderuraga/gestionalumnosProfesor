package com.ipartek.formacion.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ipartek.formacion.dao.persistence.Alumno;
import com.ipartek.formacion.service.interfaces.AlumnoService;

@Controller
@RequestMapping(value = "/alumnos")
public class AlumnoController{
	private static final Logger logger = LoggerFactory
			.getLogger(AlumnoController.class);
	@Autowired
	private AlumnoService alse = null;
	private ModelAndView mav = null;
	@Autowired
	@Qualifier("alumnoValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		mav = new ModelAndView("alumnos/listadoAlumnos");
		List<Alumno> alumnos = alse.getAll();
		logger.info("numero de alumnos " + alumnos.size());
		mav.addObject("listado-alumnos", alumnos);
		return mav;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id") int id) {
		mav = new ModelAndView("alumnos/alumno");
		Alumno alumno = alse.getById(id);
		mav.addObject("alumno", alumno);

		return mav;
	}

	@RequestMapping(value = "/addAlumno", method = RequestMethod.GET)
	public String addAlumno(Model model) {
		model.addAttribute("alumno", new Alumno());
		return "alumnos/alumno";

	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.POST,
			RequestMethod.DELETE })
	public ModelAndView delete(@PathVariable("id") int id) {
		mav = new ModelAndView("alumnos/listado");
		alse.delete(id);
		return mav;
	}

	@RequestMapping(value = "/saveAlumno", method = RequestMethod.POST)
	public String saveAlumno(
			@ModelAttribute("alumno") @Validated(Alumno.class) Alumno alumno,
			BindingResult bindingResult) {
		String destino = "";
		if (bindingResult.hasErrors()) {
			logger.info("El alumno tiene errores");
			destino = "alumnos/alumno";
		} else {
			destino = "redirect:/alumnos";
			if (alumno.getCodigo() > 0) {
				alse.update(alumno);
			} else {
				alse.create(alumno);
			}
		}
		return destino;
	}

	private Alumno parseAlumno(HttpServletRequest req) {
		Alumno alumno = new Alumno();
		int codigo = Integer.parseInt(req.getParameter("codigo"));
		String nombre = req.getParameter("nombre-alumno");
		String apellidos = req.getParameter("apellidos-alumno");
		alumno.setCodigo(codigo);
		alumno.setNombre(nombre);
		alumno.setApellidos(apellidos);

		return alumno;
	}

}