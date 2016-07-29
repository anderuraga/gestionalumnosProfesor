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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Departamento getById(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Departamento> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Departamento update(Departamento departamento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void darDeAlta(Departamento departamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darDeBaja(Departamento departamento) {
		// TODO Auto-generated method stub
		
	}

}
