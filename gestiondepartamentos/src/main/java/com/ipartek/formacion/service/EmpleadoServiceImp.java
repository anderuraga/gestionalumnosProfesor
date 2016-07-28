package com.ipartek.formacion.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.dao.DepartamentoDAO;
import com.ipartek.formacion.dbms.dao.EmpleadoDAO;
import com.ipartek.formacion.pojo.Departamento;
import com.ipartek.formacion.pojo.Empleado;

public class EmpleadoServiceImp implements EmpleadoService {

	  private final static Logger LOG = Logger.getLogger(EmpleadoServiceImp.class);
	  private static EmpleadoServiceImp INSTANCE = null;
	public static EmpleadoService getInstance;
	  private EmpleadoDAO empleadoDao;
	
	
	public Empleado CreateEmpleado(Departamento empleado) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Empleado> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Empleado UpdateEmpleado(Empleado empleado) {
		Empleado aux =null;
		aux=empleadoDao.UpdateEmpleado(empleado);
		return aux;
		}

	public void DeleteEmpleado(int empleado) {
		// TODO Auto-generated method stub
		
	}

	public Empleado getById(int empleado) {
		// TODO Auto-generated method stub
		return null;
	}

	public Empleado CreateEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		return null;
	}

	  public static EmpleadoServiceImp getInstance() {
		    if (INSTANCE == null) {
		      createInstance();
		    }
		    return INSTANCE;
		  }
	  private synchronized static void createInstance() {
		    if (INSTANCE == null) {
		      INSTANCE = new EmpleadoServiceImp();
		    }
		  }

	
}