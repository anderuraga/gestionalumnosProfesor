package com.ipartek.formacion.dbms.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.pojo.CursoAlumnos;
import com.ipartek.formacion.pojo.CursoAlumnos.AlumnoModulo;
import com.ipartek.formacion.service.Util;

public class CursoAlumnosDAOImp implements CursoAlumnosDAO {

	private static final Logger LOG=Logger.getLogger(CursoAlumnosDAOImp.class);
	private static CursoAlumnosDAOImp INSTANCE=null;
	private ConexionDB dbConnection;
	

	private CursoAlumnosDAOImp() {
		dbConnection = ConexionDBImp.getInstance();
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CursoAlumnosDAOImp();
		}
	}

	public static CursoAlumnosDAOImp getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	
	@Override
	public void createCursoAlumnos(CursoAlumnos cursoAlumnos) {
		//dar de alta en la tabla curso_emision
		//crear el registro en la tablacalificacion
		CursoAlumnos aux=null;
		int codigoCurso=createCursoEmision(cursoAlumnos);
		if (codigoCurso==CursoAlumnos.CODIGO_CURSO) {
			
		}
		aux=cursoAlumnos;
		aux.setCodigoEmitido(codigoCurso);
		

	}

	

	private int createCursoEmision(CursoAlumnos cursoAlumnos) {
		Connection conexion=dbConnection.getConexion();
		int codigoCursoEmision=CursoAlumnos.CODIGO_CURSO;
		String sql="{call insertCurso_emision()}";
		try {
			CallableStatement cStat=conexion.prepareCall(sql);
			cStat.setInt("codCurso", cursoAlumnos.getCodigo());
			cStat.setString("referencia", cursoAlumnos.getReferencia());
			cStat.setDate("fInicio", new java.sql.Date(cursoAlumnos.getFechaInicio().getTime()));
			try {
				Date fFin=cursoAlumnos.getFechaFin();
				cStat.setDate("fFin", new java.sql.Date(fFin.getTime()));
			} catch (NullPointerException e) {
				LOG.trace(e.getMessage());
				cStat.setDate("fFin",null);
			}
			
			cStat.executeUpdate();
			codigoCursoEmision=cStat.getInt("codigoEmision");
			
			
			
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
			codigoCursoEmision=CursoAlumnos.CODIGO_CURSO;
		}finally{
			dbConnection.desconectar();
		}
		
		return codigoCursoEmision;
	}

	@Override
	public void updateCursoAlumnos(CursoAlumnos cursoAlumnos) {
		updateCursoEmision(cursoAlumnos);
		updateCalificacion(cursoAlumnos);

	}
	
	private void updateCalificacion(CursoAlumnos cursoAlumnos) {
		String sql="{call updateCalificacion(?,?,?,?,?)}";
		Connection conexion=dbConnection.getConexion();
		try {
			CallableStatement cStat= conexion.prepareCall(sql);
			cStat.setInt("codCurso", cursoAlumnos.getCodigo());
			for (CursoAlumnos.AlumnoModulo aModulo  : cursoAlumnos.getAlumnosModulos()) {
				cStat.setInt("codAlumno", aModulo.getAlumno().getCodigo());
				cStat.setInt("codModulo", aModulo.getModulo().getCodModulo());
				try {
				cStat.setDate("fExamen", new java.sql.Date(aModulo.getfExamen().getTime()));
				cStat.setInt("nota", aModulo.getNotaExamen());
				
				} catch (NullPointerException e) {
					LOG.trace(e.getMessage()+"fecha del examen sin fijar");
					cStat.setDate("fExamen",null);
					cStat.setInt("nota", 0);
				}
				try {
					cStat.executeUpdate();
				} catch (SQLException e) {
					LOG.fatal(e.getMessage());
				}
			}
			
			
			
		} catch (SQLException e) {
			LOG.trace(e.getMessage());
		}finally {
			dbConnection.desconectar();
		}
	}

	private void updateCursoEmision(CursoAlumnos cursoAlumnos) {
		String sql="{call updateCursoEmision(?,?,?,?,?)}";
		Connection conexion=dbConnection.getConexion();
		try {
			CallableStatement cStat= conexion.prepareCall(sql);
			cStat.setInt("codCurso", cursoAlumnos.getCodigo());
			cStat.setInt("codigoCurso", cursoAlumnos.getCodigoEmitido());
			cStat.setString("referencia", cursoAlumnos.getReferencia());
			cStat.setDate("fInicio", new java.sql.Date(cursoAlumnos.getFechaInicio().getTime()));
			try {
				Date fFin=cursoAlumnos.getFechaFin();
				cStat.setDate("fFin", new java.sql.Date(fFin.getTime()));
			} catch (NullPointerException e) {
				LOG.trace(e.getMessage());
				cStat.setDate("fFin",null);
			}
			cStat.executeUpdate();
		} catch (SQLException e) {
			LOG.trace(e.getMessage());
		}
		
		
	}

	private void createCursoModuloAlumnos(CursoAlumnos aux){
		String sql="{call insertCalificacion(?,?,?)}";
		Connection conexion=dbConnection.getConexion();
		try {
			CallableStatement cStat=conexion.prepareCall(sql);
			
			cStat.setInt("codCurso", aux.getCodigo());
			for (CursoAlumnos.AlumnoModulo aModulo  : aux.getAlumnosModulos()) {
				cStat.setInt("codAlumno", aModulo.getAlumno().getCodigo());
				cStat.setInt("codModulo", aModulo.getModulo().getCodModulo());
				try {
					cStat.executeUpdate();
				} catch (SQLException e) {
					LOG.fatal(e.getMessage());
				}
			}
			
			
			
			
		} catch (SQLException e) {
			LOG.trace(e.getMessage());
		}	
		
		
		
		
	}

	@Override
	public CursoAlumnos getById(int codCurso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CursoAlumnos> getAll() {
		String sql="{call getAllCursosEmitidos()}";
		List<CursoAlumnos>cursoAlumnos=null;
		Connection conexion=dbConnection.getConexion();
		try {
			CallableStatement cStat=conexion.prepareCall(sql);
			ResultSet rS=cStat.executeQuery();
			cursoAlumnos=new ArrayList<CursoAlumnos>();
			while (rS.next()) {
				cursoAlumnos.add(parseCursoAlumnos(rS));
				
			}
			
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		}
		return cursoAlumnos;
	}

	private CursoAlumnos parseCursoAlumnos(ResultSet rS) {
		CursoAlumnos cAlumnos=null;
		cAlumnos=new CursoAlumnos();
		try {
			cAlumnos.setCodigo(rS.getInt("codigo"));
			cAlumnos.setCodigoEmitido(rS.getInt("codigoEmitido"));
			cAlumnos.setCodPatrocinador(rS.getString("codPatrocinador"));
			cAlumnos.setNombre(rS.getString("nombre"));
			cAlumnos.setReferencia(rS.getString("referencia"));
			cAlumnos.setFechaInicio(rS.getDate("fInicio"));
			cAlumnos.setFechaFin(rS.getDate("fFin"));
			int tC=rS.getInt("codigoTipoCurso");
			
			cAlumnos.setTipoCurso(Util.parseTipoCurso(tC));
			
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
		}
		
		return cAlumnos;
	}

	@Override
	public CursoAlumnos getByAlumnoId(int codigoAlumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmitidos(int codigoCurso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCalificacion(CursoAlumnos cursoAlumno) {
		// TODO Auto-generated method stub
		
	}

}
