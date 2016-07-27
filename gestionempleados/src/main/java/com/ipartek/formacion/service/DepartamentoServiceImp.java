package com.ipartek.formacion.service;

import java.util.List;


import com.ipartek.formacion.dbms.dao.DepartamentoDAO;
import com.ipartek.formacion.dbms.dao.DepartamentoDAOImp;
import com.ipartek.formacion.pojo.Departamento;

public class DepartamentoServiceImp implements DepartamentoService{
	private static DepartamentoServiceImp INSTANCE = null;
	private List<Departamento> departamentos;
	private DepartamentoDAO depDAO;
	
	
	
	/**
	 * 
	 */
	public DepartamentoServiceImp() {
		depDAO = DepartamentoDAOImp.getInstance();
	}
	
	public static DepartamentoServiceImp getInstance(){
		if(INSTANCE == null){
			createInstance();
		}
		return INSTANCE;
	}
	
	private synchronized static void createInstance() {
		if(INSTANCE == null){
			INSTANCE = new DepartamentoServiceImp();
		}
	
	}

	@Override
	public Departamento createDepartamento(Departamento departamento) {
		Departamento dep = depDAO.create(departamento);
		
		return dep;
	}

	@Override
	public Departamento updateDepartamento(Departamento departamento) {
		Departamento dep = depDAO.update(departamento);
		
		return dep;	
	}

	@Override
	public void deleteDepartamento(int codigo) {
		depDAO.delete(codigo);	
	}

	@Override
	public Departamento getById(int codigo) {
		Departamento dep = depDAO.getById(codigo);
		
		return dep;
	}

	@Override
	public List<Departamento> getAll() {
		
		return depDAO.getAll();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		throw new CloneNotSupportedException(); 
	}
}
