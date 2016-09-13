package com.ipartek.formacion.dbms.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.pojo.Duracion;
import com.ipartek.formacion.pojo.Modulo;
import com.ipartek.formacion.service.Util;

public class ModuloDAOImp implements ModuloDAO {

	private static final Logger LOG = Logger.getLogger(ModuloDAOImp.class);
	private ConexionDB dbConnection;
	private static ModuloDAOImp INSTANCE;

	private ModuloDAOImp() {
		dbConnection = ConexionDBImp.getInstance();
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
		Modulo m = null;
		Connection conexion = dbConnection.getConexion();
		String sql = "SELECT m.codModulo, m.nombreModulo,m.uFormativa, m.duracion from modulo m WHERE m.codModulo="
				+ codigo;
		try {
			PreparedStatement pStat=conexion.prepareStatement(sql);
			ResultSet rS=pStat.executeQuery();
			while (rS.next()) {
				m=parseModulo(rS);
				
			}
			
			
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			dbConnection.desconectar();
		}

		return m;
	}

	
	@Override
	public Modulo updateModulo(Modulo modulo) {
		Modulo m = null;
		Connection conexion = dbConnection.getConexion();
		String sql = "{call updateModulo(?,?,?,?)}";
		try {
			CallableStatement cStat=conexion.prepareCall(sql);
			cStat.setInt("codModulo", m.getCodModulo());
			cStat.setString("nombreModulo", m.getNombreModulo());
			cStat.setString("uFormativa", m.getUFormativa());
			cStat.setInt("durModulo", m.getDurModulo().getCodigo());
			
			cStat.executeUpdate();
			m=modulo;
			
			
			
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			dbConnection.desconectar();
		}
		return m;
	}

	@Override
	public void deleteModulo(int codigo) {
		Connection conexion = dbConnection.getConexion();
		String sql = "{call deleteModulo(?)}";
		try {
			CallableStatement cStat=conexion.prepareCall(sql);
			cStat.setInt("codModulo", codigo);
			cStat.executeUpdate();
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			dbConnection.desconectar();
		}
	}

	@Override
	public Modulo createModulo(Modulo modulo) {
		Modulo m = null;
		Connection conexion = dbConnection.getConexion();
		String sql = "{call insertModulo(?,?,?,?)}";
		try {
			CallableStatement cStat=conexion.prepareCall(sql);
			cStat.setInt("codModulo", m.getCodModulo());
			cStat.setString("nombreModulo", m.getNombreModulo());
			cStat.setString("uFormativa", m.getUFormativa());
			cStat.setInt("durModulo", m.getDurModulo().getCodigo());
			
			cStat.executeUpdate();
			m=modulo;
			m.setCodModulo(cStat.getInt("codModulo"));
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			dbConnection.desconectar();
		}
		return m;
	}

	@Override
	public List<Modulo> getAll() {
		List<Modulo> lModulos = null;
		Connection conexion = dbConnection.getConexion();
		String sql = "{call getAllModulo()}";
		try {
			CallableStatement cStat=conexion.prepareCall(sql);
			ResultSet rS=cStat.executeQuery();
			while (rS.next()) {
				lModulos.add(parseModulo(rS));
			}
			
			
			
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			dbConnection.desconectar();
		}
		return lModulos;
	}
	private Modulo parseModulo(ResultSet rS) {
		Modulo m=new Modulo();
		try {
			m.setCodModulo(rS.getInt("codModulo"));
			m.setNombre(rS.getString("nombreModulo"));
			m.setUFormativa(rS.getString("uFormativa"));
			Duracion d=Util.parseDuracion(rS.getInt("durModulo"));
			m.setDurModulo(d);
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		}
		return m;
	}


}
