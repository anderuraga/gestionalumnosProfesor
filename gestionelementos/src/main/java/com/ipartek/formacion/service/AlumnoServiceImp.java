package com.ipartek.formacion.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ipartek.formacion.dao.AlumnoDAOImp;
import com.ipartek.formacion.dao.interfaces.AlumnoService;
import com.ipartek.formacion.dao.persistence.Alumno;
@Service 
public class AlumnoServiceImp implements AlumnoService {
	@Autowired 
	AlumnoDAOImp alumDAO;
	
	@Override 
	public List<Alumno> getAll() {
		List<Alumno> alumnos = null;
		alumnos = alumDAO.getAll();
		return alumnos;
	}
	@Override
	public void setAlumDAO(AlumnoDAOImp alumDAO){
		this.alumDAO = alumDAO;
	}
}
