package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistencia.Curso;

public interface CursoDAO extends DAOSetter {

  public Curso create(Curso curso);

  public void delete(int id);

  public Curso update(Curso curso);

  public Curso getById(int id);

  public List<Curso> getAll();
}
