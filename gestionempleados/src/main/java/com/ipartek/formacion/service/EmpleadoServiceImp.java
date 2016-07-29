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
		Empleado emple=EmpleadoDAO.create(empleado);
		return emple;
	}

	@Override
	public Empleado getById(int codigo) {
		Empleado emp = null;
		emp=EmpleadoDAO.getById(codigo);


		return emp;
	}

	@Override
	public void delete(int codigo) {
		EmpleadoDAO.delete(codigo);
		
	}

	@Override
	public List<Empleado> getAll() {
		List<Empleado>empleados= EmpleadoDAO.getAll();
		  
		return empleados;
	}

	@Override
	public Empleado update(Empleado empleado) {
		
		return EmpleadoDAO.update(empleado);
	}





}
