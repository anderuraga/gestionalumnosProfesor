package com.ipartek.formacion.empleado.ProyectoGestionEmpleado.dbms.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.empleado.ProyectoGestionEmpleado.dbms.ConexionDB;
import com.ipartek.formacion.empleado.ProyectoGestionEmpleado.dbms.ConexionDBImp;
import com.ipartek.formacion.empleado.ProyectoGestionEmpleado.pojo.Empleado;

public class EmpleadoDAOImp implements EmpleadoDAO{
	
	private final static Logger LOG = Logger.getLogger(EmpleadoDAOImp.class);
	 
	private static EmpleadoDAOImp INSTANCE = null;
	
	private static ConexionDB myConexion;
	
	private Connection conexion;

	public EmpleadoDAOImp() {
		myConexion = ConexionDBImp.getInstance();
	}

	@Override
	public Empleado createEmpleadoDAO(Empleado emple) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleado getByIdDAO(int id) {
		Empleado empleado = null;
		String sql = "{call getIDEmpleado(?)}";
		conexion = myConexion.getConexion();
		try {
			
			CallableStatement cSmt = conexion.prepareCall(sql);
			cSmt.setInt("id", id);
			ResultSet rs = cSmt.executeQuery();
			while(rs.next())
			{
				empleado = parseEmpleado(rs);
			}
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		finally {
			myConexion.desconectar();
		}
		return empleado;
	}

	@Override
	public void deleteDAO(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Empleado> getAllDAO() {

		List<Empleado> empleados = null;
		String sql = "{call getALLEmpleado()}";
		conexion = myConexion.getConexion();
		try
		{
			Empleado empleado = null;
			CallableStatement cSmt = conexion.prepareCall(sql);
			ResultSet rs = cSmt.executeQuery();
			empleados = new ArrayList<Empleado>();
			while(rs.next())
			{
				empleado = parseListaEmpleado(rs);
				empleados.add(empleado);
			}
		} catch (SQLException e){
			LOG.error(e.getMessage());
		} finally {
			myConexion.desconectar();
		}
		
		return empleados;
	}

	@Override
	public Empleado updateDAO(Empleado emple) {
		// TODO Auto-generated method stub
		return null;
	}
	
	 private Empleado parseEmpleado(ResultSet rs) {
		 Empleado empleado = null;
		    empleado = new Empleado();
		    try {
		    	empleado.setCodigo(rs.getInt("codigo_empleado"));
		    	empleado.setNombre(rs.getString("nEmpleado"));
		    	empleado.setApellidos(rs.getString("apellidos"));
		    	empleado.setNumeroSS(rs.getString("numeroSeguridadSocial"));
		    	empleado.setCuentaCorriente(rs.getString("CuentaCorriente"));
		    	empleado.setDireccion(rs.getString("direccion"));
		    	empleado.setLocalidad(rs.getString("localidad"));
		    	empleado.setCodigoPostal(rs.getInt("codigoPostal"));
		    	empleado.setDni(rs.getString("dni"));
		    	empleado.setFechaNacimiento(new java.util.Date(rs.getDate("fechaNacimiento").getTime()) );
		    	empleado.setFechaContratacion(new java.util.Date(rs.getDate("fechaContratacion").getTime()) );
		    	empleado.setDepartamento(rs.getString("nDepartamento"));
		    } catch (SQLException e) {
		      LOG.error(e.getMessage());
		    }
		    return empleado;
		}
	 private Empleado parseListaEmpleado(ResultSet rs){
		 Empleado empleado = null;
		    empleado = new Empleado();
		    try {
		    	empleado.setCodigo(rs.getInt("codigo_empleado"));
		    	empleado.setNombre(rs.getString("nombre"));
		    	empleado.setApellidos(rs.getString("apellidos"));
		    } catch (SQLException e) {
		      LOG.error(e.getMessage());
		    }
		    return empleado;
	 }
	
	/**
	 * METODO SINGLETON
	 */
	
	private synchronized static void createInstance() {
	    if (INSTANCE == null) {
	      INSTANCE = new EmpleadoDAOImp();
	    }
	}
	
	public static EmpleadoDAOImp getInstance() {
	    if (INSTANCE == null) {
	      createInstance();
	    }
	    return INSTANCE;
	}

	 protected Object clone() throws CloneNotSupportedException {
		    LOG.error("Error al clonar");
		    throw new CloneNotSupportedException();
		}

}
