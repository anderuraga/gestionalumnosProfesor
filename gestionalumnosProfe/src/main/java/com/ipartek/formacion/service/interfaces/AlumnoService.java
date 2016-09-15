package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.AlumnoDAOImp;
import com.ipartek.formacion.dao.persistence.Alumno;

/**
 * 
 * @author Imanol
 *
 */
public interface AlumnoService {
  /**
   * 
   * @return <code>List<Alumno></code>
   */
  public List<Alumno> getAll();

  public Alumno getById(int id);

  public Alumno create(Alumno alumno);

  public Alumno update(Alumno alumno);

  public void delete(int id);

  public void setAlumDAO(AlumnoDAOImp alumDAO);
}
