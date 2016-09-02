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

}
