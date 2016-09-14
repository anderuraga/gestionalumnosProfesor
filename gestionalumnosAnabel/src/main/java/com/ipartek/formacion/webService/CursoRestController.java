package com.ipartek.formacion.webService;

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

import com.ipartek.formacion.dao.persistencia.Curso;
import com.ipartek.formacion.service.interfaces.CursoService;

@RestController
@RequestMapping("/restful/cursos")
public class CursoRestController {

	@Autowired
	private CursoService cursoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Curso>> getAll(){
		
		List<Curso> cursos = this.cursoService.getAll();
		ResponseEntity<List<Curso>> respuesta = null;
		
		if(cursos.isEmpty()){
			respuesta = new ResponseEntity<List<Curso>>(HttpStatus.NOT_FOUND);
		}else{
			respuesta = new ResponseEntity<List<Curso>>(cursos, HttpStatus.OK);
		}
		return respuesta;
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Curso> getById(@PathVariable("id")int id){
		
		ResponseEntity<Curso> respuesta = null;
		Curso curso = this.cursoService.getById(id);
		
		if(curso.getCodigo() < 0){
			respuesta = new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
		}else{
			respuesta = new ResponseEntity<Curso>(curso, HttpStatus.OK);
		}
		return respuesta;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id")int id){
		
		ResponseEntity<Void> respuesta = null;
		if(this.cursoService.getById(id) != null){
			this.cursoService.delete(id);
			respuesta = new ResponseEntity<Void>(HttpStatus.OK);
		}else{
			respuesta = new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return respuesta;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(Curso curso){
		
		ResponseEntity<Void> respuesta = null;
		this.cursoService.create(curso);
		respuesta = new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		return respuesta;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable("id") int id, Curso curso){
		
		ResponseEntity<Void> respuesta = null;
		if(curso.getCodigo() > 0){
			this.cursoService.update(curso);
			respuesta = new ResponseEntity<Void>(HttpStatus.OK);
		}else{
			respuesta = new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return respuesta;
	}
}
