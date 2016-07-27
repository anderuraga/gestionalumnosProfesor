package com.ipartek.formacion.dbms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ConexionDBImp implements ConexionDB {
	private static final Logger LOG = Logger.getLogger(ConexionDBImp.class);
	private Connection conexion;
	private static ConexionDBImp INSTANCE = null;

	private ConexionDBImp() {
		conexion = null;
		conectar();
	}

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

	public void conectar() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/gestionemples";
		String user = "usuario";
		String password = "bd_usuario";
		if (conexion == null) {
			try {
				Class.forName(driver);// registra la libreria de la bbdd
				conexion = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				LOG.error(e.getMessage());
			} catch (SQLException e) {
				LOG.error(e.getMessage() + " error conexion BBDD");
			}
		}

	}

	public void desconectar() {
		if (conexion != null) {
			try {
				conexion.close();
				conexion = null;

			} catch (SQLException e) {
				LOG.error(e.getMessage());
				e.printStackTrace();
			}
		}

	}

	public Connection getConexion() {
		conectar();
		return this.conexion;
	}

}
