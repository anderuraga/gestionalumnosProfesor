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

import com.ipartek.formacion.dao.persistence.Alumno;
import com.ipartek.formacion.service.interfaces.AlumnoService;

@RestController
@RequestMapping(value = "/restful/alumnos")
public class AlumnosRestController {

	@Autowired
	AlumnoService aService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Alumno>> getAll() {
		List<Alumno> alumnos = aService.getAll();
		ResponseEntity<List<Alumno>> respuesta = null;
		if (alumnos.isEmpty()) {
			respuesta = new ResponseEntity<List<Alumno>>(HttpStatus.NO_CONTENT);
		} else {
			respuesta = new ResponseEntity<List<Alumno>>(alumnos, HttpStatus.OK);
		}
		return respuesta;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Alumno> getById(@PathVariable("id") int id) {
		Alumno alumno = aService.getById(id);
		ResponseEntity<Alumno> respuesta = null;
		if (alumno.equals(null)) {
			respuesta = new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
		} else {
			respuesta = new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
		}
		return respuesta;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Alumno alumno) {
		ResponseEntity<Void> respuesta = null;
		Alumno al = aService.create(alumno);
		if (al.getCodigo() < 0) {
			respuesta = new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {
			respuesta = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return respuesta;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		ResponseEntity<Void> respuesta = null;
		if (aService.getById(id) != null) {
			aService.delete(id);
			respuesta = new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			respuesta = new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

		}

		return respuesta;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<Alumno> update(@PathVariable("id") int id,
			@RequestBody Alumno alumno) {
		ResponseEntity<Alumno> respuesta = null;
		if (aService.getById(id) != null || alumno.getCodigo()>0) {
			alumno.setCodigo(id);
			aService.update(alumno);
			respuesta = new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
		} else {
			respuesta = new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
		}

		return respuesta;
	}
}
