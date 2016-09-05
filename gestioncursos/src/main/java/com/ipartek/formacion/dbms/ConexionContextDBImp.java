package com.ipartek.formacion.dbms;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConexionContextDBImp implements ConexionDB {
  private static Connection connection = null;
  private static ConexionContextDBImp INSTANCE = null;
  private static final String DATA_SOURCE = "java:comp/env/jdbc/Alumnos";

  private ConexionContextDBImp() {
    if (INSTANCE == null) {
      conectar();
    }
  }

  // creador sincronizado para protegerse de posibles problemas multi-hilo
  // otra prueba para evitar instanciaciÃ³n mÃºltiple
  private synchronized static void createInstance() {
    if (connection == null) {
      INSTANCE = new ConexionContextDBImp();
    }
  }

  public static ConexionContextDBImp getInstance() {
    if (connection == null) {
      createInstance();
    }
    return INSTANCE;
  }

  @Override
  public void conectar() {
    if (connection == null) {
      try {
        InitialContext ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup(DATA_SOURCE);
        connection = ds.getConnection();
      } catch (NamingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  // El método "clone" es sobreescrito por el siguiente que arroja una excepción:
  @Override
  public Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
  }

  @Override
  public void desconectar() {
    if (connection != null) {
      try {
        connection.close();
        connection = null;
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  @Override
  public Connection getConexion() {
    return connection;
  }

}
