package com.ipartek.formacion.controller;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.ipartek.formacion.dao.interfaces.AlumnoService;
import com.ipartek.formacion.dao.persistence.Alumno;
/**
 * Handles requests for the application home page.
 */
import com.ipartek.formacion.service.AlumnoServiceImp;
@Controller public class HomeController {
	private static final Logger	logger	= LoggerFactory.getLogger(HomeController.class);
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired AlumnoService	as;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	// public ModelAndView home(Locale locale, Model model) {
	//	Date date = new Date();
	//	DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	//		
	//	String formattedDate = dateFormat.format(date);
	//	model.addAttribute("serverTime", formattedDate);
	//	mav.addObject("serverTime", formattedDate);
	public ModelAndView home() {
		
		ModelAndView mav = null;
		mav = new ModelAndView("home");
		//	logger.info("Welcome home! The client locale is {}.", locale);
		logger.info("Carga la pagina");
		List<Alumno> alumnos = as.getAll();
		mav.addObject("listado-alumnos", alumnos);
		return mav;
	}
}
