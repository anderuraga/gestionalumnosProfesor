package com.ipartek.formacion.controller;

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

import com.ipartek.formacion.dao.persistence.Curso;
import com.ipartek.formacion.service.CursoServiceImp;

@Controller
@RequestMapping(value = "/cursos")
public class CursoController extends MultiActionController {

	@Autowired
	private CursoServiceImp cur = null;
	private ModelAndView mav = null;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {

		mav = new ModelAndView("/cursos/listado");
		List<Curso> cursos = cur.getAll();
		mav.addObject("listado-cursos", cursos);
		return mav;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getByID(@PathVariable("id") int id) {
		mav = new ModelAndView("/cursos/curso");
		Curso curso = cur.getByID(id);
		mav.addObject("cursos", curso);
		return mav;
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.POST, RequestMethod.DELETE })
	public ModelAndView delete(@PathVariable("id") int id) {
		mav = new ModelAndView("/cursos/listado");
		cur.delete(id);
		mav.addObject("listado-cursos");
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest req, HttpServletResponse res) {
		mav = new ModelAndView("/cursos/listado");
		Curso curso = parseCurso(req);
		cur.update(curso);
		mav.addObject("listado-cursos", curso);
		return mav;
	}

	public ModelAndView create(HttpServletRequest req, HttpServletResponse res) {
		mav = new ModelAndView("/cursos/listado");
		Curso curso = parseCurso(req);

		return mav;
	}

	private Curso parseCurso(HttpServletRequest req) {
		Curso curso = null;
		int codigo = Integer.parseInt(req.getParameter("codigo"));
		curso.setCodigo(codigo);
		String nombre = req.getParameter("nombre");
		curso.setNombre(nombre);

		return curso;
	}

}
