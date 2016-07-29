package com.ipartek.formacion.dbms.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.pojo.Departamento;
import com.ipartek.formacion.pojo.Empleado;
public class EmpleadoDAOImp implements EmpleadoDAO {
	
	private final static Logger LOG = Logger.getLogger(EmpleadoDAOImp.class);
	private static EmpleadoDAOImp INSTANCE = null;
	private static ConexionDB myConexion;
	private Connection conexion;

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

	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	@Override
	public Empleado getById(int codigo) {
		Empleado empleado = null;
		String sql = "{call getAlumnoById(?)}";
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codigo", codigo);
			ResultSet rs = cSmt.executeQuery();
			while (rs.next()) {
				empleado = parseEmpleado(rs);
			}
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		} finally {
			myConexion.desconectar();
		}

		return empleado;
	}
	
	
	private Empleado parseEmpleado(ResultSet rs) {
		Empleado empleado = null;
		empleado = new Empleado();
		try {
			empleado.setCodigo(rs.getInt("codEmpleado"));
			empleado.setNombre(rs.getString("nAlumno"));
			empleado.setApellidos(rs.getString("apellidos"));
			empleado.setDni(rs.getString("dni"));
			empleado.setfNacimiento(new java.util.Date(rs.getDate("fNacimiento")
					.getTime()));
			empleado.setfContratación(new java.util.Date(rs.getDate("fContratacion").getTime()));
			empleado.setnSS(rs.getString("nss"));
			empleado.setCc(rs.getInt("cc"));
			empleado.setDireccion(rs.getString("direccion"));
			empleado.setLocalidad(rs.getString("localidad"));
			empleado.setCodigoPostal(rs.getInt("codigopostal"));
			empleado.setTipoDepartamento(rs.getInt("tipodepartamento"));
			
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		} 
		return empleado;
	}

	@Override
	public Empleado update(Empleado empleado) {
		Empleado empl = null;
		String sql = "{call updateEmpleado(?,?,?,?,?,?,?,?,?,?,?)}";
		LOG.trace(empleado.toString());
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codigo", empleado.getCodigo());
			cSmt.setString("nombre", empleado.getNombre());
			cSmt.setString("apellidos", empleado.getApellidos());
			cSmt.setString("dni", empleado.getDni());
			cSmt.setDate("fNacimiento", new Date(empleado.getfNacimiento().getTime()));
			cSmt.setDate("fContratacion", new Date(empleado.getfContratación().getTime()));
			cSmt.setString("nss", empleado.getnSS());
			cSmt.setInt("cc", empleado.getCc());
			cSmt.setString("direccion", empleado.getDireccion());
			cSmt.setString("localidad", empleado.getLocalidad());
			cSmt.setInt("codigopostal", empleado.getCodigoPostal());
			
			Departamento departamento = empleado.getTipoDepartamento();			
			cSmt.setInt("tipodepartamento", departamento.getCodigo());
			cSmt.executeUpdate();
			empl = empleado;
		} catch (SQLException e) {
			empl = getById(empleado.getCodigo());
			LOG.fatal(e.getMessage() + " -- Error al actualizar");
		} finally {
			myConexion.desconectar();
		}
		return empl;
	}

	@Override
	public Empleado create(Empleado empleado) {
		Empleado empl = null;
		String sql = "{call insertEmpleado(?,?,?,?,?,?,?,?,?,?,?,?)}";

		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setString("nombre", empleado.getNombre());
			cSmt.setString("apellidos", empleado.getApellidos());
			cSmt.setString("dni", empleado.getDni());
			cSmt.setDate("fNacimiento", new Date(empleado.getfNacimiento().getTime()));
			cSmt.setDate("fContratacion", new Date(empleado.getfContratación().getTime()));
			cSmt.setString("nss", empleado.getnSS());
			cSmt.setInt("cc", empleado.getCc());
			cSmt.setString("direccion", empleado.getDireccion());
			cSmt.setString("localidad", empleado.getLocalidad());
			cSmt.setInt("codigopostal", empleado.getCodigoPostal());
			
			Departamento departamento = empleado.getTipoDepartamento();			
			cSmt.setInt("tipodepartamento", departamento.getCodigo());
			
			cSmt.executeUpdate();
			empl = empleado;
			empl.setCodigo(cSmt.getInt("codEmpleado"));
		} catch (SQLException e) {
			LOG.fatal(e.getMessage() + " -- Error al insertar empleado");
		} finally {
			myConexion.desconectar();
		}
		return empl;
	}

	@Override
	public void delete(int codigo) {
		String sql = "{call deleteEmpleado(?)}";
		conexion = myConexion.getConexion();
		try {
			CallableStatement cSmt = conexion.prepareCall(sql);
			
			cSmt.setInt("codigo", codigo);

			cSmt.executeUpdate();

		} catch (SQLException e) {
			LOG.fatal(e.getMessage() + " -- Error al borrar Empleado");
		} finally {
			myConexion.desconectar();
		}
	}

	@Override
	public List<Empleado> getAll() {
		List<Empleado> empleados = null;
		String sql = "{call getAllEmpleado()}";
		conexion = myConexion.getConexion();
		try {
			Empleado empleado = null;
			CallableStatement cSmt = conexion.prepareCall(sql);
			ResultSet rs = cSmt.executeQuery();
			empleados = new ArrayList<Empleado>();
			while (rs.next()) {
				empleado = parseEmpleado(rs);
				empleados.add(empleado);
			}
		} catch (SQLException e) {
			LOG.error(e.getMessage() + " -- Error al listar Empleados");
		} finally {
			myConexion.desconectar();
		}
		return empleados;
	}
		

}
