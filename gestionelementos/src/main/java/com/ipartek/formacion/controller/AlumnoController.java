package com.ipartek.formacion.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public ModelAndView getById(@PathVariable("id") int id) {
		mav = new ModelAndView("alumnos/alumno");
		Alumno alumno = alse.getById(id);
		mav.addObject("alumno", alumno);
		return mav;
	}
	@RequestMapping(value = "/{id}", method = { RequestMethod.POST, RequestMethod.DELETE })
	public ModelAndView Delete(@PathVariable("id") int id) {
		mav = new ModelAndView("alumnos/listado");
		alse.delete(id);
		return mav;
	}
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView update(HttpServletRequest req,HttpServletResponse res){
        Alumno alumno=parseAlumno(req);
        alse.update(alumno);
        return mav;
        
    }

	@RequestMapping(value = "/newAlumno", method = RequestMethod.GET)
	public String addAlumno(Model model) {
		model.addAttribute("alumno", new Alumno());
		return "alumnos/alumno";
	}

	@RequestMapping(value = "/saveAlumno", method = RequestMethod.POST)
	public String saveAlumno(@ModelAttribute("alumno") Alumno alumno) {
		if (alumno.getCodigo() > 0) {
			alse.update(alumno);
		} else {
			alse.create(alumno);
		}
		return "redirect:/alumnos";

	}

	// ### Esto es java clasico ###
	private Alumno parseAlumno(HttpServletRequest req) {
		Alumno alumno = new Alumno();

		int codigo = Integer.parseInt(req.getParameter("codigo-alumno"));
		String nombre = req.getParameter("nombre-alumno");
		String apellidos = req.getParameter("apellidos-alumno");

		alumno.setCodigo(codigo);
		alumno.setNombre(nombre);
		alumno.setApellidos(apellidos);

		return alumno;

	}

}