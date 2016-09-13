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

import com.ipartek.formacion.dao.persistence.Curso;
import com.ipartek.formacion.service.CursosServiceImp;

@Controller
@RequestMapping(value="/cursos")
public class CursosController extends MultiActionController {

	private static final Logger logger = LoggerFactory.getLogger(CursosController.class);
	
	@Autowired
	private CursosServiceImp cs=null;
	private ModelAndView mav=null;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getAll(){
		mav=new ModelAndView("cursos/listado");
		List<Curso>cursos=cs.getAll();
		mav.addObject("listado-cursos",cursos);
		
		return mav;
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id")int id){
		mav=new ModelAndView("/cursos/curso");
		Curso c=cs.getById(id);
		mav.addObject("curso",c);
		return mav;
		
	}
	
	@RequestMapping(value="/{id}", method={RequestMethod.POST,RequestMethod.DELETE})
	public ModelAndView delete(@PathVariable("id")int id){
		mav=new ModelAndView("/cursos/listado");
		cs.delete(id);
		return mav;
	}
	
//	@RequestMapping(method=RequestMethod.POST)
//	public ModelAndView update(HttpServletRequest req,HttpServletResponse res){
//		Curso c=parseCurso(req);
//		cs.update(c);
//		return mav;
//		
//	}
	
	@RequestMapping("/addCurso")
	public String addCurso(Model model){
		model.addAttribute("curso", new Curso());
		return "cursos/curso";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveCurso(@ModelAttribute("curso")Curso curso){
		if (curso.getCodCurso()>0) {
			cs.update(curso);
		}else {
			cs.create(curso);
		}
		return "redirect:/alumnos";
	}

	private Curso parseCurso(HttpServletRequest req) {
		Curso c=new Curso();
		c.setCodCurso(Integer.parseInt(req.getParameter("codCurso")));
		c.setNombreCurso(req.getParameter("nombreCurso"));
		c.setCodPatrocinador(req.getParameter("codPatrocinador"));
		c.setTipoCurso(Integer.parseInt(req.getParameter("tipoCurso")));
		return c;
	}
	
	
	
	
	
}
