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

import com.ipartek.formacion.dao.persistencia.Alumno;
import com.ipartek.formacion.service.interfaces.AlumnoService;

@RestController//suma de @Controller y @ResponseBody
@RequestMapping(value="/restful/alumnos")
public class AlumnosRestController {
	@Autowired
	AlumnoService as;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Alumno>> getAll(){//encapsula encabezados http y los datos qe queramos
		List<Alumno>alumnos=as.getAll();
		ResponseEntity<List<Alumno>>respuesta=null;
		if(alumnos.isEmpty()){//si no hay datos en la bbdd,si la lista esta vacía
			respuesta=new ResponseEntity<List<Alumno>>(HttpStatus.NO_CONTENT);
		}else{
			respuesta=new ResponseEntity<List<Alumno>>(alumnos,HttpStatus.OK);
		}
		return respuesta;
	}
	@RequestMapping(value="/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Alumno>getById(@PathVariable("id")int id){
		Alumno alumno=as.getById(id);
		ResponseEntity<Alumno>respuesta=null;
		if(alumno==null){
			respuesta=new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
		}else{
			respuesta=new ResponseEntity<Alumno>(alumno,HttpStatus.OK);
		}
		return new ResponseEntity<Alumno>(new Alumno(), HttpStatus.OK);
		
	}
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> create(Alumno alumno){
		Alumno alum=as.create(alumno);
		ResponseEntity<Void> respuesta=null;
		if(alum.getCodigo()>-1){
			respuesta=new ResponseEntity<Void>(HttpStatus.CREATED);
		}else{
			respuesta=new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
			return respuesta;
			
	}
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") int id){
		ResponseEntity<Void> respuesta=null;
		if(as.getById(id)==null){
			as.delete(id);
			respuesta=new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else{
			respuesta=new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
			return null;
	}		
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Alumno> update(@PathVariable("id")int id,@RequestBody Alumno alumno){//@RequestBody quitado
		ResponseEntity<Alumno> respuesta=null;
		Alumno alum=as.getById(id);
		if(as.getById(id)!=null){//comprobar si existe el id
			as.update(alumno);
			respuesta=new ResponseEntity<Alumno>(alumno,HttpStatus.NOT_FOUND);
		}else{
			respuesta=new ResponseEntity<Alumno>(alumno,HttpStatus.OK);
		}
			return null;
	
	}
}
