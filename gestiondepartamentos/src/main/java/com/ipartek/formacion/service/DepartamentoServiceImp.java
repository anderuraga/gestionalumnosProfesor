package com.ipartek.formacion.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.dao.DepartamentoDAO;
import com.ipartek.formacion.pojo.Departamento;

public class DepartamentoServiceImp implements DepartamentoService {

	  private final static Logger LOG = Logger.getLogger(DepartamentoServiceImp.class);
	  private static DepartamentoServiceImp INSTANCE = null;
	  private DepartamentoDAO cursoDao;
	
	
	
	
	public Departamento CreateDepartamento(Departamento departamento) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Departamento> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Departamento UpdateDepartamento(Departamento departamento) {
		// TODO Auto-generated method stub
		return null;
	}

	public void DeleteDepartamento(int departamento) {
		// TODO Auto-generated method stub
		
	}

	public Departamento getById(int departamento) {
		// TODO Auto-generated method stub
		return null;
	}

}