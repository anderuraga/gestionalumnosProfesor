package com.ipartek.formacion.controlador;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
//@EnableAspectJAutoProxy(proxyTargetClass = true) 
@Controller
@RequestMapping(value = "/alumnos")
public class AlumnosController extends MultiActionController {
	private static final Logger logger = LoggerFactory
			.getLogger(AlumnosController.class);
	@Autowired	
	private AlumnoService aService = null;
	private ModelAndView mav = null;
	@Autowired
	@Qualifier("alumnoValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("dd/MM/yyyy"), false, 10));
	}

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
	public String saveAlumno(
			@ModelAttribute("alumno") @Validated Alumno alumno,
			BindingResult bindingResult, Model model) {
		String destino = "";

		if (bindingResult.hasErrors()) {
			logger.info("El alumno tiene errores");
			destino = "/alumnos/alumno";
		} else {
			logger.info("alumno correcto");
			destino = "redirect:/alumnos";
			if (alumno.getCodigo() > 0) {
				aService.update(alumno);
			} else {
				aService.create(alumno);
			}
		}
		return destino;
	}
	
	@RequestMapping(value = "/restclients", method = RequestMethod.GET)
	public String restRedirect(Model model) {
		return "/alumnos/listado_rest";
	}

}
