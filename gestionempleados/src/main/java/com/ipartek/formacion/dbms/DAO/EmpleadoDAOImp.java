package com.ipartek.formacion.dbms.DAO;

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
	private ConexionDB myconexion;
	private static EmpleadoDAOImp INSTANCE;

	private EmpleadoDAOImp() {
		myconexion = ConexionDBImp.getInstance();
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

	@Override
	public Empleado update(Empleado empleado) {
		String sql = "{call updateEmpleado(?,?,?,?,?,?,?,?,?,?,?,?)}";
		Empleado emple = null;

		Connection conection = myconexion.getConexion();

		try {
			CallableStatement cSmt = conection.prepareCall(sql);

			cSmt.setInt("codEmpleado", empleado.getCodigo());
			cSmt.setString("nombre", empleado.getNombre());
			cSmt.setString("apellidos", empleado.getApellidos());
			cSmt.setString("dni", empleado.getDNI());
			cSmt.setDate("fNacimiento", new java.sql.Date(empleado.getfNacimiento().getTime()));
			cSmt.setDate("fContratacion", new java.sql.Date(empleado.getfContratacion().getTime()));
			cSmt.setString("localidad", empleado.getLocalidad());
			cSmt.setString("direccion", empleado.getDireccion());
			cSmt.setInt("cp", empleado.getCP());
			cSmt.setInt("cc", empleado.getCC());
			cSmt.setInt("nss", empleado.getNSS());
			cSmt.setInt("codDepartamento", empleado.getDepartamento().getCodigo());

			cSmt.executeUpdate();
			emple = empleado;

		} catch (SQLException e) {
			emple = getByID(empleado.getCodigo());
			LOG.fatal(e.getMessage());
		} finally {
			myconexion.desconectar();
		}
		return emple;
	}

	@Override
	public Empleado getByID(int codigo) {

		String sql = "{call getByIDEmpleado(?)}";

		myconexion.conectar();
		Connection conexion = myconexion.getConexion();
		Empleado empleado = null;
		try {
			PreparedStatement pSmt = conexion.prepareStatement(sql);
			ResultSet rs = pSmt.executeQuery();
			while (rs.next()) {
				empleado = parseEmpleado(rs);
			}
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			myconexion.desconectar();
		}

		return empleado;
	}

	private Empleado parseEmpleado(ResultSet rs) {
		Empleado empleado = null;
		empleado = new Empleado();
		try {
			empleado.setCodigo(rs.getInt("codEmpleado"));
			empleado.setCP(rs.getInt("cp"));
			// empleado.setDepartamento(Util.parseDepartamento(String.valueOf(rs.getInt("codDepartamento"))));
			empleado.setNSS(rs.getInt("nss"));
			LOG.trace(rs.getInt("codEmpleado"));
			LOG.trace(rs.getInt("cc"));
			LOG.trace(rs.getInt("cp"));
			LOG.trace(rs.getInt("nss"));
			LOG.trace(rs.getString("nombre"));
			LOG.trace(rs.getString("apellidos"));
			LOG.trace(rs.getString("direccion"));
			LOG.trace(rs.getString("dni"));
			LOG.trace(rs.getString("localidad"));
			LOG.trace(rs.getDate("fNacimiento"));
			LOG.trace(rs.getDate("fcontratacion"));
			empleado.setCC(rs.getInt("cc"));
			empleado.setNombre(rs.getString("nombre"));
			empleado.setApellidos(rs.getString("apellidos"));
			empleado.setDireccion(rs.getString("direccion"));
			empleado.setDNI(rs.getString("dni"));
			empleado.setLocalidad(rs.getString("localidad"));
			empleado.setfNacimiento(rs.getDate("fNacimiento"));
			empleado.setfContratacion(rs.getDate("fContratacion"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.fatal(e.getMessage());
		}

		return empleado;
	}

	@Override
	public Empleado insert(Empleado empleado) {
		String sql = "{call insertEmpleado(?,?,?,?,?,?,?,?,?,?,?,?)}";
		Empleado emple = null;

		Connection conection = myconexion.getConexion();

		try {
			CallableStatement cSmt = conection.prepareCall(sql);

			cSmt.setString("nombre", empleado.getNombre());
			cSmt.setString("apellidos", empleado.getApellidos());
			cSmt.setString("dni", empleado.getDNI());
			cSmt.setDate("fNacimiento", new java.sql.Date(empleado.getfNacimiento().getTime()));
			cSmt.setDate("fContratacion", new java.sql.Date(empleado.getfContratacion().getTime()));
			cSmt.setString("localidad", empleado.getLocalidad());
			cSmt.setString("direccion", empleado.getDireccion());
			cSmt.setInt("cp", empleado.getCP());
			cSmt.setInt("cc", empleado.getCC());
			cSmt.setInt("nss", empleado.getNSS());
			cSmt.setInt("codDepartamento", empleado.getDepartamento().getCodigo());
			cSmt.executeUpdate();
			empleado.setCodigo(cSmt.getInt("codEmpleado"));
			emple = empleado;

		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			myconexion.desconectar();
		}
		return emple;
	}

	@Override
	public void delete(int codigo) {
		String sql = "{call deleteEmpleado(?)}";

		Connection conection = myconexion.getConexion();

		try {

			CallableStatement cSmt = conection.prepareCall(sql);
			cSmt.setInt("codEmpleado", codigo);
			cSmt.executeUpdate();
			// int nFilas = cSmt.executeUpdate();

		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			myconexion.desconectar();
		}
	}

	@Override
	public List<Empleado> getAll() {
		List<Empleado> empleados = null;
		String sql = "{call getAllEmpleado()}";

		Connection conection = myconexion.getConexion();
		Empleado empleado = null;
		try {
			CallableStatement cSmt = conection.prepareCall(sql);
			ResultSet rs = cSmt.executeQuery();
			empleados = new ArrayList<Empleado>();
			while (rs.next()) {
				empleado = parseEmpleado(rs);
				empleados.add(empleado);
			}
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			myconexion.desconectar();
		}

		return empleados;
	}

}
