package com.ipartek.formacion.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.dao.EmpleadoDAO;
import com.ipartek.formacion.dbms.dao.EmpleadoDAOImp;
import com.ipartek.formacion.dbms.dao.exceptions.EmpleadoDAOImpException;
import com.ipartek.formacion.pojo.Empleado;

public class EmpleadoServiceImp implements EmpleadoService {
  private static EmpleadoServiceImp INSTANCE = null;
  private static EmpleadoDAO empDAO;
  private static final Logger LOG = Logger.getLogger(EmpleadoServiceImp.class);

  /**
 * 
 */
  private EmpleadoServiceImp() {
    empDAO = EmpleadoDAOImp.getInstance();
  }

  /**
   * 
   * @return INSTANCE
   */
  public static EmpleadoServiceImp getInstance() {
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
      INSTANCE = new EmpleadoServiceImp();
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

  /**
   * @throws EmpleadoDAOImpException
   * @Override
   */
  public Empleado create(Empleado empleado) throws EmpleadoDAOImpException {
    return empDAO.create(empleado);
  }

  @Override
  public List<Empleado> getAll() {
    return empDAO.getAll();
  }

  @Override
  public Empleado getById(int codEmp) {

    return empDAO.getById(codEmp);
  }

}
