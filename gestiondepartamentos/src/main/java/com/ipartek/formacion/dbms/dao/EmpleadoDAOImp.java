package com.ipartek.formacion.dbms.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.pojo.Empleado;

public class EmpleadoDAOImp implements EmpleadoDAO {

	private static final Logger LOG = Logger
			.getLogger(EmpleadoDAOImp.class);
	private static EmpleadoDAOImp INSTANCE = null;
	private ConexionDB myConexion = null;

	public Empleado CreateEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Empleado> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Empleado UpdateEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		return null;
	}

	public void DeleteEmpleado(int empleado) {
		// TODO Auto-generated method stub

	}

	public Empleado getById(int empleado) {
		// TODO Auto-generated method stub
		return null;
	}

}
