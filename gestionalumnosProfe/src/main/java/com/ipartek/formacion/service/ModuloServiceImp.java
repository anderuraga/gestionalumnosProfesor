package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.ModuloDAOImp;
import com.ipartek.formacion.dao.interfaces.ModuloDAO;
import com.ipartek.formacion.dao.persistence.Modulo;
import com.ipartek.formacion.service.interfaces.ModuloService;

@Service
public class ModuloServiceImp implements ModuloService {

  @Autowired
  private ModuloDAO moduloDAO = null;

  @Override
  public List<Modulo> getAll() {
    return moduloDAO.getAll();
  }

  @Override
  public Modulo getById(int id) {
    return moduloDAO.getById(id);
  }

  @Override
  public Modulo create(Modulo modulo) {
	  return moduloDAO.create(modulo);
  }

  @Override
  public Modulo update(Modulo modulo) {
    return moduloDAO.update(modulo);
  }

  @Override
  public void delete(int id) {
    moduloDAO.delete(id);

  }

  @Override
  public void setModuloDAO(ModuloDAOImp moduloDAO) {
    this.moduloDAO = moduloDAO;

  }
}
