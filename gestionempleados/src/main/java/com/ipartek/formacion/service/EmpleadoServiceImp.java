package com.ipartek.formacion.service;

import java.util.List;


import com.ipartek.formacion.pojo.Empleado;

public class EmpleadoServiceImp implements EmpleadoService{
	private static EmpleadoServiceImp INSTANCE = null;
	private List<Empleado> empleados;
	private EmpleadoService empDAO;

	public EmpleadoServiceImp() {
		empDAO = EmpleadoServiceImp.getInstance();
	}
	
	public static EmpleadoServiceImp getInstance(){
		if(INSTANCE == null){
			createInstance();
		}
		return INSTANCE;
	}
	
	private synchronized static void createInstance() {
		if(INSTANCE == null){
			INSTANCE = new EmpleadoServiceImp();
		}
	
	}
	
	@Override
	public Empleado createEmpleado(Empleado empleado) {
		Empleado emp = empDAO.createEmpleado(empleado);
		
		return emp;
	}

	@Override
	public Empleado updateEmpleado(Empleado empleado) {
		Empleado emp = empDAO.updateEmpleado(empleado);
		
		return emp;
	}

	@Override
	public void deleteEmpleado(int codigo) {
		empDAO.deleteEmpleado(codigo);
		
	}

	@Override
	public Empleado getById(int codigo) {
		Empleado emp = empDAO.getById(codigo);
		
		return emp;
	}

	@Override
	public List<Empleado> getAll() {
		
		return empDAO.getAll();
	}

}
