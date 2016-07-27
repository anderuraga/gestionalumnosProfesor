package com.ipartek.formacion.dbms.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.pojo.Empleado;

public class EmpleadoDAOImp implements EmpleadoDAO {
	private static final Logger LOG = Logger.getLogger(EmpleadoDAOImp.class);
	private ConexionDB myConexion;
	private static EmpleadoDAOImp INSTANCE = null;

	private EmpleadoDAOImp() {
		myConexion = ConexionDBImp.getInstance();
	}

	public static EmpleadoDAOImp getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new EmpleadoDAOImp();
		}

	}

	public Empleado getById(int codEmple) {
		// TODO Auto-generated method stub
		return null;
	}

	public Empleado updateEmple(Empleado emple) {
		// TODO Auto-generated method stub
		return null;
	}

	public Empleado createEmple(Empleado emple) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteEmple(int codEmple) {
		// TODO Auto-generated method stub

	}

	public List<Empleado> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
