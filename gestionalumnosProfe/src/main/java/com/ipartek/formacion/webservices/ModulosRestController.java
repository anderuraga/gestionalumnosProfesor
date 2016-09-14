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
import com.ipartek.formacion.service.interfaces.ModuloService;


@RestController
@RequestMapping(value="/restful/modulos")
public class ModulosRestController {
	@Autowired
	ModuloService mService=null;
	@RequestMapping(method=RequestMethod.GET)
	private ResponseEntity<List<Modulo>> getAll() {
		List<Modulo> modulos = mService.getAll();
		
		ResponseEntity<List <Modulo>> respuesta =null;
		if (modulos.isEmpty()) {
			respuesta = new ResponseEntity<List<Modulo>>(HttpStatus.NO_CONTENT);
		}else{
			respuesta = new ResponseEntity<List<Modulo>>(modulos,HttpStatus.OK);
		}
		return respuesta;
	}
	@RequestMapping(value="/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Modulo> getById(@PathVariable("id") int id){
		Modulo Modulo=mService.getById(id);
		ResponseEntity<Modulo> respuesta=null;
		if(Modulo ==null){
			respuesta =new ResponseEntity<Modulo>(HttpStatus.NOT_FOUND);
		}else{
			respuesta=new ResponseEntity<Modulo>(Modulo,HttpStatus.OK);
		}
		return respuesta;
	}
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> create(Modulo Modulo){
		Modulo alum = mService.create(Modulo);
		ResponseEntity<Void> respuesta=null;
		if(alum.getCodigo()>-1){
			respuesta = new ResponseEntity<Void>(HttpStatus.OK);
		}
		return respuesta;
		
	}
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") int id){
		ResponseEntity<Void> respuesta=null;
		if(mService.getById(id)!=null){
			mService.delete(id);
			respuesta=new ResponseEntity<Void>(HttpStatus.OK);
		}else{
			respuesta=new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return respuesta;
	}
	@RequestMapping(method=RequestMethod.PUT)
		public ResponseEntity<Modulo>update(@PathVariable("id") int id,@RequestBody Modulo Modulo){
		ResponseEntity<Modulo> respuesta=null;
		if(mService.getById(id)!=null){
			mService.update(Modulo);
			respuesta=new ResponseEntity<Modulo>(Modulo,HttpStatus.OK);
		}else{
			respuesta=new ResponseEntity<Modulo>(HttpStatus.NOT_FOUND);
		}
			return respuesta;
		}
}
