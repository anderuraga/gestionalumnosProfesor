package com.ipartek.formacion.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.DAO.EmpleadoDAO;
import com.ipartek.formacion.dbms.DAO.EmpleadoDAOImp;
import com.ipartek.formacion.pojo.Empleado;

public class EmpleadoServiceImp implements EmpleadoService {

	private static EmpleadoServiceImp INSTANCE = null;
	private final static Logger LOG = Logger.getLogger(EmpleadoService.class);

	private EmpleadoDAO empleDAO;

	private EmpleadoServiceImp() {

		empleDAO = EmpleadoDAOImp.getInstance();

	}

	public static EmpleadoServiceImp getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null)
			INSTANCE = new EmpleadoServiceImp();

	}

	@Override
	public Empleado createEmpleado(Empleado empleado) {
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
		// empleDAO.delete(codigo);

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

}
