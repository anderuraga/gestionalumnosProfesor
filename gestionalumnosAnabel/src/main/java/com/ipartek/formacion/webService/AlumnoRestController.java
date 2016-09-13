package com.ipartek.formacion.webService;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ipartek.formacion.dao.persistencia.Alumno;
import com.ipartek.formacion.service.interfaces.AlumnoService;

//Se puede hacer de ambas, con @RestController o con @Controller @ResponseBody
@Controller
@ResponseBody
@RequestMapping(value = "/restful/alumnos")
public class AlumnoRestController {

	@Autowired
	private AlumnoService alumnoService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Alumno>> getAll() {

		List<Alumno> alumnos = this.alumnoService.getAll();
		ResponseEntity<List<Alumno>> respuesta = null;

		if (alumnos.isEmpty()) {
			/*
			 * Se le indica utilizando los codigos de "error" de http, que no
			 * hay datos
			 */
			respuesta = new ResponseEntity<List<Alumno>>(HttpStatus.NOT_FOUND);
		} else {
			respuesta = new ResponseEntity<List<Alumno>>(alumnos, HttpStatus.OK);
		}
		return respuesta;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Alumno> getById(@PathVariable("id") int id) {

		Alumno alumno = this.alumnoService.getById(id);
		ResponseEntity<Alumno> respuesta = null;
		if (alumno == null) {
			respuesta = new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
		} else {
			respuesta = new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
		}
		return respuesta;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(Alumno alumno) {

		ResponseEntity<Void> respuesta = null;
		Alumno alu = this.alumnoService.create(alumno);
		/*
		 * Esto se haria cuando la BB.DD. nos devuelve la id al crear un usuario.
		 * if(alu.getCodigo()>-1
		 */
		respuesta = new ResponseEntity<Void>(HttpStatus.CREATED);
		return respuesta;
	}

	@RequestMapping(value = "delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id")int id) {
		ResponseEntity<Void> respuesta = null;
		
		if(this.alumnoService.getById(id) != null){
			respuesta = new ResponseEntity<Void>(HttpStatus.OK);
		}else{
			respuesta = new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
		return respuesta;

	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Alumno> update(@PathVariable("id") int id,@RequestBody Alumno alumno){
		ResponseEntity<Alumno> respuesta = null;
		if(this.alumnoService.getById(id) != null){
			
			this.alumnoService.update(alumno);
			respuesta = new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
			
		}else{
			respuesta = new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
		}
		return null;
		
	}

}
