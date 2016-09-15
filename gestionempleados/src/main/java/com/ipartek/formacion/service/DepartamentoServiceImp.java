package com.ipartek.formacion.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.dao.DepartamentoDAO;
import com.ipartek.formacion.dbms.dao.DepartamentoDAOImp;
import com.ipartek.formacion.pojo.Departamento;

public class DepartamentoServiceImp implements DepartamentoService {
  private static DepartamentoServiceImp INSTANCE = null;
  private static DepartamentoDAO depDAO;
  private static final Logger LOG = Logger.getLogger(DepartamentoServiceImp.class);

  /**
 * 
 */
  private DepartamentoServiceImp() {
    depDAO = DepartamentoDAOImp.getInstance();
  }

  /**
   * 
   * @return INSTANCE
   */
  public static DepartamentoServiceImp getInstance() {
    if (INSTANCE == null) {
      createInstance();
    }
    return INSTANCE;
  }

  /**
 * 
 */
  private synchronized static void createInstance() {
    if (INSTANCE == null) {
      INSTANCE = new DepartamentoServiceImp();
    }
  }

  /**
   * @Override
   * @return nada
   * @throws CloneNotSupportedException
   *           no se puede cñlonar
   */
  protected Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
  }

  @Override
  public List<Departamento> getAll() {

    return depDAO.getAll();
  }

}
