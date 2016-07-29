package com.ipartek.formacion.dbms.DAO;

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

public class DepartamentoDAOImp implements DepartamentoDAO {
	private static final Logger LOG = Logger.getLogger(DepartamentoDAOImp.class);
	private ConexionDB myconexion;
	private static DepartamentoDAOImp INSTANCE;

	private DepartamentoDAOImp() {
		myconexion = ConexionDBImp.getInstance();
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

	@Override
	public Departamento update(Departamento departamento) {
		String sql = "{call updateDepartamento(?,?,?,?)}";
		Departamento dep = null;

		Connection conection = myconexion.getConexion();

		try {
			CallableStatement cSmt = conection.prepareCall(sql);
			cSmt.setInt("codigo", departamento.getCodigo());
			cSmt.setString("nombre", departamento.getNombre());
			cSmt.setString("descripcion", departamento.getDescripcion());

			cSmt.executeUpdate();
			dep = departamento;

		} catch (SQLException e) {
			dep = getByID(departamento.getCodigo());
			LOG.fatal(e.getMessage());
		} finally {
			myconexion.desconectar();
		}
		return dep;
	}

	@Override
	public Departamento insert(Departamento departamento) {
		String sql = "{call insertDepartamento(?,?,?)}";
		Departamento des = null;

		Connection conection = myconexion.getConexion();

		try {
			CallableStatement cSmt = conection.prepareCall(sql);
			cSmt.setString("nombre", departamento.getNombre());
			cSmt.setString("descripcion", departamento.getDescripcion());

			cSmt.executeUpdate();
			departamento.setCodigo(cSmt.getInt("codigo"));
			des = departamento;

		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			myconexion.desconectar();
		}
		return des;
	}

	@Override
	public Departamento getByID(int codigo) {
		String sql = "{call getByIDDepartamento(?)}";

		myconexion.conectar();
		Connection conexion = myconexion.getConexion();
		Departamento departamento = null;
		try {
			PreparedStatement pSmt = conexion.prepareStatement(sql);
			ResultSet rs = pSmt.executeQuery();
			while (rs.next()) {
				departamento = parseDepartamento(rs);
			}
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			myconexion.desconectar();
		}

		return departamento;
	}

	private Departamento parseDepartamento(ResultSet rs) {
		Departamento departamento = null;
		departamento = new Departamento();
		try {
			departamento.setCodigo(rs.getInt("codDepartamento"));
			departamento.setNombre(rs.getString("nombre"));
			departamento.setDescripcion(rs.getString("descripcion"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.fatal(e.getMessage());
		}

		return departamento;
	}

	@Override
	public void delete(int codigo) {
		String sql = "{call deleteDepartamento(?)}";

		Connection conection = myconexion.getConexion();

		try {
			CallableStatement cSmt = conection.prepareCall(sql);
			cSmt.setInt("codigo", codigo);
			// int nFilas =
			cSmt.executeUpdate();

		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			myconexion.desconectar();
		}

	}

	@Override
	public List<Departamento> getAll() {
		List<Departamento> departamentos = null;
		String sql = "{call getAllDepartamento()}";

		Connection conection = myconexion.getConexion();
		Departamento departamento = null;
		try {
			CallableStatement cSmt = conection.prepareCall(sql);
			ResultSet rs = cSmt.executeQuery();
			departamentos = new ArrayList<Departamento>();
			while (rs.next()) {
				departamento = parseDepartamento(rs);
				departamentos.add(departamento);
			}
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			myconexion.desconectar();
		}

		return departamentos;
	}

}
