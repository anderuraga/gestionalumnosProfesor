package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.AlumnoDAOImp;
import com.ipartek.formacion.dao.persistence.Alumno;

/**
 * 
 * javadoc de las narices
 * 
 * @author Curso
 *
 */
public interface AlumnoService {
	public List<Alumno> getAll();

	public void setAlumDAO(AlumnoDAOImp alumDAO);
}
