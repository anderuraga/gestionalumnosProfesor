package com.ipartek.formacion.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.AlumnoDAOImp;
import com.ipartek.formacion.dao.persistencia.Alumno;
import com.ipartek.formacion.service.interfaces.AlumnoService;

/**
 * 
 * @author Curso
 * 
 * 
 *
 */

@Service
public class AlumnoServiceImp implements AlumnoService{

	@Autowired 
	AlumnoDAOImp alumDAO;
	
	
	@Override
	public List<Alumno> getAll() {

		List<Alumno> alumnos = alumDAO.getAll();

		return alumnos;
	}


	@Override
	public void setAlumDAO(AlumnoDAOImp alumDAO) {
		this.alumDAO = alumDAO;
				
	}

	
}
