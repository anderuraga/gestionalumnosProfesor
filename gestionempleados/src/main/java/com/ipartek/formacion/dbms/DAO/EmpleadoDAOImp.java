package com.ipartek.formacion.dbms.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		String sql = "{call updateEmpleado(?,?,?,?,?,?,?,?)}";
		Empleado emple = null;

		Connection conection = myconexion.getConexion();

		try {
			CallableStatement cSmt = conection.prepareCall(sql);
			cSmt.setInt("departamento", empleado.getDepartamento());

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

		String sql = "{call getByIDModulo(?)}";

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
			empleado.setCodigo(rs.getInt("codigo"));
			empleado.setCP(rs.getInt("cp"));
			empleado.setDepartamento(rs.getInt("departamento"));
			empleado.setDepartamento(rs.getInt("nss"));
			empleado.setDepartamento(rs.getInt("cc"));
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

}
