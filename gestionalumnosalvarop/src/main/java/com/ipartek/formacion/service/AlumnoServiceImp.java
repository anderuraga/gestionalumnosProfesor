package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.AlumnoDAOImp;
import com.ipartek.formacion.dao.persistencia.Alumno;
import com.ipartek.formacion.service.interfaces.AlumnoService;

@Service
public class AlumnoServiceImp implements AlumnoService {

@Autowired
AlumnoDAOImp alumnoDAO;
	
	@Override
	public List<Alumno> getAll() {
		List<Alumno>alumnos=null;
		alumnos=alumnoDAO.getAll();
		return alumnos;
		
	}

	@Override
	public void setAlumnoDAO(AlumnoDAOImp alumDAO) {
		this.alumnoDAO=alumDAO;
		
	}

}
