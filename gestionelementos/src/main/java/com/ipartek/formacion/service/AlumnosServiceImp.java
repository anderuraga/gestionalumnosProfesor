package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.AlumnoDAOImp;
import com.ipartek.formacion.dao.interfaces.AlumnoDAO;
import com.ipartek.formacion.dao.persistence.Alumno;
import com.ipartek.formacion.service.interfaces.AlumnoService;

@Service
public class AlumnosServiceImp implements AlumnoService {
  @Autowired
  private AlumnoDAO alumDAO = null;

  @Override
  public List<Alumno> getAll() {
    return alumDAO.getAll();
  }

  @Override
  public Alumno getById(int id) {
    return alumDAO.getById(id);
  }

  @Override
  public Alumno create(Alumno alumno) {
  return alumDAO.create(alumno);
  }

  @Override
  public Alumno update(Alumno alumno) {

    return alumDAO.update(alumno);
  }

  @Override
  public void delete(int id) {
    alumDAO.delete(id);

  }

  @Override
  public void setAlumnoDAO(AlumnoDAOImp alumDAO) {
    this.alumDAO = alumDAO;
  }

}
