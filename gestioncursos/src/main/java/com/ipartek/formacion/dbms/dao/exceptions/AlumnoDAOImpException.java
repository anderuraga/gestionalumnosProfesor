package com.ipartek.formacion.dbms.dao.exceptions;

public class AlumnoDAOImpException extends Exception{
  
  public static final String MSG_ERROR_ALUMNO_INSERT ="La insercion no ha podido ser realizada";

  public static final int CODIGO_ERROR_ALUMNO_INSERT =4001;

  private int codError;
  
  public AlumnoDAOImpException(String message, int codigo){
    super(message);
    this.codError = codigo;
  }

  public AlumnoDAOImpException() {
    super();
    // TODO Auto-generated constructor stub
  }

  public AlumnoDAOImpException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
    // TODO Auto-generated constructor stub
  }

  public AlumnoDAOImpException(String message, Throwable cause) {
    super(message, cause);
    // TODO Auto-generated constructor stub
  }

  public AlumnoDAOImpException(String message) {
    super(message);
    // TODO Auto-generated constructor stub
  }

  public AlumnoDAOImpException(Throwable cause) {
    super(cause);
    // TODO Auto-generated constructor stub
  }

}
