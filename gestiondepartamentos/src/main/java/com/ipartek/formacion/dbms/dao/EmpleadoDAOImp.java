package com.ipartek.formacion.dbms.dao;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.pojo.Empleado;
import com.ipartek.formacion.service.Util;
public class EmpleadoDAOImp implements EmpleadoDAO {
	private static final Logger		LOG			= Logger.getLogger(EmpleadoDAOImp.class);
	private static EmpleadoDAOImp	INSTANCE	= null;
	private ConexionDB				myConexion	= null;
	// INSERTAR EMPLEADO
	public Empleado CreateEmpleado(Empleado empleado) {
		Empleado emple = null;
		String sql = "{call InsertEmpleado(?,?,?,?,?,?,?,?,?,?,?)}";
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setString("nombre", empleado.getNombre());
			cSmt.setString("apellido", empleado.getApellido());
			cSmt.setDate("date_nacimiento", new Date(empleado.getDate_nacimiento().getTime()));
			cSmt.setDate("date_contratacion", new Date(empleado.getDate_contratacion().getTime()));
			cSmt.setString("num_seg_soc", empleado.getNum_seg_soc());
			cSmt.setString("num_dni", empleado.getNum_dni());
			cSmt.setString("cuenta_corriente", empleado.getCuenta_corriente());
			cSmt.setString("direccion", empleado.getDireccion());
			cSmt.setString("localidad", empleado.getLocalidad());
			cSmt.setInt("codigo_postal", empleado.getCodigo_postal());
			cSmt.setInt("pertenece_departamento", empleado.getDepartamento_empleado().getCodigo());
			cSmt.executeUpdate();
			emple = empleado;
			emple.setCodigo(cSmt.getInt("codigo"));
		}
		catch (SQLException e) {
			LOG.fatal(e.getMessage() + " -- Error al insertar empleado");
		}
		finally {
			myConexion.desconectar();
		}
		return emple;
	}
	// FIN INSERTAR EMPLEADO
	// GETALL EMPLEADO
	public List<Empleado> getAll() {
		List<Empleado> empleados = null;
		String sql = "{call GetAllEmpleado()}";
		try {
			Empleado empleado = null;
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			ResultSet rs = cSmt.executeQuery();
			empleados = new ArrayList<Empleado>();
			while (rs.next()) {
				empleado = parseEmpleado(rs);
				empleados.add(empleado);
			}
		}
		catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		finally {
			myConexion.desconectar();
		}
		return empleados;
	}
	// FIN GETALL EMPLEADO
	public Empleado UpdateEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		return null;
	}
	public void DeleteEmpleado(int empleado) {
		// TODO Auto-generated method stub
	}
	public Empleado getById(int empleado) {
		// TODO Auto-generated method stub
		return null;
	}
	private Empleado parseEmpleado(ResultSet rs) {
		Empleado empleado = null;
		empleado = new Empleado();
		try {
			empleado.setNombre(rs.getString("nombre"));
			empleado.setDate_nacimiento(rs.getDate("date_nacimiento"));
			empleado.setDate_contratacion(rs.getDate("date_contratacion"));
			empleado.setNum_seg_soc(rs.getString("num_seg_soc"));
			empleado.setNum_dni(rs.getString("num_dni"));
			empleado.setCuenta_corriente(rs.getString("cuenta_corriente"));
			empleado.setDireccion(rs.getString("direccion"));
			empleado.setLocalidad(rs.getString("localidad"));
			empleado.setCodigo_postal(rs.getInt("codigo_postal"));
			empleado.setDepartamento_empleado(Util.parseDepartamento("pertenece_departamento"));
		}
		catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		return empleado;
	}
}
