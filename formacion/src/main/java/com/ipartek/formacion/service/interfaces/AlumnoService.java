package com.ipartek.formacion.service.interfaces;
import com.ipartek.formacion.dao.persistence.Alumno;


import java.util.List;

public interface AlumnoService {

	public List<Alumno> getAll();
	public Alumno getById(int id);
	public Alumno update(Alumno a);
	public void delete(int id);
	public Alumno create(Alumno a);
	
}
