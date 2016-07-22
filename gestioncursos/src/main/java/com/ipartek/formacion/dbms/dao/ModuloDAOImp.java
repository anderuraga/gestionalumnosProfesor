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
import com.ipartek.formacion.services.Util;

public final class ModuloDAOImp implements ModuloDAO {

	// singleton porque va a tener un atributo de conexion a bbdd
	private static final Logger LOG = Logger.getLogger(ModuloDAOImp.class);
	private ConexionDB myconexion;
	private static ModuloDAOImp INSTANCE;

	private ModuloDAOImp() {
		myconexion = ConexionDBImp.getInstance();
	}

	public static ModuloDAOImp getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ModuloDAOImp();
		}
	}

	@Override
	public Modulo getByID(int codigo) {
		String sql = "{call getByIDModulo(?)}";

		myconexion.conectar();
		Connection conexion = myconexion.getConexion();
		Modulo modulo = null;
		try {
			PreparedStatement pSmt = conexion.prepareStatement(sql);
			ResultSet rs = pSmt.executeQuery();
			while (rs.next()) {
				modulo = parseModulo(rs);
			}
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			myconexion.desconectar();
		}

		return modulo;
	}

	@Override
	public Modulo update(Modulo modulo) {
		String sql = "{call updateModulo(?,?,?,?)}";
		Modulo mod = null;

		Connection conection = myconexion.getConexion();

		try {
			CallableStatement cSmt = conection.prepareCall(sql);
			cSmt.setInt("codigo", modulo.getCodigo());
			cSmt.setString("nombre", modulo.getNombre());
			cSmt.setString("uFormativa", modulo.getReferencia());
			cSmt.setInt("duracion", modulo.getDuracion().getDuracion());

			cSmt.executeUpdate();
			mod = modulo;

		} catch (SQLException e) {
			mod = getByID(modulo.getCodigo());
			LOG.fatal(e.getMessage());
		} finally {
			myconexion.desconectar();
		}
		return mod;
	}

	@Override
	public Modulo insert(Modulo modulo) {
		String sql = "{call insertModulo(?,?,?,?)}";
		Modulo mod = null;

		Connection conection = myconexion.getConexion();

		try {
			CallableStatement cSmt = conection.prepareCall(sql);
			cSmt.setString("nombre", modulo.getNombre());
			cSmt.setInt("duracion", modulo.getDuracion().getDuracion());
			cSmt.setString("uFormativa", modulo.getReferencia());

			cSmt.executeUpdate();
			modulo.setCodigo(cSmt.getInt("codigo"));
			mod = modulo;

		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			myconexion.desconectar();
		}
		return mod;
	}

	@Override
	public void delete(int codigo) {
		String sql = "{call deleteModulo(?)}";

		Connection conection = myconexion.getConexion();

		try {
			CallableStatement cSmt = conection.prepareCall(sql);
			cSmt.setInt("codigo", codigo);
			// int nFilas =
			cSmt.executeUpdate();

		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			myconexion.desconectar();
		}

	}

	@Override
	public List<Modulo> getAll() {
		List<Modulo> modulos = null;
		String sql = "{call getAllModulo()}";

		Connection conection = myconexion.getConexion();
		Modulo modulo = null;
		try {
			CallableStatement cSmt = conection.prepareCall(sql);
			ResultSet rs = cSmt.executeQuery();
			modulos = new ArrayList<Modulo>();
			while (rs.next()) {
				modulo = parseModulo(rs);
				modulos.add(modulo);
			}
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			myconexion.desconectar();
		}

		return modulos;
	}

	private Modulo parseModulo(ResultSet rs) {
		Modulo modulo = null;
		modulo = new Modulo();
		try {
			modulo.setCodigo(rs.getInt("codModulo"));
			modulo.setNombre(rs.getString("nombre"));
			modulo.setReferencia(rs.getString("uFormativa"));
			modulo.setDuracion(Util.parseDuracion(String.valueOf(rs.getInt("duracion"))));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.fatal(e.getMessage());
		}

		return modulo;
	}

}
