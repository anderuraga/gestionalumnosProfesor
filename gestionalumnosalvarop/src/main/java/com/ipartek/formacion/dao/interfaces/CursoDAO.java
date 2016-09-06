package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.CursoDAOImp;
import com.ipartek.formacion.dao.persistencia.Curso;



public interface CursoDAO {

	
	public List<Curso>getAll();
	public Curso getByid(int id);
	public Curso create(Curso curso);
	public void delete(int id);
	public Curso update(Curso curso);

	public void setCursoDAO(CursoDAOImp cursDAO);

}
