package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.CursoDAOImp;
import com.ipartek.formacion.dao.interfaces.CursoDAO;
import com.ipartek.formacion.dao.persistencia.Curso;
import com.ipartek.formacion.service.interfaces.CursoService;

@Service
public class CursosServiceImp implements CursoService {
  @Autowired
  private CursoDAO cursoDAO = null;

  @Override
  public List<Curso> getAll() {
    return cursoDAO.getAll();
  }

  @Override
  public Curso getById(int id) {
    return cursoDAO.getById(id);
  }

  @Override
  public Curso create(Curso curso) {
    return cursoDAO.create(curso);
  }

  @Override
  public Curso update(Curso curso) {
    // TODO Auto-generated method stub
    return cursoDAO.update(curso);
  }

  @Override
  public void delete(int id) {
    cursoDAO.delete(id);

  }

  @Override
  public void setCursoDAO(CursoDAOImp cursoDAO) {
    this.cursoDAO = cursoDAO;

  }

}
