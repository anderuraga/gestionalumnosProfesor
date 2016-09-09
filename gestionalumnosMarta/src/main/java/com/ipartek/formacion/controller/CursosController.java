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

import com.ipartek.formacion.dao.persistencia.Alumno;
import com.ipartek.formacion.dao.persistencia.Curso;
import com.ipartek.formacion.service.interfaces.CursoService;

@Controller
@RequestMapping(value="/cursos") //indicamos que esta CLASE va a gestionar las peticiones que lleven cursos en la url
public class CursosController {

	@Autowired
	private CursoService as = null;
	private ModelAndView mav = null;
	@Autowired
	@Qualifier("cursoValidator")
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
		mav = new ModelAndView("/cursos/listado"); //indicamos la vista
		List<Curso> cursos = as.getAll();
		
		mav.addObject("listado-cursos",cursos); //metemos el objeto en la respuesta
		
		return mav;
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView getById(@PathVariable("id") int id){ //indicamos el tipo de parametro que recibe
		mav = new ModelAndView("/cursos/curso"); //indicamos la vista
		Curso curso = as.getById(id);
		
		mav.addObject("curso",curso); //metemos el objeto en la respuesta
		
		return mav;
	}
	
	@RequestMapping(value="/addCurso" , method = RequestMethod.GET) //recibe como parámetro la acción,y busca una ruta cuyo requestmapping sea el del return
	public String addCurso(Model model){
		model.addAttribute("curso", new Curso());
		
		return "cursos/curso"; 
	}
	
	@RequestMapping(method = {RequestMethod.POST,RequestMethod.DELETE}, value= "/{id}")
	public String delete(@PathVariable("id") int id){ //indicamos el tipo de parametro que recibe
		mav = new ModelAndView("/cursos/listado"); //indicamos la vista
		as.delete(id);
		
		return "redirect:/cursos";
	}
	
	//método para update y create 
		@RequestMapping(value="/save" , method = RequestMethod.POST)
		public String saveCurso(@ModelAttribute("curso") @Validated Curso curso,BindingResult bindingResult){ //recibe un objeto de tipo Alumno y devuelve la ruta donde lo queremos
			String destino= "";
			if(bindingResult.hasErrors()){
				//Logger.info("El alumno tiene errores");
				destino= "/cursos/curso";
			}else{
				destino="redirect:/cursos"; 
				if(curso.getCodigo()>0){
					as.update(curso);
				}else{
					as.create(curso);
				}
			}
			return destino;
		}
	
	


	private Curso parseCurso(HttpServletRequest req) {
		Curso curso = new Curso();
		
		curso.setCodigo(Integer.parseInt(req.getParameter("codigo")));
		curso.setNombre(req.getParameter("nombre-curso"));
		
		return curso;
	}
	
}
