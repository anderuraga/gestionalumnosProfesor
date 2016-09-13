package com.ipartek.formacion.webservices;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@RestController // @Controller + @ResponseBody
@RequestMapping(value="/restful/alumnos")
public class AlumnosRestController {
	@Autowired
	AlumnoService as;
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Alumno>> getAll(){
		List<Alumno> alumnos = as.getAll();
		ResponseEntity<List<Alumno>> respuesta = null;
		
		if(alumnos.isEmpty()){
			respuesta = new ResponseEntity<List<Alumno>>(HttpStatus.NO_CONTENT);
		} else{
			respuesta = new ResponseEntity<List<Alumno>>(alumnos, HttpStatus.OK);
		}
		
		return respuesta;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Alumno> getById(@PathVariable("id") int id){
		Alumno alumno = as.getById(id);
		ResponseEntity<Alumno> respuesta = null;
		
		if(alumno==null){
			respuesta = new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
		} else{
			respuesta = new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
		}
		
		return respuesta;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Alumno alumno){
		Alumno alum = as.create(alumno);
		ResponseEntity<Void> respuesta = null;
		
		if(alum.getCodigo()>-1){
			respuesta = new ResponseEntity<Void>(HttpStatus.CREATED);
		} else{
			System.out.println("Alumno: " + alum.toString());
			respuesta = new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		System.out.println("Pasamos por aqui");
		log.debug("Pasamos por aqui");
		
		return respuesta;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") int id){
		ResponseEntity<Void> respuesta = null;
		if(as.getById(id)!=null){
			as.delete(id);
			respuesta = new ResponseEntity<Void>(HttpStatus.OK);
		} else{
			respuesta = new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		return respuesta;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Alumno> update(@PathVariable("id") int id, @RequestBody Alumno alumno){
		ResponseEntity<Alumno> respuesta = null;
		
		if(as.getById(id)!=null){
			as.update(alumno);
			respuesta = new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
		} else{
			respuesta = new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
		}
		
		return respuesta;
	}
	
}
