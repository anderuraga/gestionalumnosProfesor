package com.ipartek.formacion.dbms;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 *
 * @author Erasmo
 *
 *         Clase encargada de realizar conexiones y desconexiones a la DB.
 */
public class ConexionDBImp implements ConexionDB {
	private Connection conexion;
	private static ConexionDBImp INSTANCE = null;
	private final static Logger LOG = Logger.getLogger(ConexionDBImp.class);

	
	
	private ConexionDBImp() {
		conexion = null;
		conectar();
	}

	/**
	 *
	 * @return INSTANCE
	 * 
	 */
	
	public static ConexionDBImp getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}

		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ConexionDBImp();
		}
	}

	/**
	 * @Override
	 * @return nada
	 * @throws CloneNotSupportedException
	 *             no se puede clonar
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		throw new CloneNotSupportedException();
	}

	/**
	 * @Override
	 */
	
	
	
	public void conectar() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/gestioncursos";
		String user = "usuario";
		String password = "usuario";
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

	/**
	 * @Override
	 */
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

	/**
	 *
	 * @return conexion
	 */
	public Connection getConexion() {
		conectar();
		return conexion;
	}

}