package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.AlumnoDAOImp;
import com.ipartek.formacion.dao.interfaces.AlumnoDAO;
import com.ipartek.formacion.dao.persistencia.Alumno;
import com.ipartek.formacion.service.interfaces.AlumnoService;

@Service
public class AlumnoServiceImp implements AlumnoService {

	@Autowired
	AlumnoDAO alumnoDAO;
	
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

	@Override
	public Alumno getByid(int id) {
		Alumno alumno=alumnoDAO.getByid(id);
		return alumno;
	}

	@Override
	public Alumno update(Alumno alumno) {
		Alumno alum=alumnoDAO.update(alumno);
		return alum;
	}

	@Override
	public void delete(int id) {
		alumnoDAO.delete(id);
		
	}

	@Override
	public Alumno create(Alumno alumno) {
		
		return alumnoDAO.create(alumno);
	}

}
