package com.ipartek.formacion.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.dao.persistence.Curso;
import com.ipartek.formacion.service.CursosServiceImp;

import com.ipartek.formacion.service.interfaces.CursoService;


@RestController
@RequestMapping(value="/restful/cursos")
public class CursosRestController {

	CursoService cS;
	

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Curso>>getAll(){
		List<Curso>cursos=cS.getAll();
		ResponseEntity<List<Curso>>respuesta=null;
		if (cursos.isEmpty()) {
			respuesta=new ResponseEntity<List<Curso>>(HttpStatus.CONFLICT);
		}else {
			respuesta=new ResponseEntity<List<Curso>>(cursos,HttpStatus.OK);
		}
		return respuesta;
	}
	
}
