package org.formacion.ipartek.gestionempleados.dbms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * Esta clase es la encargada de realizar las conexiones y desconexiones a base
 * de datos.
 * 
 * @author Josu
 *
 */
public final class ConexionDBImp implements ConexionDB {

	private Connection conexion;
	private static ConexionDBImp INSTANCE = null;
	private static final Logger LOG = Logger.getLogger(ConexionDBImp.class);

	private ConexionDBImp() {
		conexion = null;
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

	@Override
	public void conectar() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/gestionempleados";
		String user = "josu";
		String password = "josu";

		if (conexion == null) {
			try {
				Class.forName(driver);// registramos el driver que tiene que
										// usar para conectarse
				conexion = DriverManager.getConnection(url, user, password);
				LOG.info("Conexion a BBDD completada");
			} catch (ClassNotFoundException e) {
				LOG.error(e.getMessage());
			} catch (SQLException e) {
				LOG.error(e.getMessage() + " error en conexión a la BBDD");
			}
		}

	}

	@Override
	public void desconectar() {
		if (conexion != null) {
			try {
				conexion.close();
				conexion = null;
				LOG.info("Conexion a BBDD cerrada con exito");
			} catch (SQLException e) {
				LOG.error(e.getMessage());
			}
		}

	}

	@Override
	public Connection getConexion() {
		conectar();
		return this.conexion;
	}

}
