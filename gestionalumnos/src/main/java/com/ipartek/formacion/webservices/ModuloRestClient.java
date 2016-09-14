package com.ipartek.formacion.webservices;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.ipartek.formacion.dao.persistence.Modulo;

public class ModuloRestClient {

	public static final String REST_SERVICE_URI="http://localhost:8080/gestionalumnos/restful/";
	//no ponemos al final de la URI alumnos para poder usar la constante en todos los clientes
	
	public static void getAll(){
		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Object>>modulosMap;
		
		modulosMap = restTemplate.getForObject(REST_SERVICE_URI+"modulos/", List.class);
		
		if(modulosMap!=null){
			for(LinkedHashMap<String, Object> map: modulosMap){
				Modulo modulo = new Modulo();
				//alumno.setCodigo((Integer) map.get("codigo")); why not?
				modulo.setCodigo(((Integer) map.get("codigo")).intValue());
				modulo.setNombre((String) map.get("nombre"));
				//asi con todos
			}
		}
	}
	
	public Modulo getById(int id){
		Modulo modulo = new Modulo();
		
		RestTemplate restTemplate = new RestTemplate();
		modulo = restTemplate.getForObject(REST_SERVICE_URI+"modulos/"+id, Modulo.class);
		
		return modulo;
	}
	
	public void create (Modulo modulo){
		
		RestTemplate restTemplate = new RestTemplate();
		URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"alumnos", modulo, Modulo.class);
		
	}
	
	public void update(Modulo modulo){
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(REST_SERVICE_URI+"alumnos"+modulo.getCodigo(), modulo);
	}
	
	public void delete(int id){
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(REST_SERVICE_URI+"alumnos"+id, Modulo.class);
	}
}
