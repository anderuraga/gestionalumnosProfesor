package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.dao.AlumnoDAOImp;
import com.ipartek.formacion.dao.persistencia.Alumno;

public interface AlumnoService {
	public List<Alumno> getAll();
	public void setAlumDAO(AlumnoDAOImp alumDAO);
	public Alumno getById(int id);
	public Alumno update(Alumno alumno);
	public void delete(int id);
	public Alumno create(Alumno alumno);
}
