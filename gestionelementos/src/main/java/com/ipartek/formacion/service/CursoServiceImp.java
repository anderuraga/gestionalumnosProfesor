package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.CursoDAOImp;
import com.ipartek.formacion.dao.persistence.Curso;
import com.ipartek.formacion.service.interfaces.CursoService;
@Service
public class CursoServiceImp implements CursoService{

	@Override
	public List<Curso> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curso getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curso create(Curso curso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curso update(Curso curso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCursDAO(CursoDAOImp cursDAO) {
		// TODO Auto-generated method stub
		
	}

}
