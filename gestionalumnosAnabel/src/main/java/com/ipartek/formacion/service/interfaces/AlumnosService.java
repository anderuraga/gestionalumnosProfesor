package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.AlumnoDAOImp;
import com.ipartek.formacion.dao.persistencia.Alumno;

/**
 * Interfaz que define los metodos de alumno
 * 
 * @author Curso
 *
 */
public interface AlumnosService {

  public List<Alumno> getAll();

  public void setAlumnoDAO(AlumnoDAOImp alumnoDAO);

}
