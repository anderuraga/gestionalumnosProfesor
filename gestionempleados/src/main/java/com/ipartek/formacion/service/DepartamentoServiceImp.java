/**
 * 
 */
package com.ipartek.formacion.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.dao.DepartamentoDAO;
import com.ipartek.formacion.dbms.dao.DepartamentoDAOImp;
import com.ipartek.formacion.pojo.Departamento;

/**
 * @author Curso
 *
 */
public class DepartamentoServiceImp implements DepartamentoService {
	private final static Logger LOG = Logger.getLogger(DepartamentoServiceImp.class);
	private static DepartamentoServiceImp INSTANCE = null;
	private DepartamentoDAO departamDAO;
	
	private DepartamentoServiceImp() {
		// this.alumnos = new ArrayList<Alumno>();
		// init();
		departamDAO = DepartamentoDAOImp.getInstance();
	}

	public static DepartamentoServiceImp getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DepartamentoServiceImp();
		}

	}
	
	protected Object clone() throws CloneNotSupportedException {

		throw new CloneNotSupportedException();
	}


	@Override
	public Departamento createDepartamento(Departamento departamento) {
		Departamento departam = departamDAO.create(departamento);
		return departamento;
	}

	@Override
	public Departamento getById(int codigo) {
		Departamento departamento = departamDAO.getById(codigo);
		return departamento;
	}

	@Override
	public void delete(int codigo) {
		departamDAO.delete(codigo);
		
	}

	@Override
	public List<Departamento> getAll() {
		List<Departamento> departamento = departamDAO.getAll();
		return departamento;
	}

	@Override
	public Departamento update(Departamento departamento) {
		return departamDAO.update(departamento);
	}

}
