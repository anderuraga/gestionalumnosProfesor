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
	/**
	 * 
	 * @return
	 */
	public List<Alumno> getAll();
	
	public void setAlumDAO(AlumnoDAOImp alumDAO);
	
	public Alumno getById(int id);
	
	public Alumno update(Alumno alumno);
	
	public void delete(int id);
}
