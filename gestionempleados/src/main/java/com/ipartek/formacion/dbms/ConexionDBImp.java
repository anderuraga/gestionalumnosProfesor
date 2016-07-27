package com.ipartek.formacion.dbms;

import java.sql.Connection;

import org.apache.log4j.Logger;

public class ConexionDBImp implements ConexionDB{
	  private static final Logger LOG=Logger.getLogger(ConexionDBImp.class);
	  private  Connection conexion;
	  private static ConexionDBImp INSTANCE=null;
	  
	  private ConexionDBImp(){
	    conexion=null;
	    conectar();
	  }
	  

	  private synchronized static void createInstance() {
	    if (INSTANCE == null) { 
	        INSTANCE = new ConexionDBImp();
	    }
	}
	  public static ConexionDBImp getInstance() {
	    if (INSTANCE == null){
	      createInstance();
	    } 
	    return INSTANCE;
	}
	@Override
	public void conectar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void desconectar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Connection getConexion() {
		// TODO Auto-generated method stub
		return null;
	}

}
