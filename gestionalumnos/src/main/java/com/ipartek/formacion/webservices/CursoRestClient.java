package com.ipartek.formacion.webservices;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.ipartek.formacion.dao.persistence.Curso;

public class CursoRestClient {

	public static final String REST_SERVICE_URI="http://localhost:8080/gestionalumnos/restful/";
	//no ponemos al final de la URI alumnos para poder usar la constante en todos los clientes
	
	public static void getAll(){
		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Object>>cursosMap;
		
		cursosMap = restTemplate.getForObject(REST_SERVICE_URI+"cursos/", List.class);
		
		if(cursosMap!=null){
			for(LinkedHashMap<String, Object> map: cursosMap){
				Curso curso = new Curso();
				//alumno.setCodigo((Integer) map.get("codigo")); why not?
				curso.setCodigo(((Integer) map.get("codigo")).intValue());
				curso.setNombre((String) map.get("nombre"));
				//asi con todos
			}
		}
	}
	
	public Curso getById(int id){
		Curso curso = new Curso();
		
		RestTemplate restTemplate = new RestTemplate();
		curso = restTemplate.getForObject(REST_SERVICE_URI+"cursos/"+id, Curso.class);
		
		return curso;
	}
	
	public void create (Curso curso){
		
		RestTemplate restTemplate = new RestTemplate();
		URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"cursos", curso, Curso.class);
		
	}
	
	public void update(Curso curso){
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(REST_SERVICE_URI+"cursos"+curso.getCodigo(), curso);
	}
	
	public void delete(int id){
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(REST_SERVICE_URI+"cursos"+id, Curso.class);
	}
}
