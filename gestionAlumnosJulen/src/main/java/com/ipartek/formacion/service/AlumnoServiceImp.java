package com.ipartek.formacion.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.controller.ModuloController;
import com.ipartek.formacion.dao.AlumnoDAOImp;
import com.ipartek.formacion.dao.interfaces.AlumnoDAO;
import com.ipartek.formacion.dao.persistence.Alumno;
import com.ipartek.formacion.service.interfaces.AlumnoService;
/**
 * 
 * @author Curso
 *
 */
@Service
public class AlumnoServiceImp implements AlumnoService{

	private static final Logger logger = LoggerFactory.getLogger(AlumnoServiceImp.class);

	@Autowired
	AlumnoDAO alumDAO;
	
	@Override
	public List<Alumno> getAll() {

		List<Alumno> alumnos=null;
		alumnos = alumDAO.getAll();
		
		return alumnos;
	}

	@Override
	public void setAlumDAO(AlumnoDAOImp alumDAO) {
		
		this.alumDAO = alumDAO;
	}

	@Override
	public Alumno getById(int id) {
		
		Alumno alumno = alumDAO.getById(id);
		
		return alumno;
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
	public Alumno create(Alumno alumno) {

		
		return alumDAO.create(alumno);

	}

}
