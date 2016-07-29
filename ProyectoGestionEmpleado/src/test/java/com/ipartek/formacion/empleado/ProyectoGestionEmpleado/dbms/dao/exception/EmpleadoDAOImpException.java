package com.ipartek.formacion.empleado.ProyectoGestionEmpleado.dbms.dao.exception;

public class EmpleadoDAOImpException extends Exception {
	
	public static final String MSG_ERROR_EMPLEADO_GETBYID = "La Busqueda no ha podido ser realizada";
	public static final int CODIGO_ERROR_EMPLEADO_GETBYID = 202;
	private int codError;

	
	public EmpleadoDAOImpException(String message, int codigo){
		super(message);
		this.codError=codigo;
	}
	public EmpleadoDAOImpException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmpleadoDAOImpException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public EmpleadoDAOImpException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public EmpleadoDAOImpException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public EmpleadoDAOImpException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	

}
