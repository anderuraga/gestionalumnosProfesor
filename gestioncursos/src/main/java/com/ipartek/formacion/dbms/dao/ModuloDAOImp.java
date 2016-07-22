package com.ipartek.formacion.dbms.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.pojo.Modulo;
import com.ipartek.formacion.service.Util;

public class ModuloDAOImp implements ModuloDAO {
	
	private final static Logger LOG = Logger.getLogger(ModuloDAOImp.class);
	private static ModuloDAOImp INSTANCE = null;
	private static ConexionDB myConexion;
	private Connection conexion;
	
	private ModuloDAOImp(){
		myConexion = ConexionDBImp.getInstance();
	}
	
	public static ModuloDAOImp getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	/**
	 *
	 */
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ModuloDAOImp();
		}
	}
	
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	public Modulo create(Modulo modulo) {
/*le asignamos el codigo al modulo
		modulo.setCodigo(ModuloServiceImp.i);
		//lo añadimos a la "BBDD"
		modulos.add(modulo);
		i++;
		return modulo;
		*/
		Modulo modu = null;
		String sql = "{call insertModulo(?,?,?,?)}";

		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setString("nombre", modulo.getNombre());
			cSmt.setString("uFormativa", modulo.getReferencia());
			cSmt.setInt("duracion", modulo.getDuracion().getCodigo());
			cSmt.executeUpdate();
			modu = modulo;
			modu.setCodigo(cSmt.getInt("codModulo"));
		} catch (SQLException e) {
			LOG.fatal(e.getMessage() + " -- Error al insertar el módulo");
		} finally {
			myConexion.desconectar();
		}
		return modu;
	}

	@Override
	public Modulo getById(int codigo) {
/*	Modulo modulo = null;
	try {
			modulo = this.modulos.get(getIndex(codigo));
		} catch (ModuloServiceException e) {
			modulo = new Modulo();
		}
*/

	Modulo modulo = null;
		String sql = "{call getModuloById(?)}";
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codigo", codigo);
			ResultSet rs = cSmt.executeQuery();
			while (rs.next()) {
				modulo = parseModulo(rs);
			}
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		} finally {
			myConexion.desconectar();
		}

		return modulo;
		
	}
/*	private Modulo getIndex(int codigo){
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
	
	private Modulo parseModulo(ResultSet rs) {
		Modulo modulo = null;
		modulo = new Modulo();
		try {
			modulo.setCodigo(rs.getInt("codModulo"));
			modulo.setNombre(rs.getString("nombre"));
			modulo.setReferencia(rs.getString("uFormativa"));
			modulo.setDuracion(Util.parseDuracion(rs.getString("duracion")));
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		} 
		return modulo;
	}
	@Override
	public void delete(int codigo) {
/*		//DELETE FROM modulo
		//WHERE id = codigo;
		try {
			modulos.remove(getIndex(codigo));
		} catch (ModuloServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/		
		String sql = "{call deleteModulo(?)}";
		conexion = myConexion.getConexion();
		try{
			CallableStatement cSmt = conexion.prepareCall(sql);
			cSmt.setInt("codigo", codigo);
			
			cSmt.executeUpdate();
		} catch (SQLException e) {
			LOG.fatal(e.getMessage() + " -- Error al borrar el Módulo");
		} finally {
			myConexion.desconectar();
		}
	}

	public Modulo update(Modulo modulo) {
/*		try {
			this.modulos.set(getIndex(modulo.getCodigo()), modulo);
		} catch (ModuloServiceException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return modulo;
*/			
		Modulo modu = null;
		String sql = "{call updateModulo(?,?,?,?)}";
		LOG.trace(modulo.toString());
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codigo", modulo.getCodigo());
			cSmt.setString("nombre", modulo.getNombre());
			cSmt.setString("uFormativa", modulo.getReferencia());
			cSmt.setInt("duracion", modulo.getDuracion().getCodigo());
			cSmt.executeUpdate();
			modu = modulo;
		} catch (SQLException e) {
			modu = getById(modulo.getCodigo());
			LOG.fatal(e.getMessage() + " -- Error al actualizar");
		} finally {
			myConexion.desconectar();
		}
		return modu;
	}

	public List<Modulo> getAll() {
/*		return this.modulos;*/
	
	List<Modulo> modulos = null;
	String sql = "{call getAllModulo()}";
	conexion = myConexion.getConexion();
	try {
		Modulo modulo = null;
		CallableStatement cSmt = conexion.prepareCall(sql);
		ResultSet rs = cSmt.executeQuery();
		modulos = new ArrayList<Modulo>();
		while (rs.next()) {
			modulo = parseModulo(rs);
			modulos.add(modulo);
		}

	} catch (SQLException e) {
		LOG.error(e.getMessage());
	} finally {
		myConexion.desconectar();
	}
	return modulos;
}
}
