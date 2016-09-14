package com.ipartek.formacion.webService;

import java.net.URI;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.ipartek.formacion.dao.persistencia.Alumno;

public class AlumnoRestClient {

	public static final String REST_SERVICE_URI = "http://localhost:8080/formacion/restful/";
	
	public static void getAll(){
		RestTemplate restTemplate = new RestTemplate();
		
		List<LinkedHashMap<String, Object>> alumnosMaps;
		alumnosMaps =  restTemplate.getForObject(REST_SERVICE_URI+"alumnos", List.class);
		
		if(alumnosMaps != null){
			for(LinkedHashMap<String, Object> map: alumnosMaps){
				Alumno alumno = new Alumno();
				alumno.setCodigo(((Integer) map.get("codigo")).intValue());
				alumno.setNombre((String) map.get("nombre"));
				alumno.setApellidos((String) map.get("apellidos"));
				alumno.setEmail((String) map.get("email"));
				alumno.setfNacimiento((Date) map.get("fNacimiento"));
				alumno.setTelefono(((Integer) map.get("telefono")).intValue());
			}
		}
		
	}
	
	public Alumno getById(int id){
		
		Alumno alumno = null;
		RestTemplate restTemplate = new RestTemplate();
		alumno = restTemplate.getForObject(REST_SERVICE_URI+"alumno/" + id, Alumno.class);
		return alumno;
	}
	
	public void create(Alumno alumno){
		
		RestTemplate restTemplate = new RestTemplate();
		URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"alumnos", alumno, Alumno.class);
		
	}
	
	public void update(Alumno alumno){
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(REST_SERVICE_URI+"alumnos/"+alumno.getCodigo(), alumno);
	}
	
	public void delete(int id){
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(REST_SERVICE_URI+"alumnos/"+id);
	}
	
}
