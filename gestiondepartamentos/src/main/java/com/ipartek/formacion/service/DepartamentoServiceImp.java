package com.ipartek.formacion.service;

import java.util.List;
import org.apache.log4j.Logger;
import com.ipartek.formacion.dbms.dao.DepartamentoDAO;
import com.ipartek.formacion.pojo.Departamento;
import com.ipartek.formacion.pojo.Empleado;

public class DepartamentoServiceImp implements DepartamentoService {

	  private final static Logger LOG = Logger.getLogger(DepartamentoServiceImp.class);
	  private static DepartamentoServiceImp INSTANCE = null;
	public static DepartamentoService getInstance;
	  private DepartamentoDAO departamentoDao;


	  
	public Departamento CreateDepartamento(Departamento departamento) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Departamento> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Departamento UpdateDepartamento(Departamento departamento) {
		Departamento aux =null;
		aux=departamentoDao.UpdateDepartamento(departamento);
		return aux;
	}

	public void DeleteDepartamento(int departamento) {
		// TODO Auto-generated method stub
		
	}

	public Departamento getById(int departamento) {
		// TODO Auto-generated method stub
		return null;
	}
	
	  public static DepartamentoServiceImp getInstance() {
		    if (INSTANCE == null) {
		      createInstance();
		    }
		    return INSTANCE;
		  }
	  private synchronized static void createInstance() {
		    if (INSTANCE == null) {
		      INSTANCE = new DepartamentoServiceImp();
		    }
		  }

}