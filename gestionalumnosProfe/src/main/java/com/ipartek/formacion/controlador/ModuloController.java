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

import com.ipartek.formacion.dao.AlumnoDAOImp;
import com.ipartek.formacion.dao.persistence.Modulo;
import com.ipartek.formacion.service.interfaces.ModuloService;

@Controller
@RequestMapping(value = "/modulos")
public class ModuloController extends MultiActionController {
	private static final Logger logger = LoggerFactory
			.getLogger(ModuloController.class);
	@Autowired
	private ModuloService mService = null;
	private ModelAndView mav = null;
	@Autowired
	@Qualifier("moduloValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		mav = new ModelAndView("/modulos/listado");
		mav.addObject("listaModulos", mService.getAll());
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView getById(@PathVariable("id") int id) {
		mav = new ModelAndView("/modulos/modulo");
		mav.addObject("modulo", mService.getById(id));
		return mav;
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.DELETE }, value = "/{id}")
	public String delete(@PathVariable("id") int id) {
		mService.delete(id);
		return "redirect:/modulos";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/addModulo")
	public String addModulo(Model model) {
		model.addAttribute("modulo", new Modulo());
		return "/modulos/modulo";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/save")
	public String save(@ModelAttribute("modulo") @Validated Modulo modulo,
			BindingResult bindingResult, Model model) {
		String destino = "";
		if (bindingResult.hasErrors()) {
			destino = "/modulos/modulo";
			logger.info("El modulo tiene errores");
		} else {
			destino = "redirect:/modulos";
			if (modulo.getCodigo() > 0) {
				mService.update(modulo);
			} else {
				mService.create(modulo);
			}
		}
		return destino;
	}
}
