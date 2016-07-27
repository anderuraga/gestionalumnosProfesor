package com.ipartek.formacion.service;

import java.util.List;
import org.apache.log4j.Logger;
import com.ipartek.formacion.dbms.dao.EmpleadoDAO;
import com.ipartek.formacion.dbms.dao.EmpleadoDAOImp;
import com.ipartek.formacion.pojo.Empleado;

public class EmpleadoServiceImp implements EmpleadoService{
	private final static Logger LOG = Logger.getLogger(EmpleadoServiceImp.class);
	private static EmpleadoServiceImp INSTANCE = null;
	private EmpleadoDAO emplDAO;
	
	private EmpleadoServiceImp() {
		
		emplDAO = EmpleadoDAOImp.getInstance();
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
	
	protected Object clone() throws CloneNotSupportedException {

		throw new CloneNotSupportedException();
	}

	@Override
	public Empleado createEmpleado(Empleado empleado) {
		Empleado empl = emplDAO.create(empleado);
		return empl;
	}

	@Override
	public Empleado getById(int codigo) {

		Empleado empleado = emplDAO.getById(codigo);

		return empleado;
	}

	@Override
	public void delete(int codigo) {
		emplDAO.delete(codigo);
		
	}

	@Override
	public List<Empleado> getAll() {
		List<Empleado> empleado = emplDAO.getAll();
		return empleado;
	}

	@Override
	public Empleado update(Empleado empleado) {
		
		return emplDAO.update(empleado);
	}


}
