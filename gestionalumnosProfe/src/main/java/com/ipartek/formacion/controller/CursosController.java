package com.ipartek.formacion.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ipartek.formacion.dao.persistence.Alumno;
import com.ipartek.formacion.dao.persistence.Curso;
import com.ipartek.formacion.service.interfaces.CursoService;

@Controller
@RequestMapping(value = "/cursos")
public class CursosController extends MultiActionController {

	// @Resource(name = "CursoServiceImp")
	@Autowired
	private CursoService as = null;
	private ModelAndView mav = null;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		mav = new ModelAndView("/cursos/listado");
		List<Curso> cursos = as.getAll();

		mav.addObject("listado_cursos", cursos);
		return mav;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id") int id) {
		mav = new ModelAndView("/cursos/curso");
		Curso curso = as.getById(id);
		mav.addObject("curso", curso);

		return mav;
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.POST,
			RequestMethod.DELETE })
	public ModelAndView delete(@PathVariable("id") int id) {
		mav = new ModelAndView("/cursos/listado");
		as.delete(id);
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest req, HttpServletResponse res) {
		mav = new ModelAndView("/cursos/listado");
		Curso Curso = parseCurso(req);
		as.update(Curso);

		return mav;
	}

	public ModelAndView create(HttpServletRequest req, HttpServletResponse res) {

		return mav;
	}
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String saveAlumno(@ModelAttribute("curso") Curso curso){
		if(curso.getCodigo()>0){
			as.update(curso);
		}
		else{
			
		}
		return "redirect:/cursos";
	}
	private Curso parseCurso(HttpServletRequest req) {
		Curso Curso = new Curso();
		int codigo = Integer.parseInt(req.getParameter("codigo"));
		String nombre = req.getParameter("nombre-Curso");
		String apellidos = req.getParameter("apellidos-Curso");
		Curso.setCodigo(codigo);
		Curso.setNombre(nombre);
		

		return Curso;
	}
}

