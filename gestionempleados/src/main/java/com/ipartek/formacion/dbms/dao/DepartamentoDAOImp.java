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

public class DepartamentoDAOImp implements DepartamentoDAO{
	private static final Logger LOG = Logger.getLogger(DepartamentoDAOImp.class);
	private static ConexionDB myConexion;
	private Connection conexion;
	private static DepartamentoDAOImp INSTANCE=null;

	
	private DepartamentoDAOImp(){
		myConexion = ConexionDBImp.getInstance(); 
		
	}
	
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DepartamentoDAOImp();
		}
	}

	public static DepartamentoDAOImp getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}
	
	@Override
	public Departamento create(Departamento departamento) {
		Departamento dep = null;
		String sql =  "{call insertDepartamento(?,?,?)}";
		
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setString("nombre", departamento.getNombre());
			cSmt.setString("descrip", departamento.getDescripcion());
			
			cSmt.executeUpdate();
			dep = departamento;
			dep.setCodigo(cSmt.getInt("codigo"));
			
		} catch (SQLException e) {
			dep = getById(departamento.getCodigo());
			LOG.fatal(e.getMessage());
			
		}finally{
			myConexion.desconectar();
		}
		
		return dep;
	}

	@Override
	public Departamento update(Departamento departamento) {
		Departamento dep = null;
		String sql = "{call updateDepartamento(?,?,?)}";
		
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codigo", departamento.getCodigo());
			cSmt.setString("nombre", departamento.getNombre());
			cSmt.setString("descripcion", departamento.getDescripcion());
			
			cSmt.executeUpdate();
			dep = departamento;
			
		} catch (SQLException e) {
			dep = getById(departamento.getCodigo());
			LOG.fatal(e.getMessage());
			
		}finally{
			myConexion.desconectar();
		}
		
		return dep;
	}

	@Override
	public void delete(int codigo) {
		String sql = "{call deleteDepartamento(?)}";
		
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codDep", codigo); 
			cSmt.executeUpdate();
			
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		}finally{
			myConexion.desconectar();
		}
		
	}

	@Override
	public Departamento getById(int codigo) {
		Departamento dep = null;
		String sql = "{call getByIdDepartamento}";
		
		myConexion.conectar();
		conexion = myConexion.getConexion();
		try {
			PreparedStatement pSmt =  conexion.prepareStatement(sql);
			ResultSet rs = pSmt.executeQuery();
			
			while(rs.next()){
				dep = parseDepartamento(rs);
			}
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		}finally{
			myConexion.desconectar();
		}
		
		return dep;
	}


	@Override
	public List<Departamento> getAll() {
		List<Departamento> departamentos = null;
		String sql = "{call getAllAlumno()}"; 
		
		try {
			Departamento emp = null;
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			ResultSet rs = cSmt.executeQuery();
			departamentos = new ArrayList<Departamento>();
			while(rs.next()){
				emp = parseDepartamento(rs);
				departamentos.add(emp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			myConexion.desconectar();
		}
		return departamentos;
	}
	
	private Departamento parseDepartamento(ResultSet rs) {
		Departamento dep = null;
		dep = new Departamento();
		
		try {
			dep.setCodigo(rs.getInt("codigo"));
			dep.setNombre(rs.getString("nombre"));
			dep.setDescripcion(rs.getString("descripcion"));
			
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		}
		
		return dep;
	}

}
