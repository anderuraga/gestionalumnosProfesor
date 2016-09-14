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

import com.ipartek.formacion.dao.persistence.Curso;
import com.ipartek.formacion.service.interfaces.CursoService;
import com.ipartek.formacion.service.interfaces.CursoService;
@RestController
@RequestMapping(value="/restful/cursos")
public class CursosRestController {

	
		@Autowired
		CursoService cService=null;
		@RequestMapping(method=RequestMethod.GET)
		private ResponseEntity<List<Curso>> getAll() {
			List<Curso> cursos = cService.getAll();
			
			ResponseEntity<List <Curso>> respuesta =null;
			if (cursos.isEmpty()) {
				respuesta = new ResponseEntity<List<Curso>>(HttpStatus.NO_CONTENT);
			}else{
				respuesta = new ResponseEntity<List<Curso>>(cursos,HttpStatus.OK);
			}
			return respuesta;
		}
		@RequestMapping(value="/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Curso> getById(@PathVariable("id") int id){
			Curso curso=cService.getById(id);
			ResponseEntity<Curso> respuesta=null;
			if(curso ==null){
				respuesta =new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
			}else{
				respuesta=new ResponseEntity<Curso>(curso,HttpStatus.OK);
			}
			return respuesta;
		}
		@RequestMapping(method=RequestMethod.POST)
		public ResponseEntity<Void> create(Curso Curso){
			Curso alum = cService.create(Curso);
			ResponseEntity<Void> respuesta=null;
			if(alum.getCodigo()>-1){
				respuesta = new ResponseEntity<Void>(HttpStatus.OK);
			}
			return respuesta;
			
		}
		@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
		public ResponseEntity<Void> delete(@PathVariable("id") int id){
			ResponseEntity<Void> respuesta=null;
			if(cService.getById(id)!=null){
				cService.delete(id);
				respuesta=new ResponseEntity<Void>(HttpStatus.OK);
			}else{
				respuesta=new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			return respuesta;
		}
		@RequestMapping(method=RequestMethod.PUT)
			public ResponseEntity<Curso>update(@PathVariable("id") int id,@RequestBody Curso curso){
			ResponseEntity<Curso> respuesta=null;
			if(cService.getById(id)!=null){
				cService.update(curso);
				respuesta=new ResponseEntity<Curso>(curso,HttpStatus.OK);
			}else{
				respuesta=new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
			}
				return respuesta;
			}
}
