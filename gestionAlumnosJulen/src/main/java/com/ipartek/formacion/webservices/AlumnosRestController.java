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

import com.ipartek.formacion.dao.persistence.Alumno;
import com.ipartek.formacion.service.interfaces.AlumnoService;
//@RestController == anotacion de spring 4, es la suma de @Controller y @Responsebody
@RestController
@RequestMapping(value="/restful/alumnos")
public class AlumnosRestController {

	@Autowired
	AlumnoService as;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Alumno>> getAll(){
		List<Alumno> alumnos = as.getAll();
		ResponseEntity<List<Alumno>> respuesta=null;
		if(alumnos.isEmpty()){
			respuesta = new ResponseEntity<List<Alumno>>(HttpStatus.NO_CONTENT);
		}
		else
		{
			respuesta = new ResponseEntity<List<Alumno>>(HttpStatus.OK);
		}
		return respuesta;
	}
	
	@RequestMapping(value ="/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Alumno> getById(@PathVariable("id") int id){
		Alumno alum = as.getById(id);
		ResponseEntity<Alumno> respuesta = null;
		if(alum==null)
		{
			respuesta = new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
		}
		else
		{
			respuesta = new ResponseEntity<Alumno>(alum, HttpStatus.OK);
		}
		return respuesta;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> createAlumno(Alumno alumno){
		ResponseEntity<Void> respuesta;
		Alumno alum = as.create(alumno);
		if(alum.getCodigo()>-1){
			respuesta = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		else
		{
			respuesta = new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return respuesta;
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAlumno(@PathVariable("id") int id){
		ResponseEntity<Void> respuesta;
		
		if(as.getById(id) != null){
			as.delete(id);
			respuesta = new ResponseEntity<Void>(HttpStatus.OK);
		}
		else
		{
			respuesta = new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return respuesta;
		
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Alumno> updateAlumno(@PathVariable("id") int id, @RequestBody Alumno alumno){
		ResponseEntity<Alumno> respuesta;
		if(as.getById(id) != null){
			as.update(alumno);
			respuesta = new ResponseEntity<Alumno>(HttpStatus.CREATED);
		}
		else
		{
			respuesta = new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
		}
		
		return respuesta;
		
	}
}
