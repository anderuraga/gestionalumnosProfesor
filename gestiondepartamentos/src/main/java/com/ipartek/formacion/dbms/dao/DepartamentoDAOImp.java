package com.ipartek.formacion.dbms.dao;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.pojo.Departamento;
import com.ipartek.formacion.pojo.Empleado;
import com.ipartek.formacion.service.Util;
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
	public List<Departamento> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public Departamento UpdateDepartamento(Departamento departamento) {
		// TODO Auto-generated method stub
		return null;
	}
	public void DeleteDepartamento(int departamento) {
		// TODO Auto-generated method stub
	}
	public Departamento getById(int departamento) {
		// TODO Auto-generated method stub
		return null;
	}
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
