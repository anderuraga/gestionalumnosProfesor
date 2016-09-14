package com.ipartek.formacion.webService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.dao.persistencia.Modulo;
import com.ipartek.formacion.service.interfaces.ModuloService;

@RestController
@RequestMapping("/restful/modulos")
public class ModuloRestController {

	@Autowired
	private ModuloService moduloService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Modulo>> getAll(){
		
		ResponseEntity<List<Modulo>> respuesta = null;
		List<Modulo> modulos = this.moduloService.getAll();
		
		if(modulos.isEmpty()){
			respuesta = new ResponseEntity<List<Modulo>>(HttpStatus.NOT_FOUND);
		}else{
			respuesta = new ResponseEntity<List<Modulo>>(modulos, HttpStatus.OK);
		}
		
		return respuesta;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Modulo> getById(@PathVariable("id") int id){
		
		ResponseEntity<Modulo> respuesta = null;
		if(this.moduloService.getById(id) != null){
			Modulo modulo = this.moduloService.getById(id);
			respuesta = new ResponseEntity<Modulo>(modulo, HttpStatus.OK);
		}else{
			respuesta = new ResponseEntity<Modulo>(HttpStatus.NOT_FOUND);
		}
		return respuesta;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") int id){
		
		ResponseEntity<Void> respuesta = null;
		if(this.moduloService.getById(id) != null){
			this.moduloService.delete(id);
			respuesta = new ResponseEntity<Void>(HttpStatus.OK);
		}else{
			respuesta = new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return respuesta;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable("id") int id, Modulo modulo){
		
		ResponseEntity<Void> respuesta = null;
		if(this.moduloService.getById(id) != null){
			this.moduloService.update(modulo);
			respuesta = new ResponseEntity<Void>(HttpStatus.OK);
		}else{
			respuesta = new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		return respuesta;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(Modulo modulo){
		
		ResponseEntity<Void> respuesta = null;
		this.moduloService.create(modulo);
		respuesta = new ResponseEntity<Void>(HttpStatus.OK);
		return respuesta;
	}
}
