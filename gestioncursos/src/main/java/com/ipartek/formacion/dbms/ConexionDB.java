package com.ipartek.formacion.dbms;

import java.sql.Connection;

/*
 * 
 * 
 */

public interface ConexionDB {
	/*
	 * Método que realiza la conexión de BBDD.
	 */
	
	public void conectar();
	
	/*
	 * Método que realiza la desconexión de BBDD.
	 */
	public void desconectar();
	
	public Connection getConexion();

}
