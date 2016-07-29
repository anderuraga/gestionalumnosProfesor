package com.ipartek.formacion.service;

import java.util.List;


import com.ipartek.formacion.pojo.Departamento;

public class DepartamentoServiceImp implements DepartamentoService {
	private static DepartamentoServiceImp INSTANCE=null;
	private DepartamentoServiceImp DepartamentoDAO;
	
	private DepartamentoServiceImp(){
		DepartamentoDAO=DepartamentoServiceImp.getInstance();
		}
	
	private static synchronized void createInstance(){
		  if (INSTANCE==null) {
		    INSTANCE=new DepartamentoServiceImp();
		  }
		}
	
	public static DepartamentoServiceImp getInstance(){
		  if (INSTANCE==null) {
		    createInstance();
		  }
		  
		  
		  return INSTANCE;
		  
		}
	@Override
	public Departamento create(Departamento departamento) {
		Departamento dep=DepartamentoDAO.create(departamento);
		return dep;
	}

	@Override
	public Departamento getById(int codigo) {
		Departamento dep = null;
		dep=DepartamentoDAO.getById(codigo);


		return dep;
	}

	@Override
	public void delete(int codigo) {
		
		DepartamentoDAO.delete(codigo);
	}

	@Override
	public List<Departamento> getAll() {
		List<Departamento>departamentos= DepartamentoDAO.getAll();
		  
		  return departamentos;
	}

	@Override
	public Departamento update(Departamento departamento) {
		return DepartamentoDAO.update(departamento);
	}



	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		throw new  CloneNotSupportedException();
	}

}
