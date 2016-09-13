/**
 * 
 */
package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.dbms.dao.EmpleadoDAO;
import com.ipartek.formacion.dbms.dao.EmpleadoDAOImp;
import com.ipartek.formacion.pojo.Empleado;

/**
 * @author Curso
 *
 */
public class EmpleadoServiceImp implements EmpleadoService {

	private static EmpleadoServiceImp INSTANCE=null;
	private EmpleadoDAOImp eDAO=null;
	/**
	 * 
	 */
	public EmpleadoServiceImp() {
		eDAO=EmpleadoDAOImp.getInstance();
	}
	public static EmpleadoServiceImp getInstance(){
		if (INSTANCE==null) {
			INSTANCE=new EmpleadoServiceImp();
		}
		return INSTANCE;
	}
	
	private synchronized static void createInstance(){
		if (INSTANCE==null) {
			INSTANCE=new EmpleadoServiceImp();
		}
	}
	

	@Override
	public Empleado getById(int codigo) {
		Empleado aux=null;
		aux=eDAO.getById(codigo);
		
		return aux;
	}

	@Override
	public Empleado updateEmpleado(Empleado emp) {
		Empleado aux=null;
		aux=eDAO.updateEmpleado(emp);
		return aux;
	}

	@Override
	public void deleteEmpleado(int codigo) {
		eDAO.deleteEmpleado(codigo);
		
	}

	@Override
	public Empleado createEmpleado(Empleado emp) {
		Empleado aux=null;
		aux=eDAO.createEmpleado(emp);
		return aux;
	}

	@Override
	public List<Empleado> getAll() {
		
		return eDAO.getAll();
	}

	@Override
	public Empleado trasladarEmpleado(Empleado emp, int codigo) {
		Empleado aux=null;
		aux=eDAO.trasladarEmpleado(emp, codigo);
		return aux;
	}

}
