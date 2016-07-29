package com.ipartek.formacion.dbms;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @author Borja Garduño
 *
 * Esta clase es la encargada de gestionar 
 * las conexiones y desconexiones de las Bases de Datos.
 */

public class ConexionDBImp implements ConexionDB {

	private Connection conexion;
	private static ConexionDBImp INSTANCE = null;
	private static final Logger LOG = Logger.getLogger(ConexionDBImp.class);
	private Properties props = null;
	
	private ConexionDBImp(){
		conexion = null;
		conectar();
	}
	
	private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new ConexionDBImp();
        }
    }

    public static ConexionDBImp getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    public void loadDataBaseProperties(){
    	ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream input = classloader.getResourceAsStream("database.properties");
		props = new Properties();
		
		try{
			props.load(input);
		} catch(IOException e){
			LOG.error("No se han cargado las properties");
		}
    }
	
	@Override
	public void conectar() {
		loadDataBaseProperties();
		String driver = props.getProperty("database.driver");
		String url = props.getProperty("database.url");
		String user = props.getProperty("database.user");
		String password = props.getProperty("database.password");
		
		if(conexion==null){
			try {
				Class.forName(driver);
				conexion = DriverManager.getConnection(url, user, password);
				LOG.trace("Conectado a la BDA.");
			} catch (ClassNotFoundException e) {
				LOG.error("Error - ClassNotFoundException: " + e.getMessage());
			} catch (SQLException e) {
				LOG.error("Error - SQLException : " + e.getMessage());
			}
		}
	}

	@Override
	public void desconectar() {
		if(conexion!=null){
			try {
				conexion.close();
				conexion = null;
			} catch (SQLException e) {
				LOG.error("Error - SQLException: " + e.getMessage());
			}
		}
	}

	@Override
	public Connection getConexion() {
		conectar();
		
		if(conexion==null){
			LOG.trace("Conexion Nula");
		} else{
			LOG.trace("Conexion NO Nula");
		}
		
		return conexion;
	}

}
