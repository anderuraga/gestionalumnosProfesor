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

import com.ipartek.formacion.dao.persistence.Modulo;
import com.ipartek.formacion.service.ModulosServiceImp;
import com.ipartek.formacion.service.interfaces.ModuloService;


@RestController
@RequestMapping(value="/restful/modulos")
public class ModulosRestController {

	@Autowired
	ModuloService mS;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Modulo>> getAll(){
		List<Modulo>modulos=mS.getAll();
		ResponseEntity<List<Modulo>> respuesta=null;
		if (modulos.isEmpty()) {
			respuesta= new ResponseEntity<List<Modulo>>(HttpStatus.CONFLICT);
		}else {
			respuesta=new ResponseEntity<List<Modulo>>(modulos,HttpStatus.OK);
		}
		return respuesta;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Modulo> getById(@PathVariable("id")int id){
		Modulo modulo=mS.getById(id);
		ResponseEntity<Modulo> respuesta=null;
		if (modulo!=null) {
			respuesta=new ResponseEntity<Modulo>(modulo,HttpStatus.OK);
		}else {
			respuesta=new ResponseEntity<Modulo>(HttpStatus.CONFLICT);
		}
		
		return respuesta;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> create(Modulo modulo){
		
		Modulo m=mS.create(modulo);
		ResponseEntity<Void>respuesta=null;
		if (m.getCodModulo()>-1) {
			respuesta=new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			respuesta=new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return respuesta;
		
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void>delete(@PathVariable("id")int id){
		ResponseEntity<Void>respuesta=null;
		if (mS.getById(id)!=null) {
			mS.delete(id);
			respuesta=new ResponseEntity<Void>(HttpStatus.OK);
		}else{
			respuesta=new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		
		return respuesta;
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Modulo> update(@PathVariable("id") int id, Modulo modulo){
		ResponseEntity<Modulo> respuesta=null;
		if (mS.getById(id)!=null) {
			mS.update(modulo);
			respuesta=new ResponseEntity<Modulo>(modulo,HttpStatus.OK);
		}else {
			respuesta=new ResponseEntity<Modulo>(HttpStatus.CONFLICT);
		}
		
		
		return respuesta;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
