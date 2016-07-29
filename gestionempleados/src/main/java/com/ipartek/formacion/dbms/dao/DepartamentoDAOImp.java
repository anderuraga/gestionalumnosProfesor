package com.ipartek.formacion.dbms.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.pojo.Departamento;

public class DepartamentoDAOImp implements DepartamentoDAO{
	private static final Logger LOG=Logger.getLogger(DepartamentoDAOImp.class);
	private ConexionDB myConexion;
	private static DepartamentoDAOImp INSTANCE=null;;

	  private DepartamentoDAOImp(){
	    myConexion=ConexionDBImp.getInstance();
	  }
	  
	  private synchronized static void createInstance() {
	    if (INSTANCE == null) {
	      INSTANCE = new DepartamentoDAOImp();
	    }
	  }
	  
	  public static DepartamentoDAOImp getInstance(){
	   if (INSTANCE==null) {
	       createInstance();
	  } 
	   return INSTANCE;
	  }
	  
	  
	@Override
	public Departamento getById(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Departamento update(Departamento departamento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Departamento create(Departamento departamento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Departamento> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
