/**
 * 
 */
package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.dbms.dao.DepartamentoDAOImp;
import com.ipartek.formacion.pojo.Departamento;

/**
 * @author Curso
 *
 */
public class DepartamentoServiceImp implements DepartamentoService {

	private static DepartamentoServiceImp INSTANCE=null;
	private DepartamentoDAOImp dDAO=null;
	/**
	 * 
	 */
	public DepartamentoServiceImp() {
		dDAO=DepartamentoDAOImp.getInstance();
	}

	public static DepartamentoServiceImp getInstance(){
		if (INSTANCE==null) {
			INSTANCE=new DepartamentoServiceImp();
		}
		return INSTANCE;
	}
	
	private synchronized static void createInstance(){
		if (INSTANCE==null) {
			INSTANCE=new DepartamentoServiceImp();
		}
	}
	
	@Override
	public Departamento getById(int codigo) {
		Departamento aux=null;
		aux=dDAO.getById(codigo);
		return aux;
	}

	@Override
	public Departamento updateDpto(Departamento dpto) {
		Departamento aux=null;
		aux=dDAO.updateDpto(dpto);
		return aux;
	}

	@Override
	public void deleteDpto(int codigo) {
		dDAO.deleteDpto(codigo);
		
	}

	@Override
	public Departamento createDepartamento(Departamento dpto) {
		Departamento aux=null;
		aux=dDAO.createDepartamento(dpto);
		return aux;
	}

	@Override
	public List<Departamento> getAll() {
		
		return dDAO.getAll();
	}

}
