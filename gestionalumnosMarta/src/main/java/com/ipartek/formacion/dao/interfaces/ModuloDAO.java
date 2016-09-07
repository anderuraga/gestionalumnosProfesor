package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistencia.Alumno;
import com.ipartek.formacion.dao.persistencia.Modulo;

public interface ModuloDAO extends DAOSetter{
	
	public List<Modulo> getAll();
	
	public Modulo getById(int id);
	
	public void delete(int id);
	
	public Modulo create (Modulo modulo);
	
	public Modulo update(Modulo modulo);

}
