package com.ipartek.formacion.dbms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * Clase que define los metodos de conexion y desconexion con la BB.DD.
 * 
 * @author Anabel
 *
 */
public class ConexionDBImp implements ConexionDB {

  private Connection conexionDB = null;
  private static ConexionDBImp INSTANCE = null;
  private static final Logger LOG = Logger.getLogger(ConexionDBImp.class);

  /**
   * Constructor de la clase conexion con BB.DD.
   */
  public ConexionDBImp() {
    super();
  }

  public static ConexionDBImp getInstance() {

    if (INSTANCE == null) {
      createInstance();
    }
    return INSTANCE;

  }

  private static synchronized void createInstance() {

    if (INSTANCE == null) {
      INSTANCE = new ConexionDBImp();
    }

  }

  /**
   * Metodo encargado de realizar la desconexion a la BB.DD.
   */
  @Override
  public void desconectar() {

    if (conexionDB != null) {
      try {
        conexionDB.close();
      } catch (SQLException e) {
        LOG.fatal(e.getMessage() + "Se ha producido un error en la desconexion con la BB.DD.");
      }
    }

  }

  /**
   * Metodo encargado de realizar la conexion con la BB.DD.
   */
  @Override
  public void conectar() {

    String url = "jdbc:mysql://localhost:3306/gestionempleado";
    String user = "usuario";
    String pass = "usuario";
    if (conexionDB == null) {
      try {
        Class.forName("com.mysql.jdbc.Driver");
        conexionDB = DriverManager.getConnection(url, user, pass);
      } catch (ClassNotFoundException e) {
        LOG.error(e.getMessage());

      } catch (SQLException e) {
        LOG.fatal(e.getMessage() + "Ha ocurrido un error en la conexion a la BB.DD.");
      }
    }

  }

  /**
   * 
   * Metodo que devuelve el objeto conexion, para poder realizar las consultas a la BB.DD.
   * 
   * @return conexionDB <code>java.sql.Connection</code> objeto conexion
   */
  @Override
  public Connection getConexion() {

    conectar();
    return conexionDB;
  }

}
