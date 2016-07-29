package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Empleado;

public class EmpleadoServiceImp implements EmpleadoService {
	
	private static EmpleadoServiceImp INSTANCE=null;
	private EmpleadoServiceImp EmpleadoDAO;
	
	private EmpleadoServiceImp(){
		EmpleadoDAO=EmpleadoServiceImp.getInstance();
		}
	
	private static synchronized void createInstance(){
		  if (INSTANCE==null) {
		    INSTANCE=new EmpleadoServiceImp();
		  }
		}
	
	public static EmpleadoServiceImp getInstance(){
		  if (INSTANCE==null) {
		    createInstance();
		  }
		  
		  
		  return INSTANCE;
		  
		}
	

	@Override
	public Empleado create(Empleado empleado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleado getById(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Empleado> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleado update(Empleado empleado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void darDeAlta(Empleado empleado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darDeBaja(Empleado empleado) {
		// TODO Auto-generated method stub
		
	}

}
