package com.ipartek.formacion.webservices;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.dao.persistence.Alumno;
import com.ipartek.formacion.service.interfaces.AlumnoService;

@RestController
// @Controller + @ResponseBody
@RequestMapping(value = "/restful/alumnos")
public class AlumnosRestController {
	@Autowired
	AlumnoService alse;

	Logger log = LoggerFactory.getLogger(AlumnosRestController.class);

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Alumno>> getAll() {
		List<Alumno> alumnos = alse.getAll();
		ResponseEntity<List<Alumno>> respuesta = null;
		if (alumnos.isEmpty()) {
			respuesta = new ResponseEntity<List<Alumno>>(HttpStatus.NO_CONTENT);
		} else {
			respuesta = new ResponseEntity<List<Alumno>>(alumnos, HttpStatus.OK);
		}
		log.trace("getAll Ejecutado");
		return respuesta;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Alumno> getById(@PathVariable("id") int id) {
		Alumno alumno = alse.getById(id);
		ResponseEntity<Alumno> respuesta = null;
		if (alumno.equals(null)) {
			respuesta = new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
		} else {
			respuesta = new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
		}
		log.trace("getById Ejecutado");
		return respuesta;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(Alumno alumno) {
		ResponseEntity<Void> respuesta = null;
		Alumno al = alse.create(alumno);
		if (al.getCodigo() < 0) {
			respuesta = new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {
			respuesta = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		log.trace("create Ejecutado");
		return respuesta;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		ResponseEntity<Void> respuesta = null;
		if (alse.getById(id) == null) {
			respuesta = new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			respuesta = new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		log.trace("delete Ejecutado");
		return respuesta;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Alumno> update(@PathVariable("id") int id,
			Alumno alumno) {
		ResponseEntity<Alumno> respuesta = null;
		if (alse.getById(id) != null) {
			alumno.setCodigo(id);
			alse.update(alumno);
			respuesta = new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
		} else {
			respuesta = new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
		}
		log.trace("update Ejecutado");
		return respuesta;

	}

}