package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.dbms.dao.ModuloDAO;
import com.ipartek.formacion.dbms.dao.ModuloDAOImp;
import com.ipartek.formacion.pojo.Modulo;

public class ModuloServiceImp implements ModuloService {

	private static ModuloServiceImp INSTANCE = null;
	private ModuloDAO moduDAO;

	/*
	 * private void init(){ Modulo modulo = new Modulo(); modulo.setNombre(
	 * "Desarrollo Aplicaciones Web"); create(modulo); }
	 */

	private ModuloServiceImp() {
		// this.modulos = new ArrayList<Modulo>();
		// init();
		moduDAO = ModuloDAOImp.getInstance();
	}

	public static ModuloServiceImp getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ModuloServiceImp();
		}

	}

	@Override
	public Modulo create(Modulo modulo) {
		Modulo mod = moduDAO.create(modulo);
		return mod;
	}

	@Override
	public Modulo getById(int codigo) {
		Modulo mod = moduDAO.getById(codigo);
		return mod;
	}

	/*
	 * private int getIndex(int codigo) throws ModuloServiceException { int
	 * index = -1; int i = 0, len = modulos.size(); boolean encontrado = false;
	 * while (i < len && encontrado == false) { if
	 * (this.modulos.get(i).getCodigo() == codigo) { encontrado = true; index =
	 * i; } i++; } if (i == -1) { throw new
	 * ModuloServiceException(ModuloServiceException.CODIGO_MODULO_NO_ECONTRADO,
	 * ModuloServiceException.MSG_MODULO_NO_ENCONTRADO); } return index; }
	 */

	@Override
	public void delete(int codigo) {
		moduDAO.delete(codigo);
	}

	@Override
	public List<Modulo> getAll() {

		return moduDAO.getAll();
	}

	@Override
	public Modulo update(Modulo modulo) {
		Modulo mod = moduDAO.update(modulo);
		return mod;
	}

}
