package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.dbms.dao.ModuloDAO;
import com.ipartek.formacion.dbms.dao.ModuloDAOImp;
import com.ipartek.formacion.pojo.Modulo;

public class ModuloServiceImp implements ModuloService{

	private static ModuloServiceImp INSTANCE = null;
	private ModuloDAO modulDAO;
	
	public ModuloServiceImp(){
		modulDAO = ModuloDAOImp.getInstance();
	}
	
	public ModuloServiceImp getInstance(){
		if(INSTANCE == null){
			createInstance();
		}
		
		return INSTANCE;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	private synchronized static void createInstance() {
		if(INSTANCE == null){
			INSTANCE = new ModuloServiceImp();
		}
	}
	
	@Override
	public Modulo create(Modulo modulo) {
		return modulDAO.insert(modulo);
	}

	@Override
	public Modulo getById(int codigo) {
		Modulo modulo = null;
		modulo = modulDAO.getById(codigo);
		return modulo;
	}
	
	/*
	private int getIndex(int codigo) throws ModuloServiceException{
		int index = -1;
		int i= 0,len = modulos.size();
		boolean encontrado = false;
		while(i < len && encontrado == false){
			if(this.modulos.get(i).getCodigo()==codigo){
				encontrado = true;
				index = i;
			}
			i++;
		}	
		if(i==-1){
			throw new  ModuloServiceException(ModuloServiceException.CODIGO_MODULO_NO_ECONTRADO,ModuloServiceException.MSG_MODULO_NO_ENCONTRADO);
		}
		return index;
	}
	*/
	
	@Override
	public void delete(int codigo) {
		modulDAO.delete(codigo);
	}

	@Override
	public List<Modulo> getAll() {
		return modulDAO.getAll();
	}

	@Override
	public Modulo update(Modulo modulo) {
		return modulDAO.update(modulo);
	}

}
