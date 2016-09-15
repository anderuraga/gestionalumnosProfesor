package com.ipartek.formacion.webservices;

import java.net.URI;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.ipartek.formacion.dao.persistencia.Alumno;

public class AlumnoRestClient {
	public static final String REST_ALUMNO_SERVICE_URI = "http://localhost:8080/gestionalumnos/restful/";
	public static final String REST_SERVICE_URI = "http://localhost:8080/gestionalumnos/restful/alumno";

	
	public static void getAll(){
		RestTemplate restTemplate = new RestTemplate();
		
		List<LinkedHashMap<String, Object>> alumnosMap;
		
		alumnosMap = restTemplate.getForObject(REST_ALUMNO_SERVICE_URI + "alumnos/", List.class);
		
		if(alumnosMap != null){
			for(LinkedHashMap<String, Object> map: alumnosMap){
				Alumno alumno = new Alumno();
				alumno.setCodigo(((Integer) map.get("codAlumno")).intValue());
				alumno.setNombre((String) map.get("nombre"));
				alumno.setApellidos((String) map.get("apellidos"));
				alumno.setfNacimiento((Date) map.get("fNacimiento"));
				alumno.setDni((String) map.get("dni"));
			}
		}
	}
	
	public Alumno getById(int id){
		Alumno alumno = null;
		RestTemplate restTemplate = new RestTemplate();
		alumno = restTemplate.getForObject(REST_SERVICE_URI + "alumnos/" + id, Alumno.class);
		
		return alumno;
		
	}
	
	public void create(Alumno alumno){
		RestTemplate restTemplate = new RestTemplate();
		URI uri = restTemplate.postForLocation(REST_ALUMNO_SERVICE_URI + "alumnos/", alumno, Alumno.class);
	}
	
	public void update(Alumno alumno){
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(REST_ALUMNO_SERVICE_URI + "/" + alumno.getCodigo(), alumno);
	}
	
	public void delete(int id){
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(REST_ALUMNO_SERVICE_URI + id);
	}
	
	

}
