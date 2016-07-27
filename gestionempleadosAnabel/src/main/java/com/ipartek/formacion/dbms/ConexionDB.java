package com.ipartek.formacion.dbms;

import java.sql.Connection;

/**
 * Interfaz que define los metodos de conexion y desconexion de la BB.DD.
 * 
 * @author Anabel
 *
 */
public interface ConexionDB {

  /**
   * Metodo encargado de la desconexion a la BB.DD.
   */
  public void desconectar();

  /**
   * Metodo encargado de realizar la conexion a la BB.DD.
   */
  public void conectar();

  /**
   * Metodo encargado de devolver el objeto conexion para poder conectarnos a la BB.DD.
   * 
   * @return conexionDB <code>java.sql.Connection</code>
   */
  public Connection getConexion();
}
