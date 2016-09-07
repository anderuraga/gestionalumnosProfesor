package com.ipartek.formacion.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class AlumnosController extends MultiActionController {

	@Autowired
	private AlumnoService aService = null;
	private ModelAndView mav = null;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		mav = new ModelAndView("/alumnos/listado");
		mav.addObject("listaAlumnos", aService.getAll());
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView getById(@PathVariable("id") int id) {
		mav = new ModelAndView("/alumnos/alumno");
		mav.addObject("alumno", aService.getById(id));
		return mav;
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.DELETE }, value = "/{id}")
	public String delete(@PathVariable("id") int id) {
		aService.delete(id);
		return "redirect:/alumnos";
	}

	@RequestMapping(value = "/addAlumno", method = RequestMethod.GET)
	public String addAlumno(Model model) {
		model.addAttribute("alumno", new Alumno());
		return "/alumnos/alumno";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveAlumno(@ModelAttribute("alumno") Alumno alumno) {
		if (alumno.getCodigo() > 0) {
			aService.update(alumno);
		} else {
			aService.create(alumno);
		}
		return "redirect:/alumnos";
	}

}
