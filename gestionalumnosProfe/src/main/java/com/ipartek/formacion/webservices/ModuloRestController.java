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
@RequestMapping(value = "/restful/modulos")
public class ModuloRestController {

	@Autowired
	ModuloService mService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Modulo>> getAll() {
		List<Modulo> modulos = mService.getAll();
		ResponseEntity<List<Modulo>> respuesta = null;
		if (modulos.isEmpty()) {
			respuesta = new ResponseEntity<List<Modulo>>(HttpStatus.NO_CONTENT);
		} else {
			respuesta = new ResponseEntity<List<Modulo>>(modulos, HttpStatus.OK);
		}
		return respuesta;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Modulo> getById(@PathVariable("id") int id) {
		Modulo modulo = mService.getById(id);
		ResponseEntity<Modulo> respuesta = null;
		if (modulo.equals(null)) {
			respuesta = new ResponseEntity<Modulo>(HttpStatus.NOT_FOUND);
		} else {
			respuesta = new ResponseEntity<Modulo>(modulo, HttpStatus.OK);
		}
		return respuesta;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Modulo modulo) {
		ResponseEntity<Void> respuesta = null;
		Modulo al = mService.create(modulo);
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
		if (mService.getById(id) != null) {
			mService.delete(id);
			respuesta = new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			respuesta = new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

		}

		return respuesta;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<Modulo> update(@PathVariable("id") int id,
			@RequestBody Modulo modulo) {
		ResponseEntity<Modulo> respuesta = null;
		if (mService.getById(id) != null|| modulo.getCodigo()>0) {
			modulo.setCodigo(id);
			mService.update(modulo);
			respuesta = new ResponseEntity<Modulo>(modulo, HttpStatus.OK);
		} else {
			respuesta = new ResponseEntity<Modulo>(HttpStatus.NOT_FOUND);
		}

		return respuesta;
	}
}
