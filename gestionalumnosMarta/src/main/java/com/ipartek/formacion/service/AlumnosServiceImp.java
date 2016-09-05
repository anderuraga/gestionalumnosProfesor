package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.AlumnoDAOImp;
import com.ipartek.formacion.dao.interfaces.AlumnoDAO;
import com.ipartek.formacion.dao.persistencia.Alumno;
import com.ipartek.formacion.service.interfaces.AlumnoService;

@Service
public class AlumnosServiceImp implements AlumnoService{
	
	@Autowired //por tipo de dato
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
		Alumno alumno = null;
		alumno = alumDAO.getById(id);
		
		return alumno;
	}
	
	@Override
	public void delete(int id) {
		alumDAO.delete(id);
	}

	@Override
	public Alumno update(Alumno alumno) {
		
		Alumno alum = alumDAO.update(alumno);
		
		return alum;
		
		/*
		se podria hacer asi:
		return alumDAO.update(alumno);
		*/
	}

	
	@Override
	public Alumno create(Alumno alumno) {
		alumDAO.create(alumno);
		
		return alumno;
	}

	

	

}
