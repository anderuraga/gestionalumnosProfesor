package com.ipartek.formacion.service;

import com.ipartek.formacion.pojo.Departamento;

/**
 * Clase donde se implementan las operaciones CRUD declaradas en la interfaz
 * DepartamentoService.
 * 
 * @author Neli
 *
 */
public class DepartamentoServiceImp implements DepartamentoService {
	private static DepartamentoServiceImp INSTANCE = null;

	private DepartamentoServiceImp() {
		// this.modulos = new ArrayList<Modulo>();
		// init();
		// moduDAO = ModuloDAOImp.getInstance();
	}

	public static DepartamentoServiceImp getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DepartamentoServiceImp();
		}

	}

	public Departamento createDpto(Departamento dpto) {
		// TODO Auto-generated method stub
		return null;
	}

	public Departamento getById(int codDpto) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteDpto(int codDpto) {
		// TODO Auto-generated method stub

	}

	public Departamento updateDpto(Departamento dpto) {
		// TODO Auto-generated method stub
		return null;
	}

}
