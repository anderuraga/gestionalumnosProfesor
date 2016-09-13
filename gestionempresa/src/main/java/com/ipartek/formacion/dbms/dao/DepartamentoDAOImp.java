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
import java.util.concurrent.Callable;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.pojo.Departamento;

/**
 * @author Curso
 *
 */
public class DepartamentoDAOImp implements DepartamentoDAO {

	private static final Logger LOG=Logger.getLogger(EmpleadoDAOImp.class);
	private ConexionDB dbConnection;
	private static DepartamentoDAOImp INSTANCE;
	
	/**
	 * 
	 */
	private DepartamentoDAOImp() {
		dbConnection=ConexionDBImp.getInstance();
	}
	private synchronized static void createInstance(){
		if(INSTANCE==null){
			INSTANCE=new DepartamentoDAOImp();
		}
	}
	
	public static DepartamentoDAOImp getInstance(){
		if(INSTANCE==null){
			createInstance();
		}
		
		
		return INSTANCE;
	}
	@Override
	public Departamento getById(int codigo) {
		Departamento dep=null;
		String sql="{call getDepartamentoById(?)}";
		Connection conexion=dbConnection.getConexion();
		try {
			PreparedStatement pStat=conexion.prepareStatement(sql);
			ResultSet rS=pStat.executeQuery();
			while (rS.next()) {
				dep=parseDpto(rS);
				
			}
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		}
		return dep;
	}
	private Departamento parseDpto(ResultSet rS) {
		Departamento dep=null;
		try {
			dep.setCodDpto(rS.getInt("codDpto"));
			dep.setNombreDpto(rS.getString("nombreDpto"));
			dep.setDescDpto(rS.getString("descDpto"));
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		}
		return dep;
	}
	@Override
	public Departamento updateDpto(Departamento dpto) {
		Departamento dep=null;
		String sql="{call updateDepartamento(?,?,?,?)}";
		Connection conexion=dbConnection.getConexion();
		try {
			CallableStatement cStat=conexion.prepareCall(sql);
			cStat.setInt("codDpto", dpto.getCodDpto());
			cStat.setString("nombreDpto", dpto.getNombreDpto());
			cStat.setString("descDpto", dpto.getDescDpto());
			cStat.executeUpdate();
			
			dep=dpto;
			
		} catch (SQLException e) {
			dep=getById(dpto.getCodDpto());
			LOG.fatal(e.getMessage());
		}finally {
			dbConnection.desconectar();
		}
		
		
		return dep;
	}
	@Override
	public void deleteDpto(int codigo) {
		String sql="{call deleteDepartamento(?)}";
		Connection conexion=dbConnection.getConexion();
		try {
			CallableStatement cStat=conexion.prepareCall(sql);
			cStat.setInt("codigo", codigo);
			cStat.executeUpdate();
		} catch (Exception e) {
			LOG.fatal(e.getMessage());
		}finally {
			dbConnection.desconectar();
		}
		
		
	}
	@Override
	public Departamento createDepartamento(Departamento dpto) {
		Departamento dep=null;
		String sql="{call insertDepartamento(?,?,?,?)}";
		Connection conexion=dbConnection.getConexion();
		try {
			CallableStatement cStat=conexion.prepareCall(sql);
			cStat.setInt("codDpto", dpto.getCodDpto());
			cStat.setString("nombreDpto", dpto.getNombreDpto());
			cStat.setString("descDpto", dpto.getDescDpto());
			cStat.executeUpdate();
			
			dep=dpto;
			dep.setCodDpto(cStat.getInt("codEmp"));
			
		} catch (SQLException e) {
			dep=getById(dpto.getCodDpto());
			LOG.fatal(e.getMessage());
		}finally {
			dbConnection.desconectar();
		}
		
		
		return dep;
	}
	@Override
	public List<Departamento> getAll() {
		List <Departamento>lDpto=new ArrayList<Departamento>();
		String sql="{call getAllDepartamento()}";
		Connection conexion=dbConnection.getConexion();
		try {
			CallableStatement cStat=conexion.prepareCall(sql);
			ResultSet rS=cStat.executeQuery();
			while (rS.next()) {
				lDpto.add(parseDpto(rS));				
			}
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		}finally {
			dbConnection.desconectar();
		}
		
		return lDpto;
	}

}
