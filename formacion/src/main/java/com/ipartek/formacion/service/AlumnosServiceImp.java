package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.AlumnoDAOImp;
import com.ipartek.formacion.dao.persistence.Alumno;
import com.ipartek.formacion.service.interfaces.AlumnoService;

@Service
public class AlumnosServiceImp implements AlumnoService{
	
	@Autowired
	AlumnoDAOImp aDAO;
	
	public void setADAO(AlumnoDAOImp aDAO) {
		this.aDAO = aDAO;
	}

	public List<Alumno>getAll(){
		List<Alumno>alumnos=null;
		alumnos=aDAO.getAll();
		
		return alumnos;
		}

	

	@Override
	public Alumno getById(int id) {
		Alumno a=aDAO.getById(id);
		
		return a;
	}

	@Override
	public Alumno update(Alumno a) {
		Alumno alumno=aDAO.update(a);
		return alumno;
	}

	@Override
	public void delete(int id) {
		aDAO.delete(id);
		
	}

	public Alumno create(Alumno a) {
		Alumno alumno=aDAO.create(a);
		return alumno;
		
	}
	
	
	
}
