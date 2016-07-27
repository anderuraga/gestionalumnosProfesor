package org.formacion.ipartek.gestionempleados.dbms;

import java.sql.Connection;

/**
 * Esta interfaz es la encargada de definir los métodos para las conexiones y
 * desconexiones a base de datos.
 * 
 * @author Josu
 *
 */
public interface ConexionDB {
	/**
	 * Método que realiza la conexión a la base de datos.
	 */
	public void conectar();

	/**
	 * Método que realiza la desconexión de la base de datos.
	 */

	public void desconectar();

	/**
	 * Método que devuelve el objeto de la conexion a la base de datos.
	 */

	public Connection getConexion();

}
