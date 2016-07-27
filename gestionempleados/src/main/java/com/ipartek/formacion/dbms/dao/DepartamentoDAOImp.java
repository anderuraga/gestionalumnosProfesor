/**
 * 
 */
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
import com.ipartek.formacion.pojo.Departamento;


/**
 * @author Curso
 *
 */
public class DepartamentoDAOImp implements DepartamentoDAO {
	
	
	private final static Logger LOG = Logger.getLogger(DepartamentoDAOImp.class);
	private static DepartamentoDAOImp INSTANCE = null;
	private static ConexionDB myConexion;
	private Connection conexion;

	private DepartamentoDAOImp() {
		myConexion = ConexionDBImp.getInstance();
	}

	public static DepartamentoDAOImp getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DepartamentoDAOImp();
		}
	}

	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	/* (non-Javadoc)
	 * @see com.ipartek.formacion.dbms.dao.DepartamentoDAO#getById(int)
	 */
	@Override
	public Departamento getById(int codigo) {
		Departamento departamento = null;
		String sql = "{call getDepartamentoById(?)}";
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codigo", codigo);
			ResultSet rs = cSmt.executeQuery();
			while (rs.next()) {
				departamento = parseDepartamento(rs);
			}
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		} finally {
			myConexion.desconectar();
		}

		return departamento;
	}

	/* (non-Javadoc)
	 * @see com.ipartek.formacion.dbms.dao.DepartamentoDAO#update(com.ipartek.formacion.pojo.Departamento)
	 */
	@Override
	public Departamento update(Departamento departamento) {
		Departamento departm = null;
		String sql = "{call updateDepartamento(?,?,?,?,?,?,?,?)}";
		LOG.trace(departamento.toString());
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codigo", departamento.getCodigo());
			cSmt.setString("nombre", departamento.getNombre());
			cSmt.setString("descripcion", departamento.getDescripcion());
			
			cSmt.executeUpdate();
			departm = departamento;
		} catch (SQLException e) {
			departm = getById(departamento.getCodigo());
			LOG.fatal(e.getMessage() + " -- Error al actualizar");
		} finally {
			myConexion.desconectar();
		}
		return departm;
	}

	/* (non-Javadoc)
	 * @see com.ipartek.formacion.dbms.dao.DepartamentoDAO#create(com.ipartek.formacion.pojo.Departamento)
	 */
	@Override
	public Departamento create(Departamento departamento) {
		Departamento departm = null;
		String sql = "{call insertDepartamento(?,?,?,?,?,?,?,?)}";

		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setString("nombre", departamento.getNombre());
			cSmt.setString("descripcion", departamento.getDescripcion());
					
			cSmt.executeUpdate();
			departm = departamento;
			departm.setCodigo(cSmt.getInt("codDepartamento"));
		} catch (SQLException e) {
			LOG.fatal(e.getMessage() + " -- Error al insertar departamento");
		} finally {
			myConexion.desconectar();
		}
		return departm;
	}

	/* (non-Javadoc)
	 * @see com.ipartek.formacion.dbms.dao.DepartamentoDAO#delete(int)
	 */
	@Override
	public void delete(int codigo) {
		String sql = "{call deleteDepartamento(?)}";
		conexion = myConexion.getConexion();
		try {
			CallableStatement cSmt = conexion.prepareCall(sql);
			
			cSmt.setInt("codigo", codigo);

			cSmt.executeUpdate();

		} catch (SQLException e) {
			LOG.fatal(e.getMessage() + " -- Error al borrar Departamento");
		} finally {
			myConexion.desconectar();
		}



	}

	/* (non-Javadoc)
	 * @see com.ipartek.formacion.dbms.dao.DepartamentoDAO#getAll()
	 */
	@Override
	public List<Departamento> getAll() {
		List<Departamento> departamentos = null;
		String sql = "{call getAllDepartamento()}";
		conexion = myConexion.getConexion();
		try {
			Departamento departamento = null;
			CallableStatement cSmt = conexion.prepareCall(sql);
			ResultSet rs = cSmt.executeQuery();
			departamentos = new ArrayList<Departamento>();
			while (rs.next()) {
				departamento = parseDepartamento(rs);
				departamentos.add(departamento);
			}
		} catch (SQLException e) {
			LOG.error(e.getMessage() + " -- Error al listar Departamentos");
		} finally {
			myConexion.desconectar();
		}
		return departamentos;
	}
	
	
	private Departamento parseDepartamento(ResultSet rs) {
		Departamento departamento = null;
		departamento = new Departamento();
		try {
			departamento.setCodigo(rs.getInt("codDepartamento"));
			departamento.setNombre(rs.getString("nDepartamento"));
			departamento.setDescripcion(rs.getString("descripcion"));
			
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		} 
		return departamento;
	}

}
