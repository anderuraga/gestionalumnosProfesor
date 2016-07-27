package com.ipartek.formacion.service;

import com.ipartek.formacion.pojo.Empleado;

/**
 * 
 * @author Neli
 *
 */
public class EmpleadoServiceImp implements EmpleadoService {
	private static EmpleadoServiceImp INSTANCE = null;

	private EmpleadoServiceImp() {
		// this.modulos = new ArrayList<Modulo>();
		// init();
		// moduDAO = ModuloDAOImp.getInstance();
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
		// TODO Auto-generated method stub
		return null;
	}

	public Empleado getById(int codEmple) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteEmple(int codEmple) {
		// TODO Auto-generated method stub

	}

	public Empleado updateEmple(Empleado emple) {
		// TODO Auto-generated method stub
		return null;
	}

}
