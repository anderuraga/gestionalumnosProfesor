/**
 * 
 */
package com.ipartek.formacion.dbms.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.pojo.Departamento;

/**
 * @author Curso
 *
 */
public class DepartamentoDAOImp implements DepartamentoDAO {

	private static final Logger LOG=Logger.getLogger(EmpleadoDAOImp.class);
	private ConexionDB dbConnection;
	private static DepartamentoDAOImp INSTANCE;
	
	/**
	 * 
	 */
	private DepartamentoDAOImp() {
		dbConnection=ConexionDBImp.getInstance();
	}
	private synchronized static void createInstance(){
		if(INSTANCE==null){
			INSTANCE=new DepartamentoDAOImp();
		}
	}
	
	public static DepartamentoDAOImp getInstance(){
		if(INSTANCE==null){
			createInstance();
		}
		
		
		return INSTANCE;
	}
	@Override
	public Departamento getById(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Departamento updateDpto(Departamento dpto) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteDpto(int codigo) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Departamento createDepartamento(Departamento dpto) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Departamento> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
