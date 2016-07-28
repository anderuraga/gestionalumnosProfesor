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
import com.ipartek.formacion.pojo.Departamento;

public class DepartamentoDAOImp implements DepartamentoDAO {
	private static final Logger LOG = Logger.getLogger(DepartamentoDAOImp.class);
	private ConexionDB myConexion;
	private static DepartamentoDAOImp INSTANCE = null;

	private DepartamentoDAOImp() {
		myConexion = ConexionDBImp.getInstance();
	}

	public static DepartamentoDAOImp getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DepartamentoDAOImp();
		}

	}

	public Departamento getById(int codDpto) {
		String sql = "SELECT codDpto, nombre, descripcion FROM departamento WHERE codDpto=" + codDpto;
		Connection conexion = myConexion.getConexion();
		Departamento dpto = null;
		try {
			PreparedStatement pSmt = conexion.prepareStatement(sql);
			ResultSet rs = pSmt.executeQuery();
			while (rs.next()) {
				dpto = parseDepartamento(rs);
			}
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			myConexion.desconectar();
		}
		return dpto;
	}

	private Departamento parseDepartamento(ResultSet rs) {
		Departamento dpto = null;
		dpto = new Departamento();
		try {
			dpto.setCodDept(rs.getInt("codDpto"));
			dpto.setNombre(rs.getString("nombre"));
			dpto.setDescripcion(rs.getString("descripcion"));

		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		}
		return dpto;
	}

	public Departamento updateDpto(Departamento dpto) {
		Departamento depart = null;
		String sql = "{call updateDpto(?,?,?)}";

		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codDpto", dpto.getCodDept());
			cSmt.setString("nombre", dpto.getNombre());
			cSmt.setString("descripcion", dpto.getDescripcion());
			// cSmt.getInt("codEmple",dpto.getEmpleados().ge)
			cSmt.executeUpdate();
			depart = dpto;
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			myConexion.desconectar();
		}
		return depart;
	}

	public Departamento createDpto(Departamento dpto) {
		Departamento depart = null;
		String sql = "{call createDpto(?,?,?)}";
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codDpto", dpto.getCodDept());
			cSmt.setString("nombre", dpto.getNombre());
			cSmt.setString("descripcion", dpto.getDescripcion());
			cSmt.executeUpdate();
			depart = dpto;
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			myConexion.desconectar();
		}
		return dpto;
	}

	public void deleteDpto(int codDpto) {
		String sql = "{call deleteDpto(?)}";

		Connection conexion = myConexion.getConexion();
		try {
			CallableStatement cSmt = conexion.prepareCall(sql);
			cSmt.setInt("codigo", codDpto);
			cSmt.executeUpdate();
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			myConexion.desconectar();
		}

	}

	public List<Departamento> getAll() {
		List<Departamento> departamentos = null;
		String sql = "{call getAllDpto()}";
		Connection conexion = myConexion.getConexion();
		try {
			Departamento depart = null;
			CallableStatement cSmt = conexion.prepareCall(sql);
			ResultSet rs = cSmt.executeQuery();
			departamentos = new ArrayList<Departamento>();
			while (rs.next()) {
				depart = parseDepartamento(rs);
				departamentos.add(depart);
			}
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		} finally {
			myConexion.desconectar();
		}
		return departamentos;
	}

}
