/**
 * 
 */
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
import com.ipartek.formacion.pojo.Empleado;

/**
 * @author Curso
 *
 */
public class EmpleadoDAOImp implements EmpleadoDAO {

	private static final Logger LOG=Logger.getLogger(EmpleadoDAOImp.class);
	private ConexionDB dbConnection;
	private static EmpleadoDAOImp INSTANCE;
	
	
	/**
	 * 
	 */
	private EmpleadoDAOImp() {
		dbConnection=ConexionDBImp.getInstance();
	}
	
	private synchronized static void createInstance(){
		if(INSTANCE==null){
			INSTANCE=new EmpleadoDAOImp();
		}
	}
	
	public static EmpleadoDAOImp getInstance(){
		if(INSTANCE==null){
			createInstance();
		}
		
		
		return INSTANCE;
	}

	@Override
	public Empleado getById(int codigo) {
		Empleado emp=new Empleado();
		String sql="{call getEmpleadoById(?)}";
		Connection conexion=dbConnection.getConexion();
		try {
			PreparedStatement pStat=conexion.prepareStatement(sql);
			ResultSet rS=pStat.executeQuery();
			while (rS.next()) {
				emp=parseEmpleado(rS);
				
			}
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		}finally {
			dbConnection.desconectar();
		}
		
		return emp;
	}

	@Override
	public Empleado updateEmpleado(Empleado emp) {
		Empleado aux=null;
		String sql="{call updateEmpleado(?,?,?,?,?,?,?,?,?,?,?,?)}";
		Connection conexion=dbConnection.getConexion();
		try {
			CallableStatement cStat=conexion.prepareCall(sql);
			cStat.setInt("codEmp", emp.getCodEmp());
			cStat.setString("nombreEmp", emp.getNombreEmp());
			cStat.setString("apellidosEmp", emp.getApellidosEmp());
			cStat.setString("dni_nie", emp.getDni_nie());
			cStat.setString("n_ss", emp.getN_ss());
			cStat.setString("cCorriente", emp.getcCorriente());
			cStat.setString("direccion", emp.getDireccion());
			cStat.setString("localidad", emp.getLocalidad());	
			cStat.setInt("cPostal", emp.getcPostal());
			cStat.setDate("fNacimiento", new java.sql.Date(emp.getfNacimiento().getTime()));
			cStat.setDate("fContratacion", new java.sql.Date(emp.getfContratacion().getTime()));
			cStat.setInt("dptoEmp", emp.getDptoEmp().getCodDpto());
			
			cStat.executeUpdate();
			aux=emp;
			
			
		} catch (SQLException e) {
			aux=getById(emp.getCodEmp());
			LOG.fatal(e.getMessage());
		}finally{
			dbConnection.desconectar();
		}
		
		return aux;
	}

	@Override
	public void deleteEmpleado(int codigo) {
		String sql="{call deleteAlumno(?)}";
		Connection conexion=dbConnection.getConexion();
		try {
			CallableStatement cStat=conexion.prepareCall(sql);
			cStat.setInt("codigo", codigo);
			cStat.executeUpdate();
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		}finally{
			dbConnection.desconectar();
		}
		
	}

	@Override
	public Empleado createEmpleado(Empleado emp) {
		Empleado aux=null;
		String sql="{call insertEmpleado(?,?,?,?,?,?,?,?,?,?,?,?)}";
		Connection conexion=dbConnection.getConexion();
		try {
			CallableStatement cStat=conexion.prepareCall(sql);
			cStat.setInt("codEmp", emp.getCodEmp());
			cStat.setString("nombreEmp", emp.getNombreEmp());
			cStat.setString("apellidosEmp", emp.getApellidosEmp());
			cStat.setString("dni_nie", emp.getDni_nie());
			cStat.setString("n_ss", emp.getN_ss());
			cStat.setString("cCorriente", emp.getcCorriente());
			cStat.setString("direccion", emp.getDireccion());
			cStat.setString("localidad", emp.getLocalidad());	
			cStat.setInt("cPostal", emp.getcPostal());
			cStat.setDate("fNacimiento", new java.sql.Date(emp.getfNacimiento().getTime()));
			cStat.setDate("fContratacion", new java.sql.Date(emp.getfContratacion().getTime()));
			cStat.setInt("dptoEmp", emp.getDptoEmp().getCodDpto());
			
			cStat.executeUpdate();
			aux=emp;
			aux.setCodEmp(cStat.getInt("codEmp"));
			
			
		} catch (SQLException e) {
			aux=getById(emp.getCodEmp());
			LOG.fatal(e.getMessage());
		}finally{
			dbConnection.desconectar();
		}
		
		return aux;
	}

	@Override
	public List<Empleado> getAll() {
		List <Empleado>lEmpleados=new ArrayList<Empleado>();
		String sql="{call getAllEmpleado()}";
		Connection conexion=dbConnection.getConexion();
		try {
			CallableStatement cStat=conexion.prepareCall(sql);
			ResultSet rS=cStat.executeQuery();
			while (rS.next()) {
				lEmpleados.add(parseEmpleado(rS));
				
			}
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		}finally{
			dbConnection.desconectar();
		}
		
		return lEmpleados;
	}

	private Empleado parseEmpleado(ResultSet rS) {
		Empleado aux=new Empleado();
		Departamento dep=new Departamento();
		DepartamentoDAOImp dDao=DepartamentoDAOImp.getInstance();
		try {
			aux.setCodEmp(rS.getInt("codEmp"));
			aux.setNombreEmp(rS.getString("nombreEmp"));
			aux.setApellidosEmp(rS.getString("apellidosEmp"));
			aux.setDni_nie(rS.getString("dni_nie"));
			aux.setN_ss(rS.getString("n_ss"));
			aux.setcCorriente(rS.getString("cCorriente"));
			aux.setDireccion(rS.getString("direccion"));
			aux.setLocalidad(rS.getString("localidad"));
			aux.setcPostal(rS.getInt("cPostal"));
			aux.setfNacimiento(rS.getDate("fNacimiento"));
			aux.setfContratacion(rS.getDate("fContratacion"));
			dep=dDao.getById(rS.getInt("dptoEmp"));
			aux.setDptoEmp(dep);
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		}
		return aux;
	}

	@Override
	public Empleado trasladarEmpleado(Empleado emp, int codigo) {
		Empleado aux=null;
		String sql="{call trasladoEmpleado(?,?)}";
		Connection conexion=dbConnection.getConexion();
		Departamento dep=new Departamento();
		DepartamentoDAOImp dDao=DepartamentoDAOImp.getInstance();
		try {
			CallableStatement cStat=conexion.prepareCall(sql);
			cStat.setInt("codigo", emp.getCodEmp());
			cStat.setInt("dpto", codigo);
			cStat.executeUpdate();
			dep=dDao.getById(codigo);
			aux=emp;
			aux.setDptoEmp(dep);
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		}finally {
			dbConnection.desconectar();
		}

		return aux;
	}
	
	

}
