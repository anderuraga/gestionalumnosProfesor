package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.dbms.dao.EmpleadoDAO;
import com.ipartek.formacion.dbms.dao.EmpleadoDAOImp;
import com.ipartek.formacion.pojo.Empleado;

/**
 * 
 * @author Neli
 *
 */
public class EmpleadoServiceImp implements EmpleadoService {
	private static EmpleadoServiceImp INSTANCE = null;
	private EmpleadoDAO empleDAO;

	private EmpleadoServiceImp() {
		// this.modulos = new ArrayList<Modulo>();
		// init();
		empleDAO = EmpleadoDAOImp.getInstance();
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

	public Empleado createEmple(Empleado emple) {
		Empleado emp = empleDAO.createEmple(emple);
		return emp;
	}

	public Empleado getById(int codEmple) {
		Empleado emp = empleDAO.getById(codEmple);
		return emp;
	}

	public void deleteEmple(int codEmple) {
		empleDAO.deleteEmple(codEmple);
	}

	public Empleado updateEmple(Empleado emple) {
		Empleado emp = empleDAO.updateEmple(emple);
		return emp;
	}

	public List<Empleado> getAll() {
		return empleDAO.getAll();
	}

}
