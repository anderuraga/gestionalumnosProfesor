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

import com.ipartek.formacion.dao.persistence.Candidato;
import com.ipartek.formacion.service.interfaces.CandidatoService;


@Controller
@RequestMapping(value = "/candidatos")
public class CandidatoController{
	private static final Logger logger = LoggerFactory
			.getLogger(CandidatoController.class);
	@Autowired
	private CandidatoService cnse = null;
	private ModelAndView mav = null;
	@Autowired
	@Qualifier("candidatoValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		mav = new ModelAndView("candidatos/listadoCandidatos");
		List<Candidato> candidatos = cnse.getAll();
		logger.info("numero de candidatos " + candidatos.size());
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

	@RequestMapping(value = "/addCandidato", method = RequestMethod.GET)
	public String addCandidato(Model model) {
		model.addAttribute("candidato", new Candidato());
		return "candidatos/candidato";

	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.POST,
			RequestMethod.DELETE })
	public ModelAndView delete(@PathVariable("id") int id) {
		mav = new ModelAndView("candidatos/listado");
		cnse.delete(id);
		return mav;
	}

	@RequestMapping(value = "/saveCandidato", method = RequestMethod.POST)
	public String saveCandidato(
			@ModelAttribute("candidato") @Validated(Candidato.class) Candidato candidato,
			BindingResult bindingResult) {
		String destino = "";
		if (bindingResult.hasErrors()) {
			logger.info("El candidato tiene errores");
			destino = "candidatos/candidato";
		} else {
			destino = "redirect:/candidatos";
			if (candidato.getCodigo() > 0) {
				cnse.update(candidato);
			} else {
				cnse.create(candidato);
			}
		}
		return destino;
	}

	private Candidato parseCandidato(HttpServletRequest req) {
		Candidato candidato = new Candidato();
		int codigo = Integer.parseInt(req.getParameter("codigoCandidato"));
		String nombre = req.getParameter("nombreCandidato");
		String apellidos = req.getParameter("apellidosCandidato");
		candidato.setCodigo(codigo);
		candidato.setNombre(nombre);
		candidato.setApellidos(apellidos);

		return candidato;
	}

}