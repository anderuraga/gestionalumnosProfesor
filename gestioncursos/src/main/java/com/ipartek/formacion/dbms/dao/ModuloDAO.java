package com.ipartek.formacion.dbms.dao;

import java.util.List;

import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.pojo.Curso;
import com.ipartek.formacion.pojo.Modulo;

public interface ModuloDAO {

public Modulo create(Modulo modulo);
	
	public Modulo getById(int codigo);
	
	public void delete(int codigo);
	
	public List<Modulo> getAll();
	
	public Modulo update(Modulo modulo);

	}

