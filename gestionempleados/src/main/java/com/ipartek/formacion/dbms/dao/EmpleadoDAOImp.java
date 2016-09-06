package com.ipartek.formacion.dbms.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.dbms.dao.exceptions.EmpleadoDAOImpException;
import com.ipartek.formacion.pojo.Empleado;

public class EmpleadoDAOImp implements EmpleadoDAO {

	private static final Logger LOG = Logger.getLogger(EmpleadoDAOImp.class);
	private ConexionDBImp myConexion;
	private static EmpleadoDAOImp INSTANCE = null;
	
	private EmpleadoDAOImp(){
		myConexion = ConexionDBImp.getInstance();
	}
	
	private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new EmpleadoDAOImp();
        }
    }

    public static EmpleadoDAOImp getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
	
	@Override
	public Empleado getById(int codigo) {
		
		Empleado empleado = null;
		String sql = "{call getEmpleadoById(?)}";
		Connection conexion = myConexion.getConexion();
		
		try {
			CallableStatement cSmt = conexion.prepareCall(sql);
			cSmt.setInt("codEmpleado", codigo);
			ResultSet rs = cSmt.executeQuery();
			
			while(rs.next()){
				empleado = parseEmpleado(rs);
			}
			
		} catch (SQLException e) {
			LOG.error("Error: "+ sql + e.getMessage());
		} finally{
			myConexion.desconectar();
		}
		
		return empleado;
	}

	@Override
	public Empleado update(Empleado empleado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleado insert(Empleado empleado) throws EmpleadoDAOImpException {
		throw new EmpleadoDAOImpException(EmpleadoDAOImpException.MSG_ERROR_EMPLEADO_INSERT, EmpleadoDAOImpException.CODIGO_ERROR_EMPLEADO_INSERT);
	}

	@Override
	public void delete(int codigo) {
		String sql = "{call deleteEmpleado(?)}";
		Connection conection = myConexion.getConexion();
		
		try {
			CallableStatement cSmt = conection.prepareCall(sql);
			cSmt.setInt("codEmpleado", codigo);
			cSmt.executeUpdate();
		} catch (SQLException e) {
			LOG.fatal("Error - SQLException: " + e.getMessage());
		} finally{
			myConexion.desconectar();
		}
	}

	@Override
	public List<Empleado> getAll() {
		List<Empleado> empleados = null;
		String sql = "{call getAllEmpleado()}";
		Connection conection = myConexion.getConexion();
		
		try {
			Empleado empleado = null;
			CallableStatement cSmt = conection.prepareCall(sql);
			ResultSet rs = cSmt.executeQuery();
			empleados = new ArrayList<Empleado>();
			
			while(rs.next()){
				empleado = parseEmpleado(rs);
				empleados.add(empleado);
			}
		} catch (NullPointerException e) {
			LOG.fatal("Error - NullPointerException: " + e.getMessage());
		} catch (SQLException e) {
			LOG.fatal("Error - SQLException: "+sql+" " + e.getMessage());
		} finally{
			myConexion.desconectar();
		}

		return empleados;
	}

	private Empleado parseEmpleado(ResultSet rs) {
		Empleado empleado = null;
		empleado = new Empleado();
		
		try {
			empleado.setCodigo(rs.getInt("codigo"));
			empleado.setCodigoDepartamento(rs.getInt("codigoDepartamento"));
			empleado.setNombre(rs.getString("nombre"));
			empleado.setApellidos(rs.getString("apellidos"));
			empleado.setDni(rs.getString("dni"));
			empleado.setFechaNacimiento(rs.getDate("fechaNacimiento"));
			empleado.setFechaContratacion(rs.getDate("fechaContratacion"));
			empleado.setNumeroSS(rs.getInt("numeroSS"));
			empleado.setCuentaCorriente(rs.getString("cuentaCorriente"));
			empleado.setDireccion(rs.getString("direccion"));
			empleado.setLocalidad(rs.getString("localidad"));
			empleado.setCodigoPostal(rs.getInt("codigoPostal"));
			/*
			System.out.println("Codigo: " + rs.getString("codigo"));
			System.out.println("Codigo Departamento: " + rs.getString("codigoDepartamento"));
			System.out.println("Nombre: " + rs.getString("nombre"));
			System.out.println("Apellidos: " + rs.getString("apellidos"));
			System.out.println("DNI: " + rs.getString("dni"));
			System.out.println("Fecha Nacimiento: " + rs.getString("fechaNacimiento"));
			System.out.println("Fecha Contratacion: " + rs.getString("fechaContratacion"));
			System.out.println("Numero Seguridad Social: " + rs.getString("numeroSS"));
			System.out.println("Cuenta Corriente: " + rs.getString("cuentaCorriente"));
			System.out.println("Direccion: " + rs.getString("direccion"));
			System.out.println("Localidad: " + rs.getString("localidad"));
			System.out.println("Codigo Postal: " + rs.getString("codigoPostal"));
			*/
		} catch (SQLException e) {
			LOG.fatal("Error: " + e.getMessage());
		} 
		LOG.trace(empleado.toString());
		return empleado;
	}
}
