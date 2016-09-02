package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.AlumnoDAOImp;
import com.ipartek.formacion.dao.persistence.Alumno;
import com.ipartek.formacion.service.interfaces.AlumnoService;

@Service

public class AlumnoServiceImp implements AlumnoService {

	@Autowired
	AlumnoDAOImp alumDAO;

	@Override
	public List<Alumno> getAll() {
		List<Alumno> alumnos = null;
		alumnos = alumDAO.getAll();
		if (alumnos == null) {
			System.out.println("Alumno en service nulo");
		}
		return alumnos;
		// return alumDAO.getAll();
	}

	@Override
	public void setAlumDAO(AlumnoDAOImp alumDAO) {
		this.alumDAO = alumDAO;

	}

}
