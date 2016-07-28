package com.ipartek.formacion.empleado.ProyectoGestionEmpleado.dbms;

	import java.sql.Connection;

public interface ConexionDB {

	  public void conectar();

	  public void desconectar();

	  public Connection getConexion();
	
}
