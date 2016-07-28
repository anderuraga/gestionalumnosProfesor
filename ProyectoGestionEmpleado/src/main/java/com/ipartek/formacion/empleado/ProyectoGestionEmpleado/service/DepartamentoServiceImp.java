package com.ipartek.formacion.empleado.ProyectoGestionEmpleado.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.empleado.ProyectoGestionEmpleado.pojo.Departamento;

public class DepartamentoServiceImp implements DepartamentoService{
	
	private final static Logger LOG = Logger.getLogger(DepartamentoServiceImp.class);
	 
	private static DepartamentoServiceImp INSTANCE = null;
	

	public DepartamentoServiceImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Departamento createDepartamento(Departamento dpto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Departamento getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Departamento> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Departamento update(Departamento dpto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * METODO SINGLETON
	 */
	
	private synchronized static void createInstance() {
	    if (INSTANCE == null) {
	      INSTANCE = new DepartamentoServiceImp();
	    }
	}
	
	public static DepartamentoServiceImp getInstance() {
	    if (INSTANCE == null) {
	      createInstance();
	    }
	    return INSTANCE;
	}

	 protected Object clone() throws CloneNotSupportedException {
		    LOG.error("Error al clonar");
		    throw new CloneNotSupportedException();
		}

}
