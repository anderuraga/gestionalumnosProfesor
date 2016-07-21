package com.ipartek.formacion.dbms.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.pojo.DuracionModulo;
import com.ipartek.formacion.pojo.Genero;
import com.ipartek.formacion.pojo.Modulo;
import com.ipartek.formacion.pojo.exception.CandidatoException;

public class ModuloDAOImp implements ModuloDAO {

	private static final Logger LOG = Logger.getLogger(ModuloDAOImp.class);
	private ConexionDBImp myConexion;
	private static ModuloDAOImp INSTANCE = null;
	
	private ModuloDAOImp(){
		myConexion = ConexionDBImp.getInstance();
	}
	
	private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new ModuloDAOImp();
        }
    }

    public static ModuloDAOImp getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
	
	@Override
	public Modulo getById(int codigo) {
		Modulo modulo = null;

		String sql = "{call getModuloById(?)}";
		Connection conection = myConexion.getConexion();
		
		try {
			CallableStatement cSmt = conection.prepareCall(sql);
			cSmt.setInt("codigo", codigo);
			ResultSet rs = cSmt.executeQuery();
			
			while(rs.next()){
				modulo = parseModulo(rs);
			}
		} catch (SQLException e) {
			LOG.error("Error - SQLException: "+ sql + e.getMessage());
		} finally{
			myConexion.desconectar();
		}
		
		return modulo;
	}
	
	@Override
	public List<Modulo> getAll() {
		List<Modulo> modulos = null;
		String sql = "{call getAllModulo()}";
		Connection conection = myConexion.getConexion();
		
		try {
			Modulo modulo = null;
			CallableStatement cSmt = conection.prepareCall(sql);
			ResultSet rs = cSmt.executeQuery();
			modulos = new ArrayList<Modulo>();
			
			while(rs.next()){
				modulo = parseModulo(rs);
				modulos.add(modulo);
			}
		} catch (NullPointerException e) {
			LOG.fatal("Error - NullPointerException: " + e.getMessage());
		} catch (SQLException e) {
			LOG.fatal("Error - SQLException: "+sql+" " + e.getMessage());
		} finally{
			myConexion.desconectar();
		}

		return modulos;
	}

	private Modulo parseModulo(ResultSet rs) {
		Modulo modulo = null;
		modulo = new Modulo();
		
		try {
			modulo.setCodigo(rs.getInt("codModulo"));
			modulo.setNombre(rs.getString("nombre"));
			modulo.setReferencia(rs.getString("uFormativa"));
			int duracion = rs.getInt("duracion");
			
			if(duracion == DuracionModulo.HORAS15.getValor()){
				modulo.setDuracion(DuracionModulo.HORAS15);
			} else{
				if(duracion == DuracionModulo.HORAS20.getValor()){
					modulo.setDuracion(DuracionModulo.HORAS20);
				} else{
					if(duracion == DuracionModulo.HORAS30.getValor()){
						modulo.setDuracion(DuracionModulo.HORAS30);
					} else{
						if(duracion == DuracionModulo.HORAS45.getValor()){
							modulo.setDuracion(DuracionModulo.HORAS45);
						} else{
							if(duracion == DuracionModulo.HORAS80.getValor()){
								modulo.setDuracion(DuracionModulo.HORAS80);
							} else{
								if(duracion == DuracionModulo.HORAS90.getValor()){
									modulo.setDuracion(DuracionModulo.HORAS90);
								}
							}
						} 
					}
				}
			} 
			
		} catch (SQLException e) {
			LOG.fatal("Error: " + e.getMessage());
		} 
		
		return modulo;
	}

	@Override
	public Modulo update(Modulo modulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Modulo insert(Modulo modulo) {
		Modulo modul = null;
		
		String sql = "{call insertModulo (?, ?, ?, ?)}";
		Connection conection = myConexion.getConexion();
		
		try {
			CallableStatement cSmt = conection.prepareCall(sql);
			
			LOG.trace(modulo.toString());
			
			cSmt.setString("nombre", modulo.getNombre());
			cSmt.setString("uFormativa", modulo.getReferencia());
			cSmt.setInt("duracion", modulo.getDuracion().getValor());;
			
			cSmt.executeUpdate();
			modul = modulo;
			modul.setCodigo(cSmt.getInt("codModulo"));
		} catch (SQLException e) {
			LOG.fatal("Error - SQLException: " + e.getMessage());
		} catch (NullPointerException e){
			LOG.fatal("Error - NullPointerException: " + e.getMessage());
		}
		finally{
			myConexion.desconectar();
		}
		
		return modul;
	}

	@Override
	public void delete(int codigo) {
		String sql = "{call deleteModulo(?)}";
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
