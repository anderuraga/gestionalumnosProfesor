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
import com.ipartek.formacion.pojo.Curso;
import com.ipartek.formacion.services.Util;

public final class CursoDAOImp implements CursoDAO {

	private static final Logger LOG = Logger.getLogger(CursoDAOImp.class);
	private ConexionDB myconexion;
	private static CursoDAOImp INSTANCE;

	private CursoDAOImp() {
		myconexion = ConexionDBImp.getInstance();
	}

	public static CursoDAOImp getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CursoDAOImp();
		}
	}

	@Override
	public Curso getByID(int codigo) {
		String sql = "SELECT codCurso, c.nombre as 'nCurso', codPatrocinador, c.codTipoCurso, tc.nombre as 'tcNombre' "
				+ "FROM curso c " + " INNER JOIN tipoCurso tc ON c.codTipoCurso=tc.codTipoCurso" + " WHERE codCurso ="
				+ codigo;

		myconexion.conectar();
		Connection conexion = myconexion.getConexion();
		Curso curso = null;
		try {
			PreparedStatement pSmt = conexion.prepareStatement(sql);
			ResultSet rs = pSmt.executeQuery();
			while (rs.next()) {
				curso = parseCurso(rs);
			}
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			myconexion.desconectar();
		}
		LOG.info("getByID realizado con exito");
		return curso;
	}

	private Curso parseCurso(ResultSet rs) {
		Curso curso = null;
		curso = new Curso();
		try {
			curso.setCodigo(rs.getInt("codCurso"));
			curso.setNombre(rs.getString("nCurso"));
			curso.setTc(Util.parseTipo(String.valueOf(rs.getInt("codTipoCurso"))));
			// curso.setTc(Util.parseTipo(String.valueOf(rs.getString("tcnombre"))));
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		}

		return curso;
	}

	@Override
	public Curso update(Curso curso) {
		String sql = "{call updateCurso(?,?,?,?)}";
		Curso cur = null;

		Connection conection = myconexion.getConexion();

		try {
			CallableStatement cSmt = conection.prepareCall(sql);
			cSmt.setInt("codigo", curso.getCodigo());
			cSmt.setString("nombre", curso.getNombre());
			cSmt.setInt("codTipoCurso", curso.getTc().getCodigo());
			cSmt.setInt("codPatrocinador", curso.getTc().getCodigo());

			cSmt.executeUpdate();
			cur = curso;
			// int nFilas =
			cSmt.executeUpdate();

		} catch (SQLException e) {
			cur = getByID(curso.getCodigo());
			LOG.fatal(e.getMessage());
		} finally {
			myconexion.desconectar();
		}
		return cur;
	}

	@Override
	public Curso insert(Curso curso) {
		String sql = "{call insertCurso(?,?,?,?)}";
		Curso cur = null;

		Connection conection = myconexion.getConexion();

		try {
			CallableStatement cSmt = conection.prepareCall(sql);
			cSmt.setString("nombre", curso.getNombre());
			cSmt.setInt("codTipoCurso", curso.getTc().getCodigo());
			cSmt.setInt("codPatrocinador", curso.getTc().getCodigo());
			cSmt.executeUpdate();
			curso.setCodigo(cSmt.getInt("codigo"));
			cur = curso;
			LOG.info("Curso creado");
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			myconexion.desconectar();
		}
		return cur;
	}

	@Override
	public void delete(int codigo) {
		String sql = "{call deleteCurso(?)}";

		Connection conection = myconexion.getConexion();

		try {
			CallableStatement cSmt = conection.prepareCall(sql);
			cSmt.setInt("codigo", codigo);
			// int nFilas =
			cSmt.executeUpdate();
			LOG.info("Curso eliminado");

		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			myconexion.desconectar();
		}

	}

	@Override
	public List<Curso> getAll() {
		List<Curso> cursos = null;
		String sql = "{call getAllCurso()}";
		Connection conection = myconexion.getConexion();
		Curso curso = null;
		try {
			CallableStatement cSmt = conection.prepareCall(sql);
			ResultSet rs = cSmt.executeQuery();
			cursos = new ArrayList<Curso>();
			while (rs.next()) {
				curso = parseCurso(rs);
				cursos.add(curso);
			}
			LOG.info("getAllCurso completado");
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		} finally {
			myconexion.desconectar();
		}

		return cursos;
	}

}
