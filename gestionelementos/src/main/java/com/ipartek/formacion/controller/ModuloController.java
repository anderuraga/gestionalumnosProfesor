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

import com.ipartek.formacion.dao.persistence.Modulo;
import com.ipartek.formacion.service.interfaces.ModuloService;

@Controller
@RequestMapping(value = "/modulos")
public class ModuloController{
	private static final Logger logger = LoggerFactory
			.getLogger(ModuloController.class);
	@Autowired
	private ModuloService mose = null;
	private ModelAndView mav = null;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		mav = new ModelAndView("modulos/listadoModulos");
		List<Modulo> modulos = mose.getAll();
		logger.info("numero de modulos "+ modulos.size());
		mav.addObject("listado-modulos", modulos);
		return mav;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id") int id) {
		mav = new ModelAndView("modulos/modulo");
		Modulo modulo = mose.getById(id);
		mav.addObject("modulo", modulo);
		return mav;
	}
	@RequestMapping(value = "/{id}", method = { RequestMethod.POST, RequestMethod.DELETE })
	public ModelAndView Delete(@PathVariable("id") int id) {
		mav = new ModelAndView("modulos/listado");
		mose.delete(id);
		return mav;
	}
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView update(HttpServletRequest req,HttpServletResponse res){
        Modulo modulo=parseModulo(req);
        mose.update(modulo);
        return mav;
        
    }

	@RequestMapping(value = "/newModulo", method = RequestMethod.GET)
	public String addModulo(Model model) {
		model.addAttribute("modulo", new Modulo());
		return "modulos/modulo";
	}

	@RequestMapping(value = "/saveModulo", method = RequestMethod.POST)
	public String saveModulo(@ModelAttribute("modulo") Modulo modulo) {
		if (modulo.getCodigo() > 0) {
			mose.update(modulo);
		} else {
			mose.create(modulo);
		}
		return "redirect:/modulos";

	}

	// ### Esto es java clasico ###
	private Modulo parseModulo(HttpServletRequest req) {
		Modulo modulo = new Modulo();

		int codigo = Integer.parseInt(req.getParameter("codigo-modulo"));
		String nombre = req.getParameter("nombre-modulo");

		modulo.setCodigo(codigo);
		modulo.setNombre(nombre);

		return modulo;

	}

}