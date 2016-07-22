package com.ipartek.formacion.dbms;

import java.sql.Connection;

/**
 * Esta clase es la encargada de realizar las conexiones y desconexiones a Base
 * de Datos.
 *
 * @author 
 */
public interface ConexionDB {
	public void conectar();

	public void desconectar();

	public Connection getConexion();

}
