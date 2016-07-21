package com.ipartek.formacion.dbms.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.pojo.Modulo;
import com.ipartek.formacion.service.Util;

public class ModuloDAOImp implements ModuloDAO{
	private static final Logger LOG = Logger.getLogger(ModuloDAOImp.class);
	private static ConexionDB myConexion;
	private Connection conexion;
	private static ModuloDAOImp INSTANCE = null;
	
	private ModuloDAOImp(){
		myConexion = ConexionDBImp.getInstance(); //al crear una instancia, se realiza la conexion
		
	}
	
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ModuloDAOImp();
		}
	}

	public static ModuloDAOImp getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}
	

	@Override
	public Modulo getById(int codigo) {
		Modulo modulo = null;
		String sql = "SELECT codModulo, nombre, duracion, uFormativa "
				+ "FROM modulo "
				+ "WHERE codModulo =" + codigo;
		
		conexion = myConexion.getConexion();
		try {
			PreparedStatement pSmt =  conexion.prepareStatement(sql);
			ResultSet rs = pSmt.executeQuery();
			while(rs.next()){
				modulo = parseModulo(rs);
			}
			
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		}finally{
			myConexion.desconectar();
		}
		
		return modulo;
	}

	private Modulo parseModulo(ResultSet rs) {
		Modulo modulo = null;
		modulo = new Modulo();
		try {
			modulo.setCodigo(rs.getInt("codModulo"));
			modulo.setNombre(rs.getString("nombre"));
			modulo.setHoras(Util.parseHoras(rs.getString("duracion")));
			modulo.setuFormativa(rs.getString("uFormativa"));
			
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		}
		return modulo;
	}

	@Override
	public Modulo update(Modulo modulo) {
		Modulo mod = null;
		String sql = "{call updateModulo(?,?,?,?)}"; 
		
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codigo", modulo.getCodigo());
			cSmt.setString("nombre", modulo.getNombre());
			cSmt.setString("uFormativa", modulo.getuFormativa());
			cSmt.setInt("duracion", modulo.getHoras().getCodigo());
			cSmt.executeUpdate();
			mod = modulo; //si todo va bien meto los datos de alumno en alum que es el objeto que voy a devolver
		} catch (SQLException e) {
			mod = getById(modulo.getCodigo());
			LOG.fatal(e.getMessage());
		}finally{
			myConexion.desconectar();
		}
		
		return mod;
	}

	@Override
	public Modulo create(Modulo modulo) {
		Modulo mod = null;
		String sql = "{call insertModulo(?,?,?,?)}"; 
		
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setString("nombre", modulo.getNombre());
			cSmt.setString("uformativa", modulo.getuFormativa());
			cSmt.setInt("duracion", modulo.getHoras().getCodigo());
			cSmt.executeUpdate();
			mod = modulo;
			modulo.setCodigo(cSmt.getInt("codigo")); 
			
		} catch (SQLException e) {
			mod = getById(modulo.getCodigo());
			LOG.fatal(e.getMessage());
		}finally{
			myConexion.desconectar();
		}
		
		return mod;
	}

	@Override
	public void delete(int codigo) {
		String sql = "{call deleteModulo(?)}"; //llamamos al procedimiento almacenado en bbdd, cada parametro se pone con una ?
		
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codigo", codigo); //"codigo" pq en el procedimiento le hemos llamado codigo, y codigo xq le hemos llamado así en el método delete
			cSmt.executeUpdate();
			
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		}finally{
			myConexion.desconectar();
		}
		
	}

	@Override
	public List<Modulo> getAll() {
		List<Modulo> modulos = null;
		String sql = "{call getAllModulo()}"; //llamamos al procedimiento almacenado en bbdd
		
		try {
			Modulo modulo = null;
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			ResultSet rs = cSmt.executeQuery();
			modulos = new ArrayList<Modulo>();
			while(rs.next()){
				modulo = parseModulo(rs);
				modulos.add(modulo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			myConexion.desconectar();
		}
		
		
		return modulos;
	}

}
