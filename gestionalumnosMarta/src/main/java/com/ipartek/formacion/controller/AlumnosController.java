package com.ipartek.formacion.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import com.ipartek.formacion.dao.persistencia.Alumno;
import com.ipartek.formacion.service.AlumnosServiceImp;
import com.ipartek.formacion.service.interfaces.AlumnoService;

@Controller
@RequestMapping(value="/alumnos") //indicamos que esta CLASE va a gestionar las peticiones que lleven alumnos en la url
public class AlumnosController extends MultiActionController{ //indicamos que es un controlador que va a implementar varias acciones
	
	@Autowired
	private AlumnoService as = null;
	private ModelAndView mav = null;
	@Autowired
	@Qualifier("alumnoValidator")
	private Validator validator;
	
	
	
	@InitBinder
	private void initBinder(WebDataBinder binder){
		binder.setValidator(validator);
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	@RequestMapping(method = RequestMethod.GET) 
	public ModelAndView getAll(){
		
		mav = new ModelAndView("/alumnos/listado"); //indicamos la vista
		List<Alumno> alumnos = as.getAll();
		
		mav.addObject("listado-alumnos",alumnos); //metemos el objeto en la respuesta
		
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView getById(@PathVariable("id") int id){ //indicamos el tipo de parametro que recibe
		mav = new ModelAndView("/alumnos/alumno"); //indicamos la vista
		Alumno alumno = as.getById(id);
		
		mav.addObject("alumno",alumno); //metemos el objeto en la respuesta
		
		return mav;
	}
	
	@RequestMapping(value="/addAlumno" , method = RequestMethod.GET) //recibe como parámetro la acción,y busca una ruta cuyo requestmapping sea el del return
	public String addAlumno(Model model){
		model.addAttribute("alumno", new Alumno());
		
		return "alumnos/alumno"; 
	}
	
	//método para update y create 
	@RequestMapping(value="/save" , method = RequestMethod.POST)
	public String saveAlumno(@ModelAttribute("alumno") @Validated Alumno alumno,BindingResult bindingResult){ //recibe un objeto de tipo Alumno y devuelve la ruta donde lo queremos
		//en @ModelAttribute le ponemos el nombre del objeto que hemos puesto en el formulario en el comandName
		String destino= "";
		if(bindingResult.hasErrors()){
			//Logger.info("El alumno tiene errores");
			destino= "/alumnos/alumno";
		}else{
			destino="redirect:/alumnos"; 
			if(alumno.getCodigo()>0){
				as.update(alumno);
			}else{
				as.create(alumno);
			}
		}
		return destino; 
	}
	
	@RequestMapping(method = {RequestMethod.POST,RequestMethod.DELETE}, value= "/{id}")
	public String delete(@PathVariable("id") int id){ //indicamos el tipo de parametro que recibe
		mav = new ModelAndView("/alumnos/listado"); //indicamos la vista
		as.delete(id);
		
		return "redirect:/alumnos";
	}
	
	 
	
	/*
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest req,HttpServletResponse res){
		mav = new ModelAndView("/alumnos/listado");
		Alumno alumno = parseAlumno(req);
		as.update(alumno);
		
		recargarDatos();
		
		return mav;
	}
	*/
	
	/*
	public ModelAndView create(HttpServletRequest req,HttpServletResponse res){
		
		return mav;
	}*/
	
	
	private Alumno parseAlumno(HttpServletRequest req){
		Alumno alumno = new Alumno();
		
		alumno.setCodigo(Integer.parseInt(req.getParameter("codigo")));
		alumno.setNombre(req.getParameter("nombre-alumno"));
		alumno.setApellidos(req.getParameter("apellidos-alumno"));
		
		return alumno;
		
	}
	
	
	
	
	
}
