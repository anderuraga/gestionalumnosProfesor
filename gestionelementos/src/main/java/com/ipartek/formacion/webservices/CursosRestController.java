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

@RestController
@RequestMapping(value = "/restfull/cursos")
public class CursosRestController {
	@Autowired
	CursoService cuse;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Curso>> getAll() {
		
		List<Curso> cursos = cuse.getAll();
		ResponseEntity<List<Curso>> respuesta = null;
		
		
		if (cursos.isEmpty()) {
			respuesta = new ResponseEntity<List<Curso>>(HttpStatus.NO_CONTENT);
		} else {
			respuesta = new ResponseEntity<List<Curso>>(cursos, HttpStatus.OK);
		}
		return respuesta;
		
	}



	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Curso> getById(@PathVariable("id") int id) {
		Curso Curso = cuse.getById(id);
		ResponseEntity<Curso> respuesta = null;
		if (Curso == null) {
			respuesta = new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
		} else {
			respuesta = new ResponseEntity<Curso>(Curso, HttpStatus.OK);
		}
		return respuesta;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(Curso Curso) {
		Curso alum = cuse.create(Curso);
		ResponseEntity<Void> respuesta = null;
		if (alum.getCodigo() > -1) {
			respuesta = new ResponseEntity<Void>(HttpStatus.CREATED);
		} else {
			respuesta = new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return respuesta;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		ResponseEntity<Void> respuesta = null;
		if (cuse.getById(id) == null) {
			respuesta = new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			respuesta = new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return respuesta;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Curso> update(@PathVariable("id") int id,
			@RequestBody Curso Curso) {
		ResponseEntity<Curso> respuesta = null;
		if (cuse.getById(id) != null) {
			Curso.setCodigo(id);
			cuse.update(Curso);
			respuesta = new ResponseEntity<Curso>(Curso, HttpStatus.OK);
		} else {
			respuesta = new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
		}

		return respuesta;

	}

}