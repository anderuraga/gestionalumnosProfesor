package com.ipartek.formacion.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ipartek.formacion.dao.persistence.Alumno;
import com.ipartek.formacion.service.AlumnosServiceImp;



@Controller
@RequestMapping(value="/alumnos")

public class AlumnosController extends MultiActionController {
	
	private static final Logger logger = LoggerFactory.getLogger(AlumnosController.class);
	
	@Autowired
	private AlumnosServiceImp as=null;
	private ModelAndView mav=null;
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getAll(){
		
		mav=new ModelAndView("alumnos/listado");
		List<Alumno>alumnos=as.getAll();
		mav.addObject("listado-alumnos",alumnos);
		
		
		return mav;
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id")int id){
		mav=new ModelAndView("/alumnos/alumno");
		Alumno a=as.getById(id);
		mav.addObject("alumno",a);
		
		return mav;
	}
	@RequestMapping(value="/{id}", method={RequestMethod.POST,RequestMethod.DELETE})
	public ModelAndView delete(@PathVariable("id")int id){
		
		mav=new ModelAndView("/alumnos/listado");
		as.delete(id);
		
		return mav;
		
	}
	/*
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView update(HttpServletRequest req,HttpServletResponse res){
		Alumno a=parseAlumno(req);
		as.update(a);
		return mav;
		}
	*/
	@RequestMapping("/addAlumno")
	public String addAlumno(Model model){
		model.addAttribute("alumno",new Alumno());
		return "alumnos/alumno";
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveAlumno(@ModelAttribute ("alumno") @Validated  Alumno alumno, BindingResult bindingResult){ //alumno es el commandName del jsp
		String destino="";
		if (bindingResult.hasErrors()) {
			logger.info("El alumno tiene errores");
			destino= "alumnos/alumno";
		}else {
			destino="redirect:/alumnos";
			if (alumno.getCodigo()>0) {
				
				as.update(alumno);
			}else {
				
				as.create(alumno);
			}
		}
		
		
		return destino;
	}
	/*
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView create(HttpServletRequest req,HttpServletResponse res){
		Alumno a=parseAlumno(req);
		as.create(a);
		
		return mav;
	}
	*/
	private Alumno parseAlumno(HttpServletRequest req){
		Alumno a=new Alumno();
		a.setCodigo(Integer.parseInt(req.getParameter("codAlumno")));
		a.setNombre(req.getParameter("nombre"));
		a.setApellidos(req.getParameter("apellidos"));
		SimpleDateFormat fmt=new SimpleDateFormat("dd-MMM-yyyy");
		try {
			a.setfNacimiento(fmt.parse(req.getParameter("fNacimiento")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return a;
		
	}
}
