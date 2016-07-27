package com.ipartek.formacion.dbms;

import java.sql.Connection;

/**
 * Esta interfaz va a definir los metodos para la conexión a BBDD.
 *
 * @author Erasmo
 *
 */
public interface ConexionDB {
	/**
	 * Metodo que realiza conexión a Base de Datos.
	 *
	 *
	 */
	public void conectar();

	/**
	 * Metodo que realiza la desconexión a Base de Datos.
	 */
	public void desconectar();

	/**
	 * <div>
	 * <p>
	 * Metodo que devuelve el objeto conexión a base datos.
	 * </p>
	 *
	 * @return conexion <code>java.sql.Connection</code> </div>
	 */
	public Connection getConexion();
}
