/**
 * 
 */
package com.ipartek.formacion.dbms.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.pojo.Empleado;

/**
 * @author Curso
 *
 */
public class EmpleadoDAOImp implements EmpleadoDAO {

	private static final Logger LOG=Logger.getLogger(EmpleadoDAOImp.class);
	private ConexionDB dbConnection;
	private static EmpleadoDAOImp INSTANCE;
	
	
	/**
	 * 
	 */
	private EmpleadoDAOImp() {
		dbConnection=ConexionDBImp.getInstance();
	}
	
	private synchronized static void createInstance(){
		if(INSTANCE==null){
			INSTANCE=new EmpleadoDAOImp();
		}
	}
	
	public static EmpleadoDAOImp getInstance(){
		if(INSTANCE==null){
			createInstance();
		}
		
		
		return INSTANCE;
	}

	@Override
	public Empleado getById(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleado updateEmpleado(Empleado emp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmpleado(int codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Empleado createEmpleado(Empleado emp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empleado> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
