package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.AlumnoDAOImp;
import com.ipartek.formacion.dao.persistence.Alumno;
/**
 * 
 * @author Curso
 *
 */
public interface AlumnoService {

	public List<Alumno> getAll();
	
	public Alumno getById(int id);
	
	public Alumno update(Alumno alumno);
	
	public void delete(int id);
	
	public Alumno create(Alumno alumno);
	
	public void setAlumDAO(AlumnoDAOImp alumDAO);
}
