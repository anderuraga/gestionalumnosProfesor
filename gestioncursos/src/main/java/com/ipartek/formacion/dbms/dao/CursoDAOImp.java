package com.ipartek.formacion.dbms.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.pojo.Curso;
import com.ipartek.formacion.pojo.DuracionModulo;
import com.ipartek.formacion.pojo.Modulo;
import com.ipartek.formacion.pojo.TipoCurso;

public class CursoDAOImp implements CursoDAO {

	private static final Logger LOG = Logger.getLogger(CursoDAOImp.class);
	private ConexionDBImp myConexion;
	private static CursoDAOImp INSTANCE = null;
	
	private CursoDAOImp(){
		myConexion = ConexionDBImp.getInstance();
	}
	
	private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new CursoDAOImp();
        }
    }

    public static CursoDAOImp getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
	
	@Override
	public Curso getById(int codigo) {
		Curso curso = null;

		String sql = "{call getCursoById(?)}";
		Connection conection = myConexion.getConexion();
		
		try {
			CallableStatement cSmt = conection.prepareCall(sql);
			cSmt.setInt("codigo", codigo);
			ResultSet rs = cSmt.executeQuery();
			
			while(rs.next()){
				curso = parseCurso(rs);
			}
		} catch (SQLException e) {
			LOG.error("Error - SQLException: "+ sql + e.getMessage());
		} finally{
			myConexion.desconectar();
		}
		
		return curso;
	}
	
	@Override
	public List<Curso> getAll() {
		List<Curso> cursos = null;
		String sql = "{call getAllCurso()}";
		Connection conection = myConexion.getConexion();
		
		try {
			Curso curso = null;
			CallableStatement cSmt = conection.prepareCall(sql);
			ResultSet rs = cSmt.executeQuery();
			cursos = new ArrayList<Curso>();
			
			while(rs.next()){
				curso = parseCurso(rs);
				cursos.add(curso);
			}
		} catch (NullPointerException e) {
			LOG.fatal("Error - NullPointerException: " + e.getMessage());
		} catch (SQLException e) {
			LOG.fatal("Error - SQLException: "+sql+" " + e.getMessage());
		} finally{
			myConexion.desconectar();
		}

		return cursos;
	}

	private Curso parseCurso(ResultSet rs) {
		Curso curso = new Curso();
		
		try {
			curso.setCodigo(rs.getInt("codCurso"));
			curso.setNombre(rs.getString("nCurso"));
			curso.setReferencia(rs.getString("codPatrocinador"));
			int tipocurso = rs.getInt("codTipoCurso");
			
			if(tipocurso == TipoCurso.LANBIDE.getCodigo()){
				curso.setTipoCurso(TipoCurso.LANBIDE);
			} else{
				if(tipocurso == TipoCurso.HOBETUZ.getCodigo()){
					curso.setTipoCurso(TipoCurso.HOBETUZ);
				} else{
					if(tipocurso == TipoCurso.FORMACION_TRIPARTITA.getCodigo()){
						curso.setTipoCurso(TipoCurso.FORMACION_TRIPARTITA);
					}
				}
			} 
			
		} catch (SQLException e) {
			LOG.fatal("Error: " + e.getMessage());
		} 
		
		return curso;
	}

	@Override
	public Curso update(Curso curso) {
		Curso curs = null;
		
		String sql = "{call updateCurso(?, ?, ?, ?)}";
		Connection conection = myConexion.getConexion();

		try {
			
			CallableStatement cSmt = conection.prepareCall(sql);
			LOG.trace(curso.toString());
			
			cSmt.setInt("codigo", curso.getCodigo());
			cSmt.setString("nombre", curso.getNombre());
			cSmt.setString("codPatrocinador", curso.getReferencia());
			cSmt.setInt("codTipo", curso.getTipoCurso().getCodigo());
			
			cSmt.executeUpdate();
			curs = curso;
		} catch (SQLException e) {
			LOG.fatal("Error - SQLException: " + e.getMessage());
		} catch (NullPointerException e){
			LOG.fatal("Error - NullPointerException: " + e.getMessage());
		} finally{
			myConexion.desconectar();
		}
		
		return curs;
	}

	@Override
	public Curso insert(Curso curso) {
		Curso curs = null;
		
		String sql = "{call insertCurso (?, ?, ?, ?)}";
		Connection conection = myConexion.getConexion();
		
		try {
			CallableStatement cSmt = conection.prepareCall(sql);
			
			LOG.trace(curso.toString());
			
			cSmt.setString("nombre", curso.getNombre());
			cSmt.setString("codPatrocinador", curso.getReferencia());
			cSmt.setInt("codTipoCurso", curso.getTipoCurso().getCodigo());
			
			cSmt.executeUpdate();
			curs = curso;
			curso.setCodigo(cSmt.getInt("codCurso"));
		} catch (SQLException e) {
			LOG.fatal("Error - SQLException: " + e.getMessage());
		} catch (NullPointerException e){
			LOG.fatal("Error - NullPointerException: " + e.getMessage());
		}
		finally{
			myConexion.desconectar();
		}
		
		return curs;
	}

	@Override
	public void delete(int codigo) {
		String sql = "{call deleteCurso(?)}";
		Connection conection = myConexion.getConexion();
		
		try {
			CallableStatement cSmt = conection.prepareCall(sql);
			cSmt.setInt("codigo", codigo);
			cSmt.executeUpdate();
		} catch (SQLException e) {
			LOG.fatal("Error - SQLException: " + e.getMessage());
		} finally{
			myConexion.desconectar();
		}
	}
}
