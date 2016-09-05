package com.ipartek.formacion.dao.interfaces;

import java.util.List;
import com.ipartek.formacion.dao.persistencia.Curso;

public interface CursoDAO extends DaoSetter{

	public List<Curso> getAll();
	
	public Curso getById(int id);
	
	public Curso create(Curso curso);
		
	public Curso update(Curso curso);
	
	public void delete(int id);
	
	
}
