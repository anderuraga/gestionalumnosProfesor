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

import com.ipartek.formacion.dao.persistence.Candidato;
import com.ipartek.formacion.service.interfaces.CandidatoService;

@RestController
@RequestMapping(value = "/restfull/candidatos")
public class CandidatosRestController {
	@Autowired
	CandidatoService cdse;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Candidato>> getAll() {
		
		List<Candidato> candidatos = cdse.getAll();
		ResponseEntity<List<Candidato>> respuesta = null;
		
		
		if (candidatos.isEmpty()) {
			respuesta = new ResponseEntity<List<Candidato>>(HttpStatus.NO_CONTENT);
		} else {
			respuesta = new ResponseEntity<List<Candidato>>(candidatos, HttpStatus.OK);
		}
		return respuesta;
		
	}



	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Candidato> getById(@PathVariable("id") int id) {
		Candidato Candidato = cdse.getById(id);
		ResponseEntity<Candidato> respuesta = null;
		if (Candidato == null) {
			respuesta = new ResponseEntity<Candidato>(HttpStatus.NOT_FOUND);
		} else {
			respuesta = new ResponseEntity<Candidato>(Candidato, HttpStatus.OK);
		}
		return respuesta;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(Candidato Candidato) {
		Candidato alum = cdse.create(Candidato);
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
		if (cdse.getById(id) == null) {
			respuesta = new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			respuesta = new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return respuesta;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Candidato> update(@PathVariable("id") int id,
			@RequestBody Candidato Candidato) {
		ResponseEntity<Candidato> respuesta = null;
		if (cdse.getById(id) != null) {
			Candidato.setCodigo(id);
			cdse.update(Candidato);
			respuesta = new ResponseEntity<Candidato>(Candidato, HttpStatus.OK);
		} else {
			respuesta = new ResponseEntity<Candidato>(HttpStatus.NOT_FOUND);
		}

		return respuesta;

	}

}