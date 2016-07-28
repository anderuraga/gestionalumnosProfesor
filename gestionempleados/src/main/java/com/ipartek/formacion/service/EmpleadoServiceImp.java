package com.ipartek.formacion.service;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.dao.EmpleadoDAO;
import com.ipartek.formacion.dbms.dao.EmpleadoDAOImp;
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
   * @Override
   */
  public Empleado create(Empleado empleado) {
    return empDAO.create(empleado);
  }

}
