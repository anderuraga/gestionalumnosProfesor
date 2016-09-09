package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipartek.formacion.dao.CursoDAOImp;
import com.ipartek.formacion.dao.persistencia.Curso;
import com.ipartek.formacion.service.interfaces.CursoService;

public class CursoServiceImp implements CursoService {

  @Autowired
  private CursoDAOImp cursoDAO;

  @Override
  public Curso create(Curso curso) {

	  this.cursoDAO.create(curso);
	  return curso;
  }

  @Override
  public void delete(int id) {

    this.cursoDAO.delete(id);
  }

  @Override
  public Curso update(Curso curso) {

    return this.cursoDAO.update(curso);
  }

  @Override
  public Curso getById(int id) {

    return this.cursoDAO.getById(id);
  }

  @Override
  public List<Curso> getAll() {

    return this.cursoDAO.getAll();
  }

  @Autowired
  @Override
  public void setCursoDAO(CursoDAOImp cursoDAO) {

    this.cursoDAO = cursoDAO;
  }

}
