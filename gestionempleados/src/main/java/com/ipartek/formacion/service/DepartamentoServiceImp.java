package com.ipartek.formacion.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.DAO.DepartamentoDAO;
import com.ipartek.formacion.dbms.DAO.DepartamentoDAOImp;
import com.ipartek.formacion.pojo.Departamento;

public class DepartamentoServiceImp implements DepartamentoService {

	private static DepartamentoServiceImp INSTANCE = null;
	private final static Logger LOG = Logger.getLogger(DepartamentoServiceImp.class);

	private DepartamentoDAO depDAO;

	private DepartamentoServiceImp() {

		depDAO = DepartamentoDAOImp.getInstance();

	}

	public static DepartamentoServiceImp getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null)
			INSTANCE = new DepartamentoServiceImp();

	}

	@Override
	public Departamento createDepartamento(Departamento departamento) {
		Departamento dep = depDAO.insert(departamento);
		return dep;
	}

	@Override
	public Departamento getById(int codigo) {
		Departamento dep = depDAO.getByID(codigo);
		return dep;
	}

	@Override
	public void delete(int codigo) {
		depDAO.delete(codigo);

	}

	@Override
	public List<Departamento> getAll() {
		return depDAO.getAll();
	}

	@Override
	public Departamento update(Departamento departamento) {
		Departamento dep = depDAO.update(departamento);
		return dep;
	}

}
