package com.ipartek.formacion.dbms;

import java.sql.Connection;

/**
 * Esta clase es la encargada de realizar las conexiones y desconexiones a Base
 * de Datos.
 *
 * @author Curso
 */
public interface ConexionDB {
	
	/**
	 * Este método conecta con la instancia de la  BBDD, con los datos proporcionados
	 * de usuario, contraseña, nombre BBDD, url, y driver.
	 */
	public void conectar();
	
	/**
	 * Este método desconecta con la instancia de la  BBDD.
	 */

	public void desconectar();

	/**
	 * Este método llama al método de conectar, 
	 * @return <code>Connection</code> devolviendo una instacia de la clase Connection.
	 */
	public Connection getConexion();

}
