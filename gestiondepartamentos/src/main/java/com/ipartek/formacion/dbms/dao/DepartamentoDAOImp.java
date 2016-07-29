package com.ipartek.formacion.dbms.dao;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.pojo.Departamento;
import com.ipartek.formacion.pojo.Empleado;
public class DepartamentoDAOImp implements DepartamentoDAO {
	private static final Logger			LOG			= Logger.getLogger(DepartamentoDAOImp.class);
	private static DepartamentoDAOImp	INSTANCE	= null;
	private ConexionDB					myConexion	= null;
	// INSERTAR DEPARTAMENTO
	public Departamento CreateDepartamento(Departamento departamento) {
		Departamento depar = null;
		String sql = "{call InsertDepartamento(?,?)}";
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setString("nombre", departamento.getNombre());
			cSmt.setString("descripcion", departamento.getDescripcion());
			cSmt.executeUpdate();
			depar = departamento;
			depar.setCodigo(cSmt.getInt("codigo"));
		}
		catch (SQLException e) {
			LOG.fatal(e.getMessage() + " -- Error al insertar departamento");
		}
		finally {
			myConexion.desconectar();
		}
		return depar;
	}
	// FIN INSERTAR DEPARTAMENTO
	// GETALL DEPARTAMENTO
	public List<Departamento> getAll() {
		List<Departamento> departamentos = null;
		String sql = "{call GetAllDepartamento()}";
		try {
			Departamento departamento = null;
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			ResultSet rs = cSmt.executeQuery();
			departamentos = new ArrayList<Departamento>();
			while (rs.next()) {
				departamento = parseDepartamento(rs);
				departamentos.add(departamento);
			}
		}
		catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		finally {
			myConexion.desconectar();
		}
		return departamentos;
	}
	// FIN GETALL DEPARTAMENTO
	// UPDATE DEPARTAMENTO
	public Departamento UpdateDepartamento(Departamento departamento) {
		Departamento departamento_temporal = null;
		String sql = "{call UpdateDepartamento(?,?,?)}";
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codigo", departamento.getCodigo());
			cSmt.setString("nombre", departamento.getNombre());
			cSmt.setString("descripcion", departamento.getDescripcion());
			cSmt.executeUpdate();
			departamento_temporal = departamento;
		}
		catch (SQLException e) {
			departamento_temporal = getById(departamento.getCodigo());
			LOG.fatal(e.getMessage() + " -- Error al actualizar");
		}
		finally {
			myConexion.desconectar();
		}
		return departamento_temporal;
	}
	// FIN UPDATE DEPARTAMENTO
	// DELETE DEPARTAMENTO
	public void DeleteDepartamento(int codigo) {
		String sql = "{call DeleteDepartamento(?)}";
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codigo", codigo);
			cSmt.executeUpdate();
		}
		catch (SQLException e) {
			LOG.fatal(e.getMessage() + " -- Error al borrar");
		}
		finally {
			myConexion.desconectar();
		}
	}
	// FIN DELETE DEPARTAMENTO
	// GETBYID DEPARTAMENTO
	public Departamento getById(int codigo) {
		Departamento departamento = null;
		String sql = "{call GetDepartamentoById(?)}";
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setInt("codigo", codigo);
			ResultSet rs = cSmt.executeQuery();
			while (rs.next()) {
				departamento = parseDepartamento(rs);
			}
		}
		catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		finally {
			myConexion.desconectar();
		}
		return departamento;
	}
	// FIN GETBYID DEPARTAMENTO
	private Departamento parseDepartamento(ResultSet rs) {
		Departamento departamento = null;
		departamento = new Departamento();
		try {
			departamento.setCodigo(rs.getInt("codigo"));
			departamento.setNombre(rs.getString("nombre"));
			departamento.setDescripcion(rs.getString("descripcion"));
		}
		catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		return departamento;
	}
}
