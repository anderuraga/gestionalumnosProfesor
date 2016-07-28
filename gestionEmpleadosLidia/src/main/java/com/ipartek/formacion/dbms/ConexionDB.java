package com.ipartek.formacion.dbms;
/**
 * 
 * interfaz define métodos para la conex a la bbdd.
 */
import java.sql.Connection;

public interface ConexionDB {
	/**
	 * método que realiza la conex a la bbdd.
	 */
	public void conectar();

	/**
	 * método q realiza la desconex de la bbdd.
	 */
	public void desconectar();

	/**
	 * Método que devuelve el objeto conexión de bbdd
	 * @return conexion <code>java.sql.Connection</code>
	 */
	public Connection getConexion();

}
