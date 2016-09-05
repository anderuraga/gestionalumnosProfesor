package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.AlumnoDAOImp;
import com.ipartek.formacion.dao.persistencia.Alumno;

/**
 * 
 * @author Curso
 *
 */
public interface AlumnoService {
	
	public List<Alumno> getAll();
	
	public Alumno create(Alumno alumno);
	
	public Alumno getById(int id);
	
	public Alumno update(Alumno alumno);
	
	public void delete(int id);
	
	public void setAlumDAO(AlumnoDAOImp alumDAO);

}
