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

import com.ipartek.formacion.dao.persistencia.Curso;
import com.ipartek.formacion.service.CursoServiceImp;

@Controller
@RequestMapping(value="/cursos")
public class CursosController {
	private static final Logger logger = LoggerFactory.getLogger(CursosController.class);
	@Autowired
	private CursoServiceImp cs=null;
	private ModelAndView mav=null;
	@Autowired
	@Qualifier("cursoValidator")
	private Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder){
		binder.setValidator(validator);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getAll(){
		mav=new ModelAndView("/cursos/listado");
		List<Curso>cursos=cs.getAll();
		mav.addObject("listado_cursos",cursos);
		return mav;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id")int id){
		mav=new ModelAndView("cursos/curso");
		Curso curso=cs.getById(id);
		mav.addObject("curso",curso);
		return mav;
	}
	
	@RequestMapping(value="/addCurso", method=RequestMethod.GET)
	public String addAlumno(Model model){
		model.addAttribute("curso", new Curso());
		return "cursos/curso";
	}
	
	@RequestMapping(value="/{id}", method={RequestMethod.POST,RequestMethod.DELETE})
	public ModelAndView delete(@PathVariable("id")int id){
		mav=new ModelAndView("/cursos/listado");
		cs.delete(id);
		return mav;
	}
	@Valid
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveCurso(@ModelAttribute("curso") @Validated(Curso.class) Curso curso, BindingResult bindingResult){
		String destino="";
		if(bindingResult.hasErrors()){
			logger.info("El curso tiene errores");
			destino="cursos/curso";
		}else{
			destino="redirect:/cursos";
		}
		
		if(curso.getCodigo()>0){
			cs.update(curso);
		}else{
			cs.create(curso);
		}
		
		return destino;
	}

	private Curso parseCurso(HttpServletRequest req) {
		Curso curso=new Curso();
		int codigo=Integer.parseInt(req.getParameter("codigo"));
		String nombre=req.getParameter("nombre_curso");
		int codPatrocinador=Integer.parseInt(req.getParameter("codPatrocinador"));
		int codTipoCurso=Integer.parseInt(req.getParameter("codTipoCurso"));
		curso.setCodigo(codigo);
		curso.setNombre(nombre);
		curso.setCodPatrocinador(codPatrocinador);
		curso.setCodTipoCurso(codTipoCurso);
		return curso;
	}
	
}
