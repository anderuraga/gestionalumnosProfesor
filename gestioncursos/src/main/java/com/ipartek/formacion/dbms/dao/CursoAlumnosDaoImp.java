package com.ipartek.formacion.dbms.dao;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.dbms.ConexionDBImp;
import com.ipartek.formacion.pojo.CursoAlumnos;
/**
 * Clase que se encarga de gestionar las altas, bajas y modificaciones en los cursos emitidos.
 * 
 * @author Curso
 *
 */
public class CursoAlumnosDaoImp implements CursoAlumnosDao{
  private static CursoAlumnosDaoImp INSTANCE=null;
  private static final Logger LOG=Logger.getLogger(CursoAlumnosDaoImp.class);
  private ConexionDB myConexion;


    private CursoAlumnosDaoImp(){
      myConexion=ConexionDBImp.getInstance();
    }
    
    private synchronized static void createInstance() {
      if (INSTANCE == null) {
        INSTANCE = new CursoAlumnosDaoImp();
      }
    }
    
    public static CursoAlumnosDaoImp getInstance(){
     if (INSTANCE==null) {
         createInstance();
    } 
     return INSTANCE;
    }
    
    
  
  
  
  @Override
  public void create(CursoAlumnos cursoAlumnos) {
    // dar de alta en la tabla curso emitidos
    CursoAlumnos aux=null;
     int codigoCurso=createCursoEmision(cursoAlumnos);
     aux=cursoAlumnos;
     aux.setCodigoEmitido(codigoCurso);
    //crear el registro en la tabla calificacion
     crearCursoModuloAlumnos(aux);
  }



  
  private void crearCursoModuloAlumnos(CursoAlumnos aux) {
    // TODO Auto-generated method stub
    
  }

  private int createCursoEmision(CursoAlumnos cursoAlumnos) {
    int codigoCursoEmision=CursoAlumnos.CODIGO_CURSO;
    
    String sql="{call insertCurso_Emision(?,?,?,?,?)}";
    
    try {
      CallableStatement cSmt=myConexion.getConexion().prepareCall(sql);
      cSmt.setInt("codCurso", cursoAlumnos.getCodigo());
      cSmt.setString("referencia", cursoAlumnos.getReferencia());
      cSmt.setDate("fInicio", new java.sql.Date(cursoAlumnos.getFechaInicio().getTime()));
      cSmt.setDate("fFin", new java.sql.Date(cursoAlumnos.getFechaFin().getTime()));
      
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      LOG.fatal(e.getMessage());
    }catch (NullPointerException e) {
      //meter el null pointer exception
      LOG.fatal(e.getMessage());
    }catch ( Exception e) {
      LOG.fatal(e.getMessage());
    }
    
    finally {
      myConexion.desconectar();
      LOG.info("desconectado createCursoEmision");
    }
    
    return codigoCursoEmision;
  }

  @Override
  public void deleteEmitidos(int codigoCurso) {
    // Si queremos borrar un registro de las dos tablas 
    
  }
  
  @Override
  public CursoAlumnos getById(int codigoCurso) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public CursoAlumnos update(CursoAlumnos cursoAlumnos) {
    // TODO Auto-generated method stub
    return null;
  }




  @Override
  public List<CursoAlumnos> getAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public CursoAlumnos getByAlumno(int codigoAlumno) {
    // TODO Auto-generated method stub
    return null;
  }





  @Override
  public void deleteCalificacion(CursoAlumnos cursoAlumnos) {
    // TODO Auto-generated method stub
    
  }


  @Override
  public void addModulosAlumnos(CursoAlumnos cursoAlumnos) {
    // TODO Auto-generated method stub
    
  }

}
