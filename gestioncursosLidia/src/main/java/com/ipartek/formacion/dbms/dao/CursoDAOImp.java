package com.ipartek.formacion.dbms.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.pojo.Curso;

public class CursoDAOImp implements CursoDAO{
	private final static Logger LOG = Logger.getLogger(CursoDAOImp.class);

	private ConexionDB myConexion;
	private static CursoDAOImp INSTANCE;
	private Connection conexion;
	private CursoDAOImp() {
		myConexion = ConexionDBImp.getInstance();
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CursoDAOImp();
		}
	}

	public static CursoDAOImp getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}


	@Override
	public Curso getById(int codigo) {
		conexion = myConexion.getConexion();
		String sql = "{call getCursoById(?)}";
		Curso curso=null;
		try {
			
			CallableStatement cSmt = conexion.prepareCall(sql);
			cSmt.setInt("codigo", codigo);
			ResultSet rs = cSmt.executeQuery();
			
			while (rs.next()) {
				//curso=parseCurso(rs);
							
			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
		} finally {
			myConexion.desconectar();
		}
		
		return curso;
	}

	@Override
	public Curso update(Curso curso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curso create(Curso curso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Curso> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
