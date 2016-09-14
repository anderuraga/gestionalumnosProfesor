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
import com.ipartek.formacion.dao.persistence.Modulo;
import com.ipartek.formacion.service.interfaces.ModuloService;

@RestController
@RequestMapping(value="/restful/modulos")
public class ModulosRestController {
	
	@Autowired
	ModuloService ms;
	
	Logger log = LoggerFactory.getLogger(ModulosRestController.class);
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Modulo>> getAll(){
		List<Modulo> modulos = ms.getAll();
		ResponseEntity<List<Modulo>> respuesta = null;
		
		if(modulos.isEmpty()){
			respuesta = new ResponseEntity<List<Modulo>>(HttpStatus.NO_CONTENT);
		} else{
			respuesta = new ResponseEntity<List<Modulo>>(modulos, HttpStatus.OK);
		}
		
		return respuesta;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Modulo> getById(@PathVariable("id") int id){
		Modulo modulo = ms.getById(id);
		ResponseEntity<Modulo> respuesta = null;
		
		if(modulo==null || modulo.getCodigo()<0){
			respuesta = new ResponseEntity<Modulo>(HttpStatus.NOT_FOUND);
		} else{
			respuesta = new ResponseEntity<Modulo>(modulo, HttpStatus.OK);
		}
		
		return respuesta;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Modulo modulo){
		Modulo modul = ms.create(modulo);
		ResponseEntity<Void> respuesta = null;
		
		if(modul.getCodigo()>-1){
			respuesta = new ResponseEntity<Void>(HttpStatus.CREATED);
		} else{
			respuesta = new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		return respuesta;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") int id){
		ResponseEntity<Void> respuesta = null;
		if(ms.getById(id)!=null){
			ms.delete(id);
			respuesta = new ResponseEntity<Void>(HttpStatus.OK);
		} else{
			respuesta = new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		return respuesta;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Modulo> update(@PathVariable("id") int id, @RequestBody Modulo modulo){
		ResponseEntity<Modulo> respuesta = null;
		
		if(ms.getById(id)!=null){
			ms.update(modulo);
			respuesta = new ResponseEntity<Modulo>(modulo, HttpStatus.OK);
		} else{
			respuesta = new ResponseEntity<Modulo>(HttpStatus.NOT_FOUND);
		}
		
		return respuesta;
	}
}
