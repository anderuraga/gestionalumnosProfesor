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
/**
 * 
 * @return List<Alumno>
 */
	
	//crud
	
	public List<Alumno>getAll();
	public void setAlumnoDAO(AlumnoDAOImp alumDAO);
	public Alumno getByid(int id);
	public Alumno update(Alumno alumno);
	public void delete(int id);
	public Alumno create(Alumno alumno);
	
}
