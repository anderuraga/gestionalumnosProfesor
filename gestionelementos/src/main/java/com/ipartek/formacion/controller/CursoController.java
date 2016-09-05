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
import com.ipartek.formacion.dao.persistence.Curso;
import com.ipartek.formacion.service.interfaces.CursoService;

@Controller
@RequestMapping(value = "/cursos")
public class CursoController extends MultiActionController {

	@Autowired
	private CursoService cs = null;
	private ModelAndView mav = null;

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView getAll() {
		mav = new ModelAndView("cursos/listado");
		List<Curso> cursos = cs.getAll();

		mav.addObject("listado-cursos", cursos);
		return mav;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id") int id) {
		mav = new ModelAndView("cursos/curso");
		Curso curso = cs.getById(id);
		mav.addObject("curso", curso);
		return mav;
	}
	@RequestMapping(value = "/{id}", method = { RequestMethod.POST, RequestMethod.DELETE })
	public ModelAndView Delete(@PathVariable("id") int id) {
		mav = new ModelAndView("cursos/listado");
		cs.delete(id);
		return mav;
	}
	//########
	private Curso parseCurso(HttpServletRequest req) {
		Curso curso = new Curso();

		int codigo = Integer.parseInt(req.getParameter("codCurso"));
		String nombre = req.getParameter("nombre-curso");

		curso.setCodigo(codigo);
		curso.setNombre(nombre);

		return curso;

	}
}
