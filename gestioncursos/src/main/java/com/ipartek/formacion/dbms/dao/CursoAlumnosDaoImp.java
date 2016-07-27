package com.ipartek.formacion.dbms.dao;

import java.sql.CallableStatement;
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
     //if (codigoCurso==CursoAlumnos.CODIGO_CURSO) 
      
    
     aux=cursoAlumnos;
     aux.setCodigoEmitido(codigoCurso);
    //crear el registro en la tabla calificacion
     crearCursoModuloAlumnos(aux);
  }



  
  private void crearCursoModuloAlumnos(CursoAlumnos aux) {
    String sql="{call insert_calificacion(?,?,?)}";
    try {
      CallableStatement cSmt=myConexion.getConexion().prepareCall(sql);
      cSmt.setInt("codCurso", aux.getCodigo());
      for (AlumnoModulo  alumnoModulo : aux.getAlumnosmodulos()) {
        cSmt.setInt("codModulo", alumnoModulo.getModulo().getCodigo());
        cSmt.setInt("codAlumno",alumnoModulo.getAlumno().getCodigo());
        
        try {
          cSmt.executeUpdate();
        } catch (SQLException e) {
          LOG.fatal(e.getMessage());
        }
       
      }
    } catch (SQLException e) {
      
      LOG.fatal(e.getMessage());
    }finally {
      myConexion.desconectar();
    }
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
      Date fFin=null;
      try {
         fFin=cursoAlumnos.getFechaFin();
        cSmt.setDate("fFin", new java.sql.Date(fFin.getTime()));
      } catch (NullPointerException e) {
        LOG.trace(e.getMessage());
        cSmt.setDate("fFin", null);
        codigoCursoEmision=CursoAlumnos.CODIGO_CURSO;
      }
      cSmt.executeUpdate(sql);
      codigoCursoEmision= cSmt.getInt("codigo_emision");
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
    updateCursoEmision(cursoAlumnos);
    updateCalificacion(cursoAlumnos);
    return null;
  }




  private void updateCursoEmision(CursoAlumnos cursoAlumnos) {
    String sql="updateCursoEmicion(?,?,?,?,?)";
   
    try {
       CallableStatement cSmt=myConexion.getConexion().prepareCall(sql);
       cSmt.setInt("codCurso", cursoAlumnos.getCodigo());
       cSmt.setInt("codigoCurso",cursoAlumnos.getCodigoEmitido() );
       cSmt.setString("referencia", cursoAlumnos.getReferencia());
       cSmt.setDate("fInicio", new java.sql.Date(cursoAlumnos.getFechaInicio().getTime()));
       try {
         cSmt.setDate("fFin", new java.sql.Date(cursoAlumnos.getFechaFin().getTime()));
         
      } catch (NullPointerException e) {
       LOG.trace(e.getMessage()+" SIN FECHA FIN");
       cSmt.setDate("fFin", null);
      }
       
       cSmt.executeUpdate();
    } catch (SQLException e) {
      LOG.fatal(e.getMessage());
    }finally {
      myConexion.desconectar();
    }
    
  }

  private void updateCalificacion(CursoAlumnos cursoAlumnos) {
   String sql="{call updateCalificacion(?,?,?,?,?)}";
   
   try {
     CallableStatement cSmt=myConexion.getConexion().prepareCall(sql);
     cSmt.setInt("codigoCurso", cursoAlumnos.getCodigoEmitido());
     for (AlumnoModulo alumModulo : cursoAlumnos.getAlumnosmodulos()) {
       cSmt.setInt("cursoAlumno", alumModulo.getAlumno().getCodigo());
      cSmt.setInt("codigoModulo", alumModulo.getModulo().getCodigo());
      
    try {
      cSmt.setDate("fExamen", new java.sql.Date(alumModulo.getfExamen().getTime()));
      cSmt.setInt("nota", alumModulo.getNotaExamen());
    } catch (NullPointerException e) {
      LOG.trace(e.getMessage()+" fecha del examen sin fijar");
      cSmt.setDate("fExamen",null);
      cSmt.setInt("nota", 0);
    }
    cSmt.executeUpdate();
    }
  } catch (SQLException e) {
    LOG.fatal(e.getMessage());
  }finally {
    myConexion.desconectar();
  }
    
  }

  @Override
  public List<CursoAlumnos> getAll() {
    String sql="{call getAllCursosEmitidos()}";
    List<CursoAlumnos> cursoAlumnos=null;
    try {
      CallableStatement cSmt=myConexion.getConexion().prepareCall(sql);
      ResultSet rs=cSmt.executeQuery();
      cursoAlumnos=new ArrayList<CursoAlumnos>();
      while (rs.next()) {
        CursoAlumnos cAlumnos=parseCursoAlumnos(rs);
        cursoAlumnos.add(cAlumnos);
      }
    } catch (SQLException e) {
      LOG.fatal(e.getMessage());
      
    }finally {
      myConexion.desconectar();
    }
    return cursoAlumnos;
  }

  private CursoAlumnos parseCursoAlumnos(ResultSet rs) {
    CursoAlumnos cAlumnos=null;
   
    try {
      cAlumnos=new CursoAlumnos();
      cAlumnos.setCodigo(rs.getInt("codigo"));
      cAlumnos.setCodigoEmitido(rs.getInt("codigoEmitido"));
      cAlumnos.setCodPatrocinador(rs.getString("codigoPatrocinador"));
      cAlumnos.setNombre(rs.getString("nombre"));
      cAlumnos.setReferencia(rs.getString("referencia"));
      cAlumnos.setFechaInicio(rs.getDate("fInicio"));
      cAlumnos.setFechaFin(rs.getDate("fFin"));
      int codigo=rs.getInt("codigotipoCurso");
      cAlumnos.setTipo(Util.parseTipo(codigo));
    
    } catch (SQLException e) {
     LOG.fatal(e.getMessage());
    }
    return cAlumnos;
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
