package com.ipartek.formacion.webservices;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.ipartek.formacion.dao.persistencia.Curso;

public class CursoRestClient {
	public static final String REST_CURSO_SERVICE_URI="http://localhost:8080/formacion/restful/";
	
	public static void getAll(){
		RestTemplate restTemplate=new RestTemplate();
		List<LinkedHashMap<String, Object>>cursosMap;
		cursosMap=restTemplate.getForObject(REST_CURSO_SERVICE_URI+"cursos/", List.class);
		if(cursosMap!=null){
			for(LinkedHashMap<String, Object> map: cursosMap){
				Curso curso=new Curso();
				curso.setCodigo(((Integer) map.get("codigo")).intValue());
				curso.setNombre((String) map.get("nombre"));
			}
		}
	}
	
	public Curso getById(int id){
		Curso curso=null;
		RestTemplate restTemplate=new RestTemplate();
		curso=restTemplate.getForObject(REST_CURSO_SERVICE_URI+"cursos/"+id, Curso.class);
		return curso;
	}
	
	public void create(Curso curso){
		RestTemplate restTemplate=new RestTemplate();
		URI uri=restTemplate.postForLocation(REST_CURSO_SERVICE_URI+"cursos/", curso, Curso.class);
		
	}
	
	public void update(Curso curso){
		RestTemplate restTemplate=new RestTemplate();
		restTemplate.put(REST_CURSO_SERVICE_URI+"cursos/"+curso.getCodigo(), curso);
	}
	
	public void delete(int id){
		RestTemplate restTemplate=new RestTemplate();
		restTemplate.delete(REST_CURSO_SERVICE_URI+"cursos/"+id);
	}
}
