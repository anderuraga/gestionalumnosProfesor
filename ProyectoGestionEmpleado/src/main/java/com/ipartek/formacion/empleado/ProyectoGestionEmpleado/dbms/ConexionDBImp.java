package com.ipartek.formacion.empleado.ProyectoGestionEmpleado.dbms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ConexionDBImp implements ConexionDB{

	private Connection conexion;
	
	private static ConexionDBImp INSTANCE = null;
	
	private final static Logger LOG = Logger.getLogger(ConexionDBImp.class);
	
	public ConexionDBImp() {
		conexion = null;
		conectar();
	}

	@Override
	public void conectar() {
		String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://localhost:3306/gestionempleados";
	    String user = "root";
	    String password = "";
	    if (conexion == null) {
	      try {
	        Class.forName(driver);
	        conexion = DriverManager.getConnection(url, user, password);
	        LOG.trace("conectado a BBDD");
	      } catch (ClassNotFoundException e) {
	        LOG.error(e.getMessage());
	      } catch (SQLException e) {
	        LOG.error(e.getMessage() + " error conexion BBDD");
	      }
	}
		
	}

	@Override
	public void desconectar() {
		if (conexion != null) {
		      try {
		        conexion.close();
		        conexion = null;
		      } catch (SQLException e) {
		        LOG.error(e.getMessage());
		      }
		}
	}

	@Override
	public Connection getConexion() {
		conectar();
		return conexion;
	}
	
	/**
	 * METODO SINGLETON
	 */
	
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
		      INSTANCE = new ConexionDBImp();
		}
	}
	public static ConexionDBImp getInstance() {
	    if (INSTANCE == null) {
	      createInstance();
	    }

	    return INSTANCE;
	}

	  @Override
	  protected Object clone() throws CloneNotSupportedException {
	    // TODO Auto-generated method stub
	    throw new CloneNotSupportedException();
	}

}
