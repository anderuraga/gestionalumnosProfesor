package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistencia.Alumno;

public interface AlumnoDAO extends DAOSetter {

  public Alumno create(Alumno alumno);

  public void delete(int id);

  public Alumno update(Alumno alumno);

  public Alumno getById(int id);

  public List<Alumno> getAll();
}
