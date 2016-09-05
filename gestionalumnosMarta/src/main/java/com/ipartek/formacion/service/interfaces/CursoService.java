package com.ipartek.formacion.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.CursoDAOImp;
import com.ipartek.formacion.dao.persistencia.Curso;

@Service
public interface CursoService {

	public List<Curso> getAll();
	
	public Curso getById(int id);
	
	public Curso update(Curso curso);
	
	public void delete(int id);
	
	public Curso create(Curso curso);
	
	public void setCurDAO(CursoDAOImp curDAO);
}
