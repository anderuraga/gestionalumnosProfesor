package com.ipartek.formacion.empleado.ProyectoGestionEmpleado.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.empleado.ProyectoGestionEmpleado.dbms.dao.EmpleadoDAO;
import com.ipartek.formacion.empleado.ProyectoGestionEmpleado.dbms.dao.EmpleadoDAOImp;
import com.ipartek.formacion.empleado.ProyectoGestionEmpleado.dbms.dao.exception.EmpleadoDAOImpException;
import com.ipartek.formacion.empleado.ProyectoGestionEmpleado.pojo.Empleado;

public class EmpleadoServiceImp implements EmpleadoService{
	
	private final static Logger LOG = Logger.getLogger(EmpleadoServiceImp.class);
	 
	private static EmpleadoServiceImp INSTANCE = null;
	
	private EmpleadoDAO empleadoDao;
	

	public EmpleadoServiceImp() {
		empleadoDao = EmpleadoDAOImp.getInstance();
	}

	@Override
	public Empleado createEmpleado(Empleado emple) {
		Empleado empleado = empleadoDao.createEmpleadoDAO(emple);
		return empleado;
	}

	@Override
	public Empleado getById(int id) throws EmpleadoDAOImpException {
		Empleado empleado = empleadoDao.getByIdDAO(id);
		return empleado;
	}

	@Override
	public void delete(int id) {
		empleadoDao.deleteDAO(id);
	}

	@Override
	public List<Empleado> getAll() {
		return empleadoDao.getAllDAO();
		
	}

	@Override
	public Empleado update(Empleado emple) {
		Empleado empleado = empleadoDao.updateDAO(emple);
		return empleado;
	}
	
	/**
	 * METODO SINGLETON
	 */
	
	private synchronized static void createInstance() {
	    if (INSTANCE == null) {
	      INSTANCE = new EmpleadoServiceImp();
	    }
	}
	
	public static EmpleadoServiceImp getInstance() {
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
