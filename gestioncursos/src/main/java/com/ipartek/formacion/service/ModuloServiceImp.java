/**
 * 
 */
package com.ipartek.formacion.service;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.dbms.dao.ModuloDAO;
import com.ipartek.formacion.dbms.dao.ModuloDAOImp;
import com.ipartek.formacion.pojo.Curso;
import com.ipartek.formacion.pojo.Modulo;
import com.ipartek.formacion.pojo.exception.ModuloException;

/**
 * @author Curso
 *
 */
public class ModuloServiceImp implements ModuloService {

	private static ModuloServiceImp INSTANCE=null;
	private List<Modulo>modulos;
	private static int aCounter=1;
	private ModuloDAOImp moduloDAO=null;
	
	private ModuloServiceImp(){
//		this.modulos=new ArrayList<Modulo>();
//		init();
		moduloDAO=ModuloDAOImp.getInstance();
	}
	
	public static ModuloServiceImp getInstance(){
		if (INSTANCE==null) {
			INSTANCE=new ModuloServiceImp();
		}
		return INSTANCE;
	}
	
	private synchronized static void createInstance(){
		if (INSTANCE==null) {
			INSTANCE=new ModuloServiceImp();
		}
	}
	
	
	
//	public void init(){
//		Modulo m1=null;
//		try {
//			m1=new Modulo();
//			m1.setNombre("modulo mnbv");
//			m1.setCodModulo(1);
//			createModulo(m1);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		Modulo m2=null;
//		try {
//			m2=new Modulo();
//			m2.setNombre("modulo fghj");
//			m2.setCodModulo(2);
//			createModulo(m2);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Modulo m3=null;
//		try {
//			m3=new Modulo();
//			m3.setNombre("modulo rtyu");
//			m3.setCodModulo(3);
//			createModulo(m3);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	
	@Override
	public Modulo createModulo(Modulo modulo) {
		//modulo.setCodModulo(aCounter);
//		this.modulos.add(modulo);
//		aCounter++;
		Modulo aux=moduloDAO.createModulo(modulo);
		return aux;
	}

	@Override
	public Modulo getById(int codigo) throws ModuloException {
		Modulo aux=null;
//		int index;
//		try {
//			index=this.getIndex(codigo);
//			if (index <0) {
//				throw new ModuloException(ModuloException.CODIGO_ERROR_INDEX_MODULO,ModuloException.MSG_ERROR_INDEX_MODULO);
//			}
//			
//			aux=this.modulos.get(index);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		aux=moduloDAO.getById(codigo);
		return aux;
	}

	@Override
	public void deleteModulo(int codigo) {
//		int index=this.getIndex(codigo);
//		this.modulos.remove(index);
		moduloDAO.deleteModulo(codigo);
		
	}

	@Override
	public List<Modulo> getAll() {
		
		return moduloDAO.getAll();
	}

	@Override
	public Modulo updateModulo(Modulo modulo) {
//		int index=this.getIndex(modulo.getCodModulo());
//		this.modulos.set(index, modulo);
//		
//		return modulo;
		Modulo aux=moduloDAO.updateModulo(modulo);
		return aux;
		
	}

	private int getIndex(int codigo) {
		int index = -1;
		int i = 0;
		int len = this.modulos.size();
		boolean found = false;
		while (i < len && found == false) {
			Modulo aux = this.modulos.get(i);

			if (aux.getCodModulo() == codigo) {
				found = true;
				index = i;
			}
			i++;
		}

		return index;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	
	
}
