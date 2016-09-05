package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistence.Alumno;

/**
 * 
 * javadoc interfaz de alumnoDAO
 * 
 * 
 * @author Curso
 *
 */
public interface AlumnoDAO extends DAOSetter {

	public List<Alumno> getAll();

	public Alumno create(Alumno alumno);

	public Alumno getByID(int id);

	public Alumno update(Alumno alumno);

	public void delete(int id);

}
