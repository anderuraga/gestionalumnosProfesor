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

import com.ipartek.formacion.dao.persistencia.Curso;
import com.ipartek.formacion.service.CursoService;

@RestController
@RequestMapping(value="/restful/cursos")
public class CursosRestController {
	@Autowired
	CursoService cs;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Curso>> getAll(){
		List<Curso>cursos=cs.getAll();
		System.out.println(cursos.get(1).getNombre());
		ResponseEntity<List<Curso>> respuesta=null;
		if(cursos.isEmpty()){
			respuesta=new ResponseEntity<List<Curso>>(HttpStatus.NO_CONTENT);
		}else{
			respuesta=new ResponseEntity<List<Curso>>(cursos,HttpStatus.OK);
		}
		
		return respuesta;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Curso> getById(@PathVariable("id")int id){
		Curso curso=cs.getById(id);
		ResponseEntity<Curso> respuesta=null;
		
		if(curso==null){
			respuesta=new ResponseEntity<Curso>(HttpStatus.NO_CONTENT);
		}else{
			respuesta=new ResponseEntity<Curso>(HttpStatus.OK);
		}
		
		return respuesta;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> create(Curso curso){
		Curso cur=cs.create(curso);
		ResponseEntity<Void> respuesta=null;
		if(cur.getCodigo()>-1){
			respuesta=new ResponseEntity<Void>(HttpStatus.CREATED);
		}else{
			respuesta=new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		return respuesta;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") int id){
		ResponseEntity<Void> respuesta=null;
		if(cs.getById(id)==null){
			respuesta=new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else{
			respuesta=new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
		return respuesta;
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable("id") int id, Curso curso){
		ResponseEntity<Void> respuesta=null;
		if(cs.getById(id)!=null){
			curso.setCodigo(id);
			cs.update(curso);
			respuesta=new ResponseEntity<Void>(HttpStatus.OK);
		}else{
			respuesta=new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		return respuesta;
	}
}