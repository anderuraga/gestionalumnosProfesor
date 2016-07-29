package com.ipartek.formacion.dbms.dao.exceptions;

/**
 * 
 * @author Imanol Jimenez
 *
 */
public class EmpleadoDAOImpException extends Exception {
  private static final long serialVersionUID = 1L;
  public static final String MSG_ERROR_EMPLEADO_INSERT = "Error al insertar Empleado";
  public static final int CODIGO_ERROR_INSERT = 4001;
  public static final String MSG_ERROR_EMPLEADO_GET = "Error al obtener Empleado";
  public static final int CODIGO_ERROR_GET = 4002;
  public static final String MSG_ERROR_EMPLEADO_UPDATE = "Error al actualizar Empleado";
  public static final int CODIGO_ERROR_UPDATE = 4003;
  public static final String MSG_ERROR_EMPLEADO_DELETE = "Error al eliminar Empleado";
  public static final int CODIGO_ERROR_DELETE = 4004;

  private int codError;

  /**
   * 
   */

  public EmpleadoDAOImpException(int codigo, String message) {
    super(message);
    setCodError(codigo);
  }

  private void setCodError(int codError) {
    this.codError = codError;
  }

  public int getCodError() {
    return codError;
  }

  /**
   * 
   */
  public EmpleadoDAOImpException() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @param message
   * @param cause
   * @param enableSuppression
   * @param writableStackTrace
   */
  public EmpleadoDAOImpException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
    // TODO Auto-generated constructor stub
  }

  /**
   * @param message
   * @param cause
   */
  public EmpleadoDAOImpException(String message, Throwable cause) {
    super(message, cause);
    // TODO Auto-generated constructor stub
  }

  /**
   * @param message
   */
  public EmpleadoDAOImpException(String message) {
    super(message);
    // TODO Auto-generated constructor stub
  }

  /**
   * @param cause
   */
  public EmpleadoDAOImpException(Throwable cause) {
    super(cause);
    // TODO Auto-generated constructor stub
  }

}
