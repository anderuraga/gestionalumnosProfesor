package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.dbms.dao.EmpleadoDAO;
import com.ipartek.formacion.dbms.dao.EmpleadoDAOImp;
import com.ipartek.formacion.pojo.Empleado;

/**
 * Implementacion de las operaciones CRUD de la interfaz de Empleado
 */

public class EmpleadoServiceImp implements EmpleadoService {

	private static EmpleadoServiceImp INSTANCE = null;
	private EmpleadoDAO empleDAO;
	
	public EmpleadoServiceImp(){
		empleDAO = EmpleadoDAOImp.getInstance();
	}
	
	public EmpleadoServiceImp getInstance(){
		if(INSTANCE == null){
			createInstance();
		}
		
		return INSTANCE;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	private synchronized static void createInstance() {
		if(INSTANCE == null){
			INSTANCE = new EmpleadoServiceImp();
		}
	}
	
	@Override
	public Empleado insert(Empleado empleado) {
		return empleDAO.insert(empleado);
	}

	@Override
	public Empleado getById(int codigo) {
		Empleado empleado = null;
		empleado = empleDAO.getById(codigo);
		return empleado;
	}

	@Override
	public void delete(int codigo) {
		empleDAO.delete(codigo);
	}

	@Override
	public List<Empleado> getAll() {
		return empleDAO.getAll();
	}

	@Override
	public Empleado update(Empleado empleado) {
		return empleDAO.update(empleado);
	}

}
