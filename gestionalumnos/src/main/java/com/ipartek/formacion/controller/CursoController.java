package com.ipartek.formacion.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.ipartek.formacion.dao.persistence.Curso;
import com.ipartek.formacion.service.CursoServiceImp;

@Controller
@RequestMapping(value = "/cursos")
public class CursoController {
	private static final Logger logger = LoggerFactory.getLogger(CursoController.class);
	@Autowired
	private CursoServiceImp cur = null;
	private ModelAndView mav = null;
	
	@Autowired
	@Qualifier("cursoValidator")
	private Validator validator;
	
	@InitBinder
	private void InitBinder(WebDataBinder binder){
		binder.setValidator(validator);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {

		mav = new ModelAndView("cursos/listado");
		List<Curso> cursos = cur.getAll();
		mav.addObject("listado-cursos", cursos);
		return mav;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getByID(@PathVariable("id") int id) {
		mav = new ModelAndView("cursos/curso");
		Curso curso = cur.getByID(id);
		mav.addObject("curso", curso);
		return mav;
	}

	@RequestMapping(value="/addCurso", method=RequestMethod.GET)
	public String addCurso(Model model){
		model.addAttribute("curso", new Curso());
		return "cursos/curso";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest req, HttpServletResponse res) {
		mav = new ModelAndView("cursos/listado");
		Curso curso = parseCurso(req);
		cur.update(curso);
		mav.addObject("listado-cursos", curso);
		return mav;
	}
	
	@RequestMapping(value = "deleteCurso/{id}")
	public String delete(@PathVariable("id") int id) {
		cur.delete(id);
		return "redirect:/cursos";
	}

	@RequestMapping(value="/save")
	public String saveAlumno(@ModelAttribute("curso") @Validated(Curso.class) Curso curso, BindingResult bindingResult){//el objeto del model attribute se llama igual que el commandName del formulario, será lo que recibirá encapsulado
		//el objeto del model attribute se llama igual que el commandName del formulario, será lo que recibirá encapsulado
		//@Validated se usa para obligar a validar los datos a guardar
		String destino ="";
				
		if(bindingResult.hasErrors()){
			logger.info("El curso tiene errores");
			destino = "cursos/curso"; 
			//como tiene errores, lo manda otra vez a la pagina de modulo nuevo.
		}else{
			destino = "redirect:/cursos"; // ofuscacion de URL
			if(curso.getCodigo()>0){
				cur.update(curso);
			}else{
				cur.create(curso);
			}
		}
		return destino; 
	}

	private Curso parseCurso(HttpServletRequest req) {
		Curso curso = null;
		int codigo = Integer.parseInt(req.getParameter("codigo"));
		curso.setCodigo(codigo);
		String nombre = req.getParameter("nombre");
		curso.setNombre(nombre);
		String codPatrocinador = req.getParameter("codPatrocinador");
		curso.setCodPatrocinador(codPatrocinador);
		int codTipoCurso = Integer.parseInt(req.getParameter("codTipoCurso"));
		curso.setCodTipoCurso(codTipoCurso);

		return curso;
	}

}
