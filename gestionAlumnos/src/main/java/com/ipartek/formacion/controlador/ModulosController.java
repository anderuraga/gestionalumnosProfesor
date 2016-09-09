package com.ipartek.formacion.controlador;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

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

import com.ipartek.formacion.dao.persistencia.Modulo;
import com.ipartek.formacion.service.ModuloServiceImp;

@Controller
@RequestMapping(value="/modulos")
public class ModulosController {
	private static final Logger logger = LoggerFactory.getLogger(ModulosController.class);
	@Autowired
	private ModuloServiceImp ms=null;
	private ModelAndView mav=null;
	
	@Autowired
	@Qualifier("moduloValidator")
	private Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder){
		binder.setValidator(validator);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getAll(){
		mav=new ModelAndView("/modulos/listado");
		List<Modulo>modulos=ms.getAll();
		mav.addObject("listado_modulos",modulos);
		return mav;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id") int id){
		mav=new ModelAndView("modulos/modulo");
		Modulo modulo=ms.getById(id);
		mav.addObject("modulo",modulo);
		return mav;
	}
	
	@RequestMapping(value="/addModulo", method=RequestMethod.GET)
	public String addModulo(Model model){
		model.addAttribute("modulo", new Modulo());
		return "modulos/modulo";
	}
	
	@RequestMapping(value="/{id}", method={RequestMethod.POST, RequestMethod.DELETE})
	public ModelAndView delete(@PathVariable("id")int id){
		mav=new ModelAndView("modulos/listado");
		ms.delete(id);
		return mav;
	}
	
	@Valid
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveModulo(@ModelAttribute("modulo") @Validated(Modulo.class) Modulo modulo, BindingResult bindingResult){
		String destino="";
		if(bindingResult.hasErrors()){
			logger.info("El módulo tiene errores");
			destino="modulos/modulo";
		}else{
			destino="redirect:/modulos";
		}
		
		if(modulo.getCodigo()>0){
			ms.update(modulo);
		}else{
			ms.create(modulo);
		}
		
		return destino;
	}

	private Modulo parseModulo(HttpServletRequest req) {
		Modulo modulo=new Modulo();
		int codigo=Integer.parseInt(req.getParameter("codigo"));
		String nombre=req.getParameter("nombre_modulo");
		String uFormativa=req.getParameter("uFormativa");
		int duracion=Integer.parseInt(req.getParameter("duracion"));
		modulo.setCodigo(codigo);
		modulo.setNombre(nombre);
		modulo.setuFormativa(uFormativa);
		modulo.setDuracion(duracion);
		return modulo;
	}
}
