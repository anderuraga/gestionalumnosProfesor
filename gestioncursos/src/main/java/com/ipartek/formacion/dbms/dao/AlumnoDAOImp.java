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
import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.pojo.exception.CandidatoException;
import com.ipartek.formacion.service.Util;

public class AlumnoDAOImp implements AlumnoDAO {

  private static final Logger LOG = Logger.getLogger(AlumnoDAOImp.class);
  private ConexionDB conexionDB;
  private static AlumnoDAOImp INSTANCE;

  private AlumnoDAOImp() {

    conexionDB = ConexionDBImp.getInstance();
  }

  public static AlumnoDAOImp getInstance() {
    if (INSTANCE == null) {
      createInstance();
    }
    return INSTANCE;
  }

  private synchronized static void createInstance() {
    if (INSTANCE == null) {
      INSTANCE = new AlumnoDAOImp();
    }
  }

  // TODO es sigleton
  // pq va a tener el atributo que es la conexion
  @Override
  public Alumno getById(int codigo) {
    Alumno alumno = null;
    String sql = "SELECT codAlumno, a.nombre as 'nAlumno', apellidos, email,telefono,dni_nie,fNacimiento, a.codGenero, g.nombre as 'nGenero'"
        + " FROM alumno a "
        + "	INNER JOIN genero g ON g.codGenero = a.codGenero"
        + " WHERE codAlumno =" + codigo;
    // ConexionDB dbConnection = ConexionDBImp.getInstance();
    conexionDB.conectar();
    Connection conexion = conexionDB.getConexion();
    try {

      PreparedStatement pSmt = conexion.prepareStatement(sql);// El preparedStatement es sin rutina
                                                              // en la base de datos
      ResultSet rs = pSmt.executeQuery();
      while (rs.next()) {
        alumno = this.parseAlumno(rs);
      }

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      conexionDB.desconectar();
    }

    return alumno;
  }

  private Alumno parseAlumno(ResultSet rs) {
    Alumno alumno = null;
    alumno = new Alumno();
    try {
      alumno.setCodigo(rs.getInt("codAlumno"));
      alumno.setNombre(rs.getString("nAlumno"));
      alumno.setApellidos(rs.getString("apellidos"));
      alumno.setDni(rs.getString("dni_nie"));
      alumno.setEmail(rs.getString("email"));
      alumno.setTelefono(rs.getString("telefono"));
      alumno.setGenero(Util.parseGenero(String.valueOf(rs.getInt("codGenero"))));
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (CandidatoException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return alumno;
  }

  @Override
  public Alumno update(Alumno alumno) {

    Alumno alu = null;
    String sql = "{call updateAlumno(?,?,?,?,?,?,?,?)}";// tantas
    // interrogaciones
    // como campos
    // queremos cambiar
    // en la BBDD
    // ConexionDB conexionDB = ConexionDBImp.getInstance();
    conexionDB.conectar();
    Connection connection = conexionDB.getConexion();

    try {
      CallableStatement cStatement = connection.prepareCall(sql); // Por el contrario el
                                                                  // CallableStatement es cuando
                                                                  // tenemos la rutina en la bb.dd
      cStatement.setInt("codigo", alumno.getCodigo());
      cStatement.setString("nombre", alumno.getNombre());
      cStatement.setString("apellidos", alumno.getApellidos());
      cStatement.setString("dni", alumno.getDni());
      cStatement.setDate("fecha", new java.sql.Date(alumno.getfNacimiento().getTime()));
      cStatement.setInt("codGenero", alumno.getGenero().getCodigo());
      cStatement.setString("email", alumno.getEmail());
      cStatement.setString("telefono", alumno.getTelefono());

      cStatement.executeUpdate();
      alu = alumno;
    } catch (SQLException e) {
      alu = getById(alumno.getCodigo());
      LOG.fatal(e.getMessage());
    } finally {
      conexionDB.desconectar();
    }
    return alu;
  }

  @Override
  public Alumno create(Alumno alumno) {
    // LOG.info("entra aqui");
    String sql = "{call insertAlumno(?,?,?,?,?,?,?,?)}";
    Alumno alu = null;
    // ConexionDB conexionDB = ConexionDBImp.getInstance();
    conexionDB.conectar();
    Connection connection = conexionDB.getConexion();

    try {
      CallableStatement cStatement = connection.prepareCall(sql);
      LOG.info("entra aqui");
      cStatement.setString("nombre", alumno.getNombre());
      LOG.info("El nombre es: " + alumno.getNombre());
      cStatement.setString("apellidos", alumno.getApellidos());
      LOG.info("El apellido es: " + alumno.getApellidos());
      cStatement.setString("dni", alumno.getDni());
      LOG.info("El dni es: " + alumno.getDni());
      cStatement.setDate("fecha", new java.sql.Date(alumno.getfNacimiento().getTime()));
      LOG.info("La fecha es: " + alumno.getfNacimiento());
      cStatement.setString("email", alumno.getEmail());
      LOG.info("El email es: " + alumno.getEmail());
      cStatement.setString("telefono", alumno.getTelefono());
      cStatement.setInt("codGenero", alumno.getGenero().getCodigo());
      LOG.info("genero" + alumno.getGenero().getCodigo());
      cStatement.executeUpdate();
      alu = alumno;
      alu.setCodigo(cStatement.getInt("codAlumno"));
      LOG.info("El codigo del alumno es: " + alu.getCodigo());
    } catch (SQLException e) {
      LOG.fatal(e.getMessage());
      alu = getById(alumno.getCodigo());
    } finally {
      conexionDB.desconectar();
    }

    return alu;
  }

  @Override
  public void delete(int codigo) {

    String sql = "{call deleteAlumno(?)}";
    // ConexionDB conexionDB = ConexionDBImp.getInstance();
    conexionDB.conectar();
    Connection connection = conexionDB.getConexion();
    try {
      CallableStatement cStatement = connection.prepareCall(sql);
      cStatement.setInt("codigo", codigo);// el primer parametro para
      // indicar que dato le estamos
      // introduciendo puede ser o un
      // int o un string (num columna
      // o nombre) utilizar siempre
      // nombre porque lo otro es un
      // jaleo
      int nFilas = cStatement.executeUpdate(); // ¿Cuantas filas hemos
      // borrado? si no es un
      // uno esta mal
    } catch (SQLException e) {
      LOG.fatal(e.getMessage());
    } finally {
      conexionDB.desconectar();
    }
  }

  @Override
  public List<Alumno> getAll() {
    List<Alumno> alumnos = null;
    String sql = "{call getAllAlumno()}";
    // LOG.fatal("Me entra en mostrar alumnos");
    // ConexionDB myConexion = ConexionDBImp.getInstance();
    Connection conection = conexionDB.getConexion();
    try {
      Alumno alumno = null;
      CallableStatement cSmt = conection.prepareCall(sql);
      ResultSet rs = cSmt.executeQuery();
      alumnos = new ArrayList<Alumno>();
      while (rs.next()) {
        alumno = parseAlumno(rs);
        alumnos.add(alumno);
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      conexionDB.desconectar();
    }
    return alumnos;
  }

}
