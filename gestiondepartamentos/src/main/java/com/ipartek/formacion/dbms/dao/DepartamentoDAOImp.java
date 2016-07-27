package com.ipartek.formacion.dbms.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.pojo.Departamento;

public class DepartamentoDAOImp implements DepartamentoDAO {

	private static final Logger LOG = Logger
			.getLogger(DepartamentoDAOImp.class);
	private static DepartamentoDAOImp INSTANCE = null;
	private ConexionDB myConexion = null;

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
