package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.AlumnoDAOImp;
import com.ipartek.formacion.dao.persistence.Alumno;

/**
 * @author Erasmo
 */
public interface AlumnoService {
	public List<Alumno> getAll();

	public Alumno getById(int id);

	public Alumno create(Alumno Alumno);

	public Alumno update(Alumno alumno);

	public void delete(int id);

	void setAlumnoDAO(AlumnoDAOImp alumDAO);

}
