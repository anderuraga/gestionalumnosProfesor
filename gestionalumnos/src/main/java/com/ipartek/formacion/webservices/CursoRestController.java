package com.ipartek.formacion.webservices;

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

import com.ipartek.formacion.dao.persistence.Alumno;
import com.ipartek.formacion.dao.persistence.Curso;
import com.ipartek.formacion.service.interfaces.CursoService;

@Controller
@ResponseBody
@RequestMapping(value="/restful/cursos")
public class CursoRestController {
	
	@Autowired
	CursoService cur;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Curso>> getAll(){//responseEntity encapsula el objeto lista al http
		
		List<Curso> cursos = cur.getAll();
		ResponseEntity<List<Curso>> respuesta=null;
		if(cursos.isEmpty()){
			respuesta = new ResponseEntity<List<Curso>>(HttpStatus.NOT_FOUND);
		}else{
			respuesta = new ResponseEntity<List<Curso>>(cursos,HttpStatus.OK);
		}
		
		return respuesta;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Curso> getById(@PathVariable("id") int id){
		
		Curso curso = cur.getByID(id);
		ResponseEntity<Curso> respuesta=null;
		if(curso==null){
			respuesta = new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
		}else{
			respuesta = new ResponseEntity<Curso>(curso,HttpStatus.OK);
		}
		
		return respuesta;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> create(Curso curso){
		ResponseEntity<Void> respuesta=null;
		Curso curs = cur.create(curso);
		if(curs.getCodigo()>-1){
			respuesta = new ResponseEntity<Void>(HttpStatus.CREATED);
		}else{
			respuesta = new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		return respuesta;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") int id){
		ResponseEntity<Void> respuesta=null;
		if(cur.getByID(id)!=null){
			cur.delete(id);
			respuesta = new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			respuesta = new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		return respuesta;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Curso> update(@PathVariable("id") int id, Curso curso){
		ResponseEntity<Curso> respuesta=null;
		if(cur.getByID(id)!=null){
			curso.setCodigo(id);
			cur.update(curso);
			respuesta = new ResponseEntity<Curso>(curso,HttpStatus.OK);
		} else {
			respuesta = new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
		}
		
		return respuesta;
	}
}
