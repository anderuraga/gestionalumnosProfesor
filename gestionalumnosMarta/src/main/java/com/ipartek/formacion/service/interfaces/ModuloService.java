package com.ipartek.formacion.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.AlumnoDAOImp;
import com.ipartek.formacion.dao.ModuloDAOImp;
import com.ipartek.formacion.dao.persistencia.Modulo;

@Service
public interface ModuloService {
	
public List<Modulo> getAll();
	
	public Modulo getById(int id);
	
	public void delete(int id);
	
	public Modulo create (Modulo modulo);
	
	public Modulo update (Modulo modulo);
	
	public void setModDAO(ModuloDAOImp modDAO);

}
