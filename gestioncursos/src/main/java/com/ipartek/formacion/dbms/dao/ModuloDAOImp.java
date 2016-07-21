package com.ipartek.formacion.dbms.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.pojo.Modulo;

public class ModuloDAOImp implements ModuloDAO{
  private static final Logger LOG=Logger.getLogger(ModuloDAOImp.class);
  private ConexionDB myConexion;
  private static ModuloDAOImp INSTANCE;
  
  private ModuloDAOImp(){
    myConexion=ConexionDBImp.getInstance();
  }
  
  private synchronized static void createInstance() {
    if (INSTANCE == null) {
      INSTANCE = new ModuloDAOImp();
    }
  }
  @Override
  public Modulo getById(int codigo) {
    Modulo modulo = null;
    return modulo;
  }

  @Override
  public Modulo update(Modulo modulo) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Modulo create(Modulo modulo) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void delete(int codigo) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public List<Modulo> getAll() {
    // TODO Auto-generated method stub
    return null;
  }

}
