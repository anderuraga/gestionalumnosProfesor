package com.ipartek.formacion.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import com.ipartek.formacion.dao.persistence.Alumno;
import com.ipartek.formacion.service.AlumnoServiceImp;
@Controller @RequestMapping(value = "/alumnos")
/*
 * La clase MultiActionController es de SPRING
 * 
 * damos a entender que este controlador va a tener mas de una accion y deberiamos mapear cada metodo
 * 
 * Como mapeamos el metodo en cuestion:
 * actualmente solo tenemos el get all pero luego existiran mas, el get by id, el delete
 * los mapeos en sping se hacen a traves de URL, la url tal cual, da igual si es get o post
 * tambien se pude mapear segun el tipo de peticion
 * 
 * Aqui entran los cuatro protocolos CRUD
 * 
 * Son mediante condiciones, Siempre que sea una peticion tipo alumnos y get y no tengamos mas peticiones es un get all.
 * 
 *Si es una peticion tipo alumnos, un get y se pide la ID, es un Get by id.
 *
 *Como se mapea:
 *@RequestMapping => para que sea get se añade: (method = RequestMethod.GET)
 *mas adelante especificaremos values...
 * */
public class AlumnosController extends MultiActionController {
	@Autowired private AlumnoServiceImp as = null;
	@RequestMapping(method = RequestMethod.GET) public ModelAndView getAll() {
		ModelAndView mav = null;
		mav = new ModelAndView("alumnos/listado");
		List<Alumno> alumnos = as.getAll();
		mav.addObject("listado-alumnos", alumnos);
		return mav;
	}
}
