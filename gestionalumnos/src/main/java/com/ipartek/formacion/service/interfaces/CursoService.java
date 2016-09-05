package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistencia.Alumno;
import com.ipartek.formacion.dao.persistencia.Curso;

public interface CursoService {
	
	public List<Curso> getAll();
	
	public Curso getById(int id);
	
	public Curso create(Curso curso);
		
	public Curso update(Curso curso);
	
	public void delete(int id);
	


}
