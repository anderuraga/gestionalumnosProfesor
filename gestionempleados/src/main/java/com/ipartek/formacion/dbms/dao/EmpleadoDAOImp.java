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

public class EmpleadoDAOImp implements EmpleadoDAO{
	private static final Logger LOG = Logger.getLogger(EmpleadoDAOImp.class);
	private static ConexionDB myConexion;
	private Connection conexion;
	private static EmpleadoDAOImp INSTANCE=null;

	private EmpleadoDAOImp(){
		myConexion = ConexionDBImp.getInstance(); 
		
	}
	
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
	
	@Override
	public Empleado create(Empleado empleado) {
		Empleado emp = null;
		String sql = "{call insertEmpleado(?,?,?,?,?,?,?,?,?,?,?,?)}"; 
		
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setString("nombre", empleado.getNombre());
			cSmt.setString("apellidos", empleado.getApellidos());
			cSmt.setString("dni", empleado.getDni());
			cSmt.setString("cc", empleado.getCc());
			cSmt.setString("cp", empleado.getCp());
			cSmt.setString("loc", empleado.getLocalidad());
			cSmt.setString("dir", empleado.getDireccion());
			cSmt.setDate("fContrato",new java.sql.Date(empleado.getfContrato().getTime()));
			cSmt.setDate("fNacim",new java.sql.Date(empleado.getfNacimiento().getTime()));
			
			cSmt.executeUpdate();
			emp = empleado;
			emp.setCodigo(cSmt.getInt("codigo")); 
			
		} catch (SQLException e) {
			emp = getById(empleado.getCodigo());
			LOG.fatal(e.getMessage());
		}finally{
			myConexion.desconectar();
		}
		
		return emp;
	}

	@Override
	public Empleado update(Empleado empleado) {
		Empleado emp = null;
		String sql = "{call updateEmpleado(?,?,?,?,?,?,?,?,?,?,?,?)}"; 
		
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codigo", empleado.getCodigo());
			cSmt.setString("nombre", empleado.getNombre());
			cSmt.setString("apellidos", empleado.getApellidos());
			cSmt.setString("dni", empleado.getDni());
			cSmt.setString("cc", empleado.getCc());
			cSmt.setString("cp", empleado.getCp());
			cSmt.setString("dir", empleado.getDireccion());
			cSmt.setString("loc", empleado.getLocalidad());
			cSmt.setDate("fNacimiento", new java.sql.Date(empleado.getfNacimiento().getTime()));
			cSmt.setDate("fContrato", new java.sql.Date(empleado.getfContrato().getTime()));
			
			cSmt.executeUpdate();
			emp = empleado; 
		} catch (SQLException e) {
			emp = getById(empleado.getCodigo());
			LOG.fatal(e.getMessage());
		}finally{
			myConexion.desconectar();
		}
		
		return emp;
	}

	@Override
	public void delete(int codigo) {
		String sql = "{call deleteEmpleado(?)}"; 
		
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codEmp", codigo); 
			cSmt.executeUpdate();
			
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		}finally{
			myConexion.desconectar();
		}
		
	}

	@Override
	public Empleado getById(int codigo) {
		Empleado emp = null;
		String sql = "{call getByIdEmpleado(?)}"; 
		
		myConexion.conectar();
		conexion = myConexion.getConexion();
		try {
			PreparedStatement pSmt =  conexion.prepareStatement(sql);
			ResultSet rs = pSmt.executeQuery();
			while(rs.next()){
				emp = parseEmpleado(rs);
			}
			
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		}finally{
			myConexion.desconectar();
		}
		
		return emp;
	}

	@Override
	public List<Empleado> getAll() {
		List<Empleado> empleados = null;
		String sql = "{call getAllAlumno()}"; //llamamos al procedimiento almacenado en bbdd
		
		try {
			Empleado emp = null;
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			ResultSet rs = cSmt.executeQuery();
			empleados = new ArrayList<Empleado>();
			while(rs.next()){
				emp = parseEmpleado(rs);
				empleados.add(emp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			myConexion.desconectar();
		}
		
		
		return empleados;
	}
	
	private Empleado parseEmpleado(ResultSet rs) {
		Empleado emp = null;
		emp = new Empleado();
		try {
			emp.setCodigo(rs.getInt("codigo"));
			emp.setNombre(rs.getString("nombre"));
			emp.setApellidos(rs.getString("apellidos"));
			emp.setDni(rs.getString("dni"));
			emp.setCc(rs.getString("cc"));
			emp.setCp(rs.getString("cp"));
			emp.setNumSS(rs.getString("numSS"));
			emp.setDireccion(rs.getString("direccion"));
			emp.setLocalidad(rs.getString("localidad"));
			emp.setfNacimiento(new java.util.Date(rs.getDate("fNacimiento").getTime()));
			emp.setfContrato(new java.util.Date(rs.getDate("fContrato").getTime()));
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		}
		
		
		return emp;
	}

}
