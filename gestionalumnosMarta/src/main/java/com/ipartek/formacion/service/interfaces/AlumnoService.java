package com.ipartek.formacion.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.AlumnoDAOImp;
import com.ipartek.formacion.dao.persistencia.Alumno;
/**
 * 
 * 
 * @author Curso
 *
 */

@Service
public interface AlumnoService {

	public List<Alumno> getAll();
	
	public Alumno getById(int id);
	
	public Alumno update(Alumno alumno);
	
	public void delete(int id);
	
	public Alumno create(Alumno alumno);
	
	public void setAlumDAO(AlumnoDAOImp alumDAO);
	
}
