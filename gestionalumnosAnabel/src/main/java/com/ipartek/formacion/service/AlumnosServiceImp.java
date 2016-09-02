package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.AlumnoDAOImp;
import com.ipartek.formacion.dao.persistencia.Alumno;
import com.ipartek.formacion.service.interfaces.AlumnosService;

@Service
public class AlumnosServiceImp implements AlumnosService {

  // nos hace la inyeccion de datos, por tipo de dato
  @Autowired
  private AlumnoDAOImp alumnoDAO;

  @Override
  public List<Alumno> getAll() {
    // TODO Auto-generated method stub
    return null;
  }

}
