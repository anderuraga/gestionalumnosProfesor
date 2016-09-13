package com.ipartek.formacion.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.dao.persistencia.Alumno;
import com.ipartek.formacion.service.interfaces.AlumnoService;

@RestController
@RequestMapping(value="/restful/alumnos")
public class AlumnosRestController {
	@Autowired
	AlumnoService as;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Alumno>> getAll(){ //ResponseEntity->elemento de spring que encapsula los encabezados http
		
		return null;
	}
}
