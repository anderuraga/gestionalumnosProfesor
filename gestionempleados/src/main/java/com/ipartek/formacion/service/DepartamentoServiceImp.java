package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.dbms.dao.DepartamentoDAO;
import com.ipartek.formacion.dbms.dao.DepartamentoDAOImp;
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
	private DepartamentoDAO dptoDAO;

	private DepartamentoServiceImp() {
		dptoDAO = DepartamentoDAOImp.getInstance();
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
		Departamento depart = dptoDAO.createDpto(dpto);
		return depart;
	}

	public Departamento getById(int codDpto) {
		Departamento dpto = dptoDAO.getById(codDpto);
		return dpto;
	}

	public void deleteDpto(int codDpto) {
		dptoDAO.deleteDpto(codDpto);
	}

	public Departamento updateDpto(Departamento dpto) {
		Departamento depart = dptoDAO.updateDpto(dpto);
		return depart;
	}

	public List<Departamento> getAll() {
		return dptoDAO.getAll();
	}

}
