package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.AlumnoDAOImp;
import com.ipartek.formacion.dao.interfaces.AlumnoDAO;
import com.ipartek.formacion.dao.persistence.Alumno;
import com.ipartek.formacion.service.interfaces.AlumnoService;

@Service
public class AlumnoServiceImp implements AlumnoService {
	
	@Autowired
	AlumnoDAO alumDAO;

	@Override
	public List<Alumno> getAll() {
		List<Alumno> alumnos = null;
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
		Alumno alum = alumDAO.update(alumno);
		return alum;
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
