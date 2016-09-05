package com.ipartek.formacion.dbms.dao.exceptions;

public class AlumnoDAOImpException extends Exception {
  public static final String MSG_ERROR_ALUMNO_INSERT="Los datos no se han podido insertar ";
  public static final int CODIGO_ERROR_ALUMNO_INSERT=4001;
  private int error;
  
  public AlumnoDAOImpException(String message,int codigo){
    super(message);
    this.error=4001;
  }
/**
   * 
   */
  public AlumnoDAOImpException() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @param arg0
   * @param arg1
   * @param arg2
   * @param arg3
   */
  public AlumnoDAOImpException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
    super(arg0, arg1, arg2, arg3);
    // TODO Auto-generated constructor stub
  }

  /**
   * @param arg0
   * @param arg1
   */
  public AlumnoDAOImpException(String arg0, Throwable arg1) {
    super(arg0, arg1);
    // TODO Auto-generated constructor stub
  }

  /**
   * @param arg0
   */
  public AlumnoDAOImpException(String arg0) {
    super(arg0);
    // TODO Auto-generated constructor stub
  }

  /**
   * @param arg0
   */
  public AlumnoDAOImpException(Throwable arg0) {
    super(arg0);
    // TODO Auto-generated constructor stub
  }


}
