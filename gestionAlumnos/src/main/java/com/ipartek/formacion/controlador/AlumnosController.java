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
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ipartek.formacion.dao.persistencia.Alumno;
import com.ipartek.formacion.service.AlumnoServiceImp;
/**
 * 
 * @author Curso
 *
 */
@Controller
@RequestMapping(value="/alumnos")
public class AlumnosController{
	private static final Logger logger = LoggerFactory.getLogger(AlumnosController.class);
	@Autowired
	private AlumnoServiceImp as=null;
	private ModelAndView mav=null;
	@Autowired
	@Qualifier("alumnoValidator")//extension del autowired para que busque el id del bean
	private Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder){
		binder.setValidator(validator);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getAll(){
		mav=new ModelAndView("/alumnos/listado");
		List<Alumno>alumnos=as.getAll();
		mav.addObject("listado_alumnos",alumnos);
		return mav;
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id") int id){
		mav=new ModelAndView("alumnos/alumno");
		Alumno alumno=as.getById(id);
		mav.addObject("alumno",alumno);
		return mav;
	}
	
	@RequestMapping(value="/addAlumno", method=RequestMethod.GET)//el methodrequest no hace falta ponerlo, en este caso
	//con el nombre del value es suficiente
	public String addAlumno(Model model){
		model.addAttribute("alumno",new Alumno());
		return "alumnos/alumno";
	}
	
	@RequestMapping(value="/{id}", method={RequestMethod.POST, RequestMethod.DELETE})
	public ModelAndView delete(@PathVariable("id") int id){
		mav=new ModelAndView("alumnos/listado");
		as.delete(id);
		return mav;
	}
	
	@Valid
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveAlumno(@ModelAttribute("alumno") @Validated(Alumno.class) Alumno alumno, BindingResult bindingResult){//en el modelAtt, el mismo nombre que 
		//en el commandname del form
		String destino="";
		if(bindingResult.hasErrors()){
			logger.info("El alumno tiene errores");
			destino="alumnos/alumno";
		}else{
			destino="redirect:/alumnos";
		}
		
		if(alumno.getCodigo()>0){
			as.update(alumno);
		}else{
			as.create(alumno);
		}

		return destino;
	}
	
	private Alumno parseAlumno(HttpServletRequest req){
		Alumno alumno=new Alumno();
		int codigo=Integer.parseInt(req.getParameter("codigo"));
		String nombre=req.getParameter("nombre_alumno");
		String apellidos=req.getParameter("apellidos_alumno");
		String email=req.getParameter("email");
		String dni=req.getParameter("dni");
		String telefono=req.getParameter("telefono");
		int codGenero=Integer.parseInt(req.getParameter("codGenero"));
		
		alumno.setCodigo(codigo);
		alumno.setNombre(nombre);
		alumno.setApellidos(apellidos);
		alumno.setEmail(email);
		alumno.setDni(dni);
		alumno.setTelefono(telefono);
		alumno.setCodGenero(codGenero);
		return alumno;
	}
	
	@RequestMapping(value="/restclients", method=RequestMethod.GET)
	public String sendToRestGetAll(){
		return "/alumnos/listado_rest";
	}
}
