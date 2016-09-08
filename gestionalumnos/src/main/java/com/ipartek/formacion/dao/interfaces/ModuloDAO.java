package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistencia.Modulo;

public interface ModuloDAO extends DAOSetter {

  public Modulo create(Modulo modulo);

  public void delete(int id);

  public Modulo update(Modulo modulo);

  public Modulo getById(int id);

  public List<Modulo> getAll();
}
