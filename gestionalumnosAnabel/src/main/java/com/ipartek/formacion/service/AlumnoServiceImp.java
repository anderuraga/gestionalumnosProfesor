package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.AlumnoDAOImp;
import com.ipartek.formacion.dao.persistencia.Alumno;
import com.ipartek.formacion.service.interfaces.AlumnoService;

@Service
public class AlumnoServiceImp implements AlumnoService {

  // nos hace la inyeccion de datos, por tipo de dato
  @Autowired
  private AlumnoDAOImp alumnoDAO;

  @Override
  public List<Alumno> getAll() {
    List<Alumno> alumnos = null;
    alumnos = alumnoDAO.getAll();
    System.out.println(alumnos.size());
    return alumnos;
  }

  /*
   * Inyectamos alumnoDAO en la capa service
   */
  @Override
  public void setAlumnoDAO(AlumnoDAOImp alumnoDAO) {

    this.alumnoDAO = alumnoDAO;

  }

  @Override
  public void delete(int id) {

    this.alumnoDAO.delete(id);
  }

  @Override
  public Alumno getById(int id) {

    return this.alumnoDAO.getById(id);
  }

  @Override
  public Alumno update(Alumno alumno) {

    return this.alumnoDAO.update(alumno);
  }

  @Override
  public Alumno create(Alumno alumno) {
    // TODO Auto-generated method stub
    return null;
  }

}
