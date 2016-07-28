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
import com.ipartek.formacion.pojo.Empleado;

public class EmpleadoDAOImp implements EmpleadoDAO {
	private static final Logger LOG = Logger.getLogger(EmpleadoDAOImp.class);
	private ConexionDB myConexion;
	private static EmpleadoDAOImp INSTANCE = null;

	private EmpleadoDAOImp() {
		myConexion = ConexionDBImp.getInstance();
	}

	public static EmpleadoDAOImp getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new EmpleadoDAOImp();
		}

	}

	public Empleado getById(int codEmple) {
		String sql = "SELECT codEmple, nombre, apellidos, fechaNacim, fechaContratacion, nss, cuentaCorriente, direccion, localidad,cp, dni, codDepartamento"
				+ "FROM empleado WHERE codEmple=" + codEmple;
		Connection conexion = myConexion.getConexion();
		Empleado emple = null;
		try {
			PreparedStatement pStm = conexion.prepareStatement(sql);
			ResultSet rs = pStm.executeQuery();
			while (rs.next()) {
				emple = parseEmple(rs);
			}
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			myConexion.desconectar();
		}

		return emple;
	}

	private Empleado parseEmple(ResultSet rs) {
		Empleado emple = null;
		emple = new Empleado();
		try {
			emple.setCodEmple(rs.getInt("codEmple"));
			emple.setNombre(rs.getString("nombre"));
			emple.setApellidos(rs.getString("apellidos"));
			emple.setFechaNacim(rs.getDate("fechaNacim"));
			emple.setFechaContratacion(rs.getDate("fechaContratacion"));
			emple.setNumSS(rs.getString("nss"));
			emple.setCuentaCorriente(rs.getString("cuentaCorriente"));
			emple.setDireccion(rs.getString("direccion"));
			emple.setLocalidad(rs.getString("localidad"));
			emple.setCp(rs.getInt("cp"));
			emple.setDni(rs.getString("dni"));
			emple.getDpto().setCodDept(rs.getInt("codDepartamento"));

		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		}

		return emple;
	}

	public Empleado updateEmple(Empleado emple) {
		Empleado e = null;
		String sql = "{call updateEmple(?,?,?,?,?,?,?,?,?,?,?,?)}";
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codEmple", emple.getCodEmple());
			cSmt.setString("nombre", emple.getNombre());
			cSmt.setString("apellidos", emple.getApellidos());
			cSmt.setDate("fechaNacim", new java.sql.Date(emple.getFechaNacim().getTime()));
			cSmt.setDate("fechaContratacion", new java.sql.Date(emple.getFechaContratacion().getTime()));
			cSmt.setString("nss", emple.getNumSS());
			cSmt.setString("cuentaCorriente", emple.getCuentaCorriente());
			cSmt.setString("direccion", emple.getDireccion());
			cSmt.setString("localidad", emple.getLocalidad());
			cSmt.setInt("cp", emple.getCp());
			cSmt.setString("dni", emple.getDni());
			cSmt.setInt("codDepartamento", emple.getDpto().getCodDept());
			cSmt.executeUpdate();
			e = emple;
		} catch (SQLException e1) {
			LOG.fatal(e1.getMessage());
		} finally {
			myConexion.desconectar();
		}

		return e;
	}

	public Empleado createEmple(Empleado emple) {
		Empleado emp = null;
		String sql = "{call createEmple(?,?,?,?,?,?,?,?,?,?,?,?)}";
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setString("nombre", emple.getNombre());
			cSmt.setString("apellidos", emple.getApellidos());
			cSmt.setDate("fechaNacim", new java.sql.Date(emple.getFechaNacim().getTime()));
			cSmt.setDate("fechaContratacion", new java.sql.Date(emple.getFechaContratacion().getTime()));
			cSmt.setString("nss", emple.getNumSS());
			cSmt.setString("cuentaCorriente", emple.getCuentaCorriente());
			cSmt.setString("direccion", emple.getDireccion());
			cSmt.setString("localidad", emple.getLocalidad());
			cSmt.setInt("cp", emple.getCp());
			cSmt.setString("dni", emple.getDni());
			cSmt.setInt("codDepartamento", emple.getDpto().getCodDept());
			cSmt.executeUpdate();
			emp = emple;
			emp.setCodEmple(cSmt.getInt("codEmple"));
			emp = emple;
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			myConexion.desconectar();
		}

		return emp;
	}

	public void deleteEmple(int codEmple) {
		String sql = "{call deleteEmple(?)}";
		Connection conexion = myConexion.getConexion();
		try {
			CallableStatement cSmt = conexion.prepareCall(sql);
			cSmt.setInt("codigo", codEmple);
			cSmt.executeUpdate();
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			myConexion.desconectar();
		}

	}

	public List<Empleado> getAll() {
		List<Empleado> empleados = null;
		String sql = "{call getAllEmples()}";
		Connection conexion = myConexion.getConexion();
		try {
			Empleado emple = null;
			CallableStatement cSmt = conexion.prepareCall(sql);
			ResultSet rs = cSmt.executeQuery();
			empleados = new ArrayList<Empleado>();
			while (rs.next()) {
				emple = parseEmple(rs);
				empleados.add(emple);
			}
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			myConexion.desconectar();
		}

		return empleados;
	}

}
