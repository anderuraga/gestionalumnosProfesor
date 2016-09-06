package com.ipartek.formacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ipartek.formacion.dao.persistence.Candidato;
import com.ipartek.formacion.service.interfaces.CandidatoService;

@Controller
@RequestMapping(value = "/candidatos")
public class CandidatoController extends MultiActionController {

	@Autowired
	private CandidatoService cnse = null;
	private ModelAndView mav = null;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		mav = new ModelAndView("candidatos/listadoCandidatos");
		List<Candidato> candidatos = cnse.getAll();

		mav.addObject("listado-candidatos", candidatos);
		return mav;

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id") int id) {
		mav = new ModelAndView("candidatos/candidato");
		Candidato candidato = cnse.getById(id);
		mav.addObject("candidato", candidato);
		return mav;
	}
}
