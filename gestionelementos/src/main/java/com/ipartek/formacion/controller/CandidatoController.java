package com.ipartek.formacion.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class CandidatoController extends MultiActionController {
	private static final Logger logger = LoggerFactory
			.getLogger(CandidatoController.class);
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
	@RequestMapping(value = "/{id}", method = { RequestMethod.POST, RequestMethod.DELETE })
	public ModelAndView Delete(@PathVariable("id") int id) {
		mav = new ModelAndView("candidatos/listado");
		cnse.delete(id);
		return mav;
	}
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView update(HttpServletRequest req,HttpServletResponse res){
        Candidato candidato=parseCandidato(req);
        cnse.update(candidato);
        return mav;
        
    }

	@RequestMapping(value = "/newCandidato", method = RequestMethod.GET)
	public String addCandidato(Model model) {
		model.addAttribute("candidato", new Candidato());
		return "candidatos/candidato";
	}

	@RequestMapping(value = "/saveCandidato", method = RequestMethod.POST)
	public String saveCandidato(@ModelAttribute("candidato") Candidato candidato) {
		if (candidato.getCodigo() > 0) {
			cnse.update(candidato);
		} else {
			cnse.create(candidato);
		}
		return "redirect:/candidatos";

	}

	// ### Esto es java clasico ###
	private Candidato parseCandidato(HttpServletRequest req) {
		Candidato candidato = new Candidato();

		int codigo = Integer.parseInt(req.getParameter("codigo-candidato"));
		String nombre = req.getParameter("nombre-candidato");
		String apellidos = req.getParameter("apellidos-candidato");

		candidato.setCodigo(codigo);
		candidato.setNombre(nombre);
		candidato.setApellidos(apellidos);

		return candidato;

	}

}