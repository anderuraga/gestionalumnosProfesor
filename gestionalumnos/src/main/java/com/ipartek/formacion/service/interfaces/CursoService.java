package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.CursoDAOImp;
import com.ipartek.formacion.dao.persistencia.Curso;

public interface CursoService {

  public Curso create(Curso curso);

  public void delete(int id);

  public Curso update(Curso curso);

  public Curso getById(int id);

  public List<Curso> getAll();

  public void setCursoDAO(CursoDAOImp cursoDAO);
}
