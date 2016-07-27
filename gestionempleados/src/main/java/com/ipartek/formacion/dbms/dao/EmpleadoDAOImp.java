package com.ipartek.formacion.dbms.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDBImp;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleado update(Empleado empleado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleado insert(Empleado empleado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int codigo) {
		// TODO Auto-generated method stub

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
		} catch (SQLException e) {
			LOG.fatal("Error: " + e.getMessage());
		} 
		
		return empleado;
	}
}
