package com.ipartek.formacion.dbms.dao.exceptions;

public class EmpleadoDAOImpException extends Exception{
	public static final String MSG_ERROR_EMPLEADO_INSERT="Los datos insertados no son correctos";
	public static final int CODIGO_ERROR_EMPLEADO_INSERT=4001;
	private int codError;
	
	public EmpleadoDAOImpException(String message,int codigo){
		super(message);
		this.codError=codigo;	
	}
	
	public EmpleadoDAOImpException() {
		super();
		// TODO Auto-generated constructor stub
	}

	
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
