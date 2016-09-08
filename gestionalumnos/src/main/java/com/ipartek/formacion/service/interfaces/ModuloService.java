package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.ModuloDAOImp;
import com.ipartek.formacion.dao.persistencia.Modulo;

public interface ModuloService {

  public Modulo create(Modulo modulo);

  public void delete(int id);

  public Modulo update(Modulo modulo);

  public Modulo getById(int id);

  public List<Modulo> getAll();

  public void setModuloDAO(ModuloDAOImp moduloDAO);

}
